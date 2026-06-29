package com.app.lotus.admin.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * 管理サイト (/admin/**) のリクエストをログに記録するフィルター。
 * このクラスは com.app.lotus.admin パッケージ配下のため、
 * logback-spring.xml の admin ロガー設定により admin ファイルへ出力される。
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class AdminRequestLoggingFilter extends OncePerRequestFilter {

    private static final Logger log = LoggerFactory.getLogger(AdminRequestLoggingFilter.class);

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        return !request.getRequestURI().startsWith("/admin/");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {

        long start = System.currentTimeMillis();
        String method = request.getMethod();
        String uri = request.getRequestURI();
        String ip = resolveClientIp(request);

        log.info("→ {} {}  [{}]", method, uri, ip);

        try {
            chain.doFilter(request, response);

            long elapsed = System.currentTimeMillis() - start;
            int status = response.getStatus();
            if (status >= 500) {
                log.error("← {} {} {} ({}ms)", status, method, uri, elapsed);
            } else if (status >= 400) {
                log.warn("← {} {} {} ({}ms)", status, method, uri, elapsed);
            } else {
                log.info("← {} {} {} ({}ms)", status, method, uri, elapsed);
            }

        } catch (Exception e) {
            long elapsed = System.currentTimeMillis() - start;
            log.error("← ERR {} {} ({}ms) : {}", method, uri, elapsed, e.getMessage(), e);
            throw e;
        }
    }

    private String resolveClientIp(HttpServletRequest request) {
        String forwarded = request.getHeader("X-Forwarded-For");
        if (forwarded != null && !forwarded.isEmpty()) {
            return forwarded.split(",")[0].trim();
        }
        return request.getRemoteAddr();
    }
}

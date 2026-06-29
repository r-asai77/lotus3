package com.app.lotus.user.filter;

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
import java.util.Set;

/**
 * ユーザーサイトのリクエストをログに記録するフィルター。
 * このクラスは com.app.lotus.user パッケージ配下のため、
 * logback-spring.xml の user ロガー設定により user ファイルへ出力される。
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE + 1)
public class UserRequestLoggingFilter extends OncePerRequestFilter {

    private static final Logger log = LoggerFactory.getLogger(UserRequestLoggingFilter.class);

    // ログ対象外のパスプレフィックス（静的リソース・管理サイト）
    private static final Set<String> EXCLUDED_PREFIXES = Set.of(
            "/admin/", "/css/", "/js/", "/images/", "/favicon"
    );

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String uri = request.getRequestURI();
        return EXCLUDED_PREFIXES.stream().anyMatch(uri::startsWith);
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

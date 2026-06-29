package com.app.lotus.admin.auth.exception;

public class DuplicateAdminLoginIdException extends RuntimeException {
    public DuplicateAdminLoginIdException() {
        super("このログインIDはすでに使用されています");
    }
}

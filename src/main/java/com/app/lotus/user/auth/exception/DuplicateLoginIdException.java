package com.app.lotus.user.auth.exception;

public class DuplicateLoginIdException extends RuntimeException {
    public DuplicateLoginIdException() {
        super("このログインIDはすでに使用されています");
    }
}

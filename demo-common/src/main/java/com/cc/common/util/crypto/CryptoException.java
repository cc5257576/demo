package com.cc.common.util.crypto;

import java.text.MessageFormat;

/**
 * 加密异常
 * @author Looly
 *
 */
public class CryptoException extends RuntimeException {
    private static final long serialVersionUID = 8068509879445395353L;

    public CryptoException(Throwable e) {
        super(MessageFormat.format("{}: {}", e.getClass().getSimpleName(), e.getMessage()), e);
    }

    public CryptoException(String message) {
        super(message);
    }

    public CryptoException(String messageTemplate, Object... params) {
        super(MessageFormat.format(messageTemplate, params));
    }

    public CryptoException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public CryptoException(Throwable throwable, String messageTemplate, Object... params) {
        super(MessageFormat.format(messageTemplate, params), throwable);
    }
}

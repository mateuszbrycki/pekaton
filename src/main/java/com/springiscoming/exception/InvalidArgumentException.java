package com.springiscoming.exception;

/**
 * Created by winio_000 on 2016-06-19.
 */
public class InvalidArgumentException extends RuntimeException {
    public InvalidArgumentException(String msg) {
        super(msg);
    }
}
package com.example.entryassignment.domain.book.exception;

import com.example.entryassignment.global.error.CustomException;
import com.example.entryassignment.global.error.ErrorCode;

public class NoPermissionToAddBookException extends CustomException {

    public static final NoPermissionToAddBookException EXCEPTION =
            new NoPermissionToAddBookException();

    private NoPermissionToAddBookException() {
        super(ErrorCode.NO_PERMISSION_TO_ADD_BOOK);
    }
}
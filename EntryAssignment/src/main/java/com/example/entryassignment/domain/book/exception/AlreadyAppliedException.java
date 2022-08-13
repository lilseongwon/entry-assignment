package com.example.entryassignment.domain.book.exception;

import com.example.entryassignment.global.error.CustomException;
import com.example.entryassignment.global.error.ErrorCode;

public class AlreadyAppliedException extends CustomException {

    public static final AlreadyAppliedException EXCEPTION =
            new AlreadyAppliedException();

    private AlreadyAppliedException() {
        super(ErrorCode.ALREADY_APPLIED);
    }
}

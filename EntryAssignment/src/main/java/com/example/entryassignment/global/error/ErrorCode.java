package com.example.entryassignment.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    PASSWORD_MISMATCH(401, "Password Mismatch"),

    EXPIRED_JWT(401, "Expired Jwt"),
    SIGNATURE_JWT(401, "Signature Jwt"),
    INVALID_JWT(401, "Invalid Jwt"),

    NO_PERMISSION_TO_ADD_BOOK(401, "No Permission To Add Book"),
    NO_PERMISSION_TO_MODIFY_BOOK(401, "No Permission To Modify Book"),
    NO_PERMISSION_TO_DELETE_BOOK(401, "No Permission To Delete Book"),
    NO_PERMISSION_TO_CHECK_APPLY_LIST(401, "No Permission To Check Apply List"),
    NO_PERMISSION_TO_CHECK_USER_INFO(401, "No Permission To Check User Info"),

    INVALID_REFRESH_TOKEN(401, "Invalid Refresh Token"),

    USER_NOT_FOUND(404, "User Not Found"),

    BOOK_IS_NOT_EXIST(404, "Book is Not Exist"),
    BOOK_NOT_FOUND(404, "Book Not Found"),

    REFRESH_TOKEN_NOT_FOUND(404, "RefreshToken Not Found"),

    USER_EXIST(409, "User Exist"),

    ALREADY_BOOK_EXIST(409, "Already Book Exist"),
    ALREADY_BOOK_IS_ON_LOAN(409, "Already Book is On Loan"),
    ALREADY_APPLIED(409, "Already Applied"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error");

    private final int status;
    private final String message;
}

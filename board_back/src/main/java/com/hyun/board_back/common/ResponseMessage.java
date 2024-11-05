package com.hyun.board_back.common;

public interface ResponseMessage {

    //HTTP Status 200
    public static final String SUCCESS = "Success.";

    //HTTP Status 400
    public static final String VALIDATION_FAILED = "Validation failed.";
    public static final String DUPLICATE_EMAIL = "Duplicate email.";
    public static final String DUPLICATE_NICNAME = "Duplicate nickname.";
    public static final String DUPLICATE_TEL_NUM = "Duplicate tell number ";
    public static final String NOT_EXISTED_USER = "This user does not exist.";
    public static final String NOT_EXISTED_BOARD = "This board does not exist.";

    //HTTP Status 401
    public static final String SIGN_IN_FAIL = "Login information mismatch.";
    public static final String AUTHORIZATION_FAIL = "Authorization failed."; // 인증 실패

    //HTTP Status 403
    public static final String NO_PERMISSION = "Do not have permission";
    
    //HTTP Status 500
    public static final String DATEBASE_ERROR = "Datebase error.";

    
}

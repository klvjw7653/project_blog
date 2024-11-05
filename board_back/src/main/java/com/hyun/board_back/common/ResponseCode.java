package com.hyun.board_back.common;

public interface ResponseCode {
    //HTTP Status 200
    public static final String SUCCESS = "SU";

    //HTTP Status 400
    public static final String VALIDATION_FAILED = "VF";
    public static final String DUPLICATE_EMAIL = "DE";
    public static final String DUPLICATE_NICNAME = "DN";
    public static final String DUPLICATE_TEL_NUM = "DT";
    public static final String NOT_EXISTED_USER = "NU";
    public static final String NOT_EXISTED_BOARD = "NB";

    //HTTP Status 401
    public static final String SIGN_IN_FAIL = "SF";
    public static final String AUTHORIZATION_FAIL = "AF"; // 인증 실패

    //HTTP Status 403
    public static final String NO_PERMISSION = "NP";
    
    //HTTP Status 500
    public static final String DATEBASE_ERROR = "DBE";
    
}

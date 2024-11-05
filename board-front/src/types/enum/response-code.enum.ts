enum ResponseCode{

        //HTTP Status 200
        SUCCESS = "SU",

        //HTTP Status 400
        VALIDATION_FAILED = "VF",
        DUPLICATE_EMAIL = "DE",
        DUPLICATE_NICNAME = "DN",
        DUPLICATE_TEL_NUM = "DT",
        NOT_EXISTED_USER = "NU",
        NOT_EXISTED_BOARD = "NB",
    
        //HTTP Status 401
        SIGN_IN_FAIL = "SF",
        AUTHORIZATION_FAIL = "AF", // 인증 실패
    
        //HTTP Status 403
        NO_PERMISSION = "NP",
        
        //HTTP Status 500
        DATEBASE_ERROR = "DBE",
        

}

export default ResponseCode;
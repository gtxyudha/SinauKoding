package com.example.perpus.common;

public interface StatusCode {

    String SAVE_SUCCESS = "0010";
    String SAVE_FAILED = "0011";
    String UPDATE_SUCCESS = "0012";
    String UPDATE_FAILED = "0013";
    String DELETE_SUCCESS = "0014";
    String DELETE_FAILED = "0015";
    String DATA_NOT_FOUND = "0016";

    String LOGIN_SUCCESS = "1101";
    String LOGIN_FAILED = "1102";
    String PASSWORD_OR_USER_NOT_REGISTRED = "1103";
    String USER_EXIST = "1104";
    String TOKEN_NOT_VALID = "1107";
    String ILLEGAL_ACCESS = "1108";

    String INPUT_NOT_VALID = "1111";
    String OPERATION_SUCCESS = "1112";
    String OPERATION_FAILED = "1113";

    String SERVICE_OFFLINE = "0000";

}

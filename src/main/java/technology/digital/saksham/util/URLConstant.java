package technology.digital.saksham.util;

public interface URLConstant {
    String CRACKO_MAIN_OBJ = "cracko";

    int WEB_SERVICE_SUCCESS_STATUS = 1;
    String WEB_SERVER_ERROR = "Oop's!!! something went wrong. Please check your internet connection is properly working or not.";

    String BASE_URL = "http://api.cracko.in/";
    String VERIFICATION_BY_OTP_URL = BASE_URL + "get-otp";
    String SIGN_UP_URL = BASE_URL + "signup";
    String LOGIN_URL = BASE_URL + "login";

}

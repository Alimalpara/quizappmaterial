package Util;

abstract public class Constants {
    public static final String BASE_URL = "http://192.168.0.112/quiz-app/index.php/android_api/";
    public static final String LOGIN_URL = BASE_URL+"auth/login";
    public static final String REGISTER_URL = BASE_URL+"auth/register";
    public static final String GET_QUIZ_LIST_URL = BASE_URL+"quiz?start_at=0";
    public static final String PROFILE_VIEW_URL = BASE_URL+"profile";
    public static final String PROFILE_UPDATE_URL = BASE_URL+"profile/update";
    public static final String EXAM_COUNTER_URL = BASE_URL+"profile/exam_counter";
    public static final String UPLOAD_PROFILE_PIC_URL = BASE_URL+"profile/update_profile_pic";
    public static final String LOGOUT_URL = BASE_URL+"auth/logout";
    public static final String QUIZ_START_URL = BASE_URL+"quiz/quiz_starter_detail/";
    public static final String BASEURL_COOKIE_URL = "192.168.0.112";
    public static final String RESULT_LIST_URL =BASE_URL+"quiz/result_list";
    public static final String PLAN_LIST_URL =BASE_URL+"auth/get_plan_group";
    public static final String QUIZ_BEFORE_START_URL = BASE_URL+"quiz/before_start_quiz/";
    public static final String VIEW_RESULT_URL = BASE_URL+"quiz/view_result/";
    public static final String STUDY_MATERIAL_URL = BASE_URL+"/study_material";
    public static final String VIEW_STUDY_MATERIAL_URL = BASE_URL+"/study_material/view/";
    public static final String ANSWERSHEET_URL = "http://192.168.0.112/quiz-app/index.php/result/view_result2/";
}
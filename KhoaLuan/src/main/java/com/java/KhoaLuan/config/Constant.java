package com.java.KhoaLuan.config;

public class Constant {
	// Common
	public static final long DEFAULT_USER_ID = 1;
	// Security
	public static final String CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%&";
	public static final int USER_PASSWORD_LEN = 14;
	// Controller
	public static final String ERR_MSG_KEY = "errMsg";
	// User
	public static final String USER_PASSWORD_PLAIN_TEXT = "userPasswordPlainText";
	public static final String USER_CREATED_DATE = "userCreatedDate";
	public static final String USER_DATA_AFTER_CREATING_KEY = "userDataAfterCreating";
	public static final String EMAIL_ALREADY_USED_ERROR = "Email này đã được sử dụng, vui lòng sử dụng email khác";
	public static final String EMAIL_IS_NOT_EXIST = "Email này không tồn tại";
	public static final String PASSWORD_IS_NOT_MATCH = "Mật khẩu mới và mật khẩu không xác nhận không khớp, vui lòng thử lại";
	// Study
	public static final String EMAIL_SPLITTING_CHAR = ";";
	public static final String STUDENT_EMAIL_IS_NOT_EXIST = "Email của sinh viên này không tồn tại: %s";
	public static final String TEACHER_EMAIL_IS_NOT_EXIST = "Email của giáo viên này không tồn tại: %s";
	public static final String TEACHER_NUMBER_EXCEEDED_LIMITATION = "Đề tài khóa luận tối đa là %d giảng viên hướng dẫn";
	public static final String STUDY_CREATED_SUCCESSFULLY_KEY = "studyCreated";
	public static final String STUDY_CREATED_SUCCESSFULLY_VALUE = "Khóa luận đã được tạo thành công";
	// Thesis defense
	public static final String EMAIL_IS_NOT_EXIST_TO_REGISTER_THESIS_DEFENSE = "Email %s không tồn tại, không thể dùng email này để khởi tạo";
	public static final String EMAIL_IS_DUPLICATED = "Có ít nhất hai email trùng nhau, vui lòng kiểm tra lại";
	public static final String THESIS_DEFENSE_CREATED_SUCCESSFULLY_KEY = "thesisDefenseCreated";
	public static final String THESIS_DEFENSE_CREATED_SUCCESSFULLY_VALUE = "Hội đồng bảo vệ khóa luận đã được tạo thành công";
	public static final String THESIS_DEFENSE_LIST = "thesisDefenses";
	public static final String THESIS_DEFENSE_EMPTY_LIST = "Hiện tại thầy/cô chưa tham dự hội đồng bảo vệ khóa luận nào";
	// Home page
	public static final String USER_CHANGE_PASSWORD_KEY = "userChangePassword";
	public static final String USER_CHANGE_PASSWORD_VALUE = "Thay đổi mật khẩu thành công";
	// Db init
	public static final String ADMIN_EMAIL = "admin";
	public static final String ADMIN_PASSWORD = "admin";
	public static final String ADMIN_FIRST_NAME = "admin";
	public static final String ADMIN_LAST_NAME = "admin";
	
}

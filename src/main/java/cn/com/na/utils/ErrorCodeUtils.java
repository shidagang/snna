package cn.com.na.utils;

/**
 * 错误码对照表
 * @author linqj
 *
 */
public class ErrorCodeUtils {

	/**
	 * 成功
	 */
	public static final int SUCCESS = 200;
	/**
	 * 未知错误
	 */
	public static final int UNKNOWN_ERR = 201;
	/**
	 * 用户不存在
	 */
	public static final int USER_NOT_EXIST = 1011;
	/**
	 * 用户不存在
	 */
	public static final int ERROR_VERIFICATION_CODE = 1022;
	/**
	 * 登陆失败
	 */
	public static final int LOGIN_FAILED = 1012;
	/**
	 * 注册失败
	 */
	public static final int REGISTRATION_FAILED = 1013;
	/**
	 * 参数错误
	 */
    public static final int PARAM_ERROR = 1014;
    /**
	 * 设备已存在
	 */
    public static final int DEVICE_IS_EXISTENCE = 1015;
    /**
     * 添加设备失败
     */
    public static final int DEVICE_ADD_FAILED = 1016;
    /**
     * 操作失败
     */
    public static final int OPER_FAILED = 1017;
    
	public static final int USER_IS_EXIST = 2012;
	
	
	/**
	 * 重复给设备授权
	 */
	public static final int AUTH_IS_EXIST =9999;
	
    
    public static String LOGIN_SUESS_MSG="登陆成功";
    
	public static String LOGIN_FAIL_MSG="登陆失败";
	
	public static String LOGIN_INACTIVE_MSG="账户未激活，请到邮件去激活账户！谢谢";
	
	public static String PARAMETER_IS_NULL="参数为空";
	
	public static String PARAMETER_IS_NULL_WITHUSERID_OR_DEVICEID="参数userId或者deviceId为空";
	
	public static String PARAMETER_EXCEPTION="未知异常";
	
	public static String DATA_EXCEPTION="数据异常";
	
	public static String USER_IS_EXISTENCE="用户已存在";
	
	public static String USER_NOT_EXIST_MSG = "用户不存在";
	
	public static String REGISTRATION_FAILED_MSG="注册失败";
	
	public static String REGISTRATION_SUESS_MSG="注册成功";
	
	public static String GET_SUESS_MSG = "成功";
	
	public static String DEVICE_IS_EXISTENCE_MSG = "设备已存在";
 
    public static String DEVICE_ADD_FAILED_MSG = "添加设备失败";

    public static String OPER_FAILED_MSG = "操作失败";
 
    public static String OPER_SUCCESS = "操作成功";
    
	public static String NO_DATA_FOUND = "未查询到数据";
	
	public static String ERROR_VERIFICATION_CODE_MSG = "验证码错误";
	
	public static String SENG_VERIFICATION_CODE_SUECC_MSG = "发送验证码成功";
	
	public static String VERIFICATION_CODE_ISNULL_MSG = "验证码不能为空";
	
	public static String RESETPWD_SUESS_MSG="重置密码成功";
	
	public static String  AUTH_IS_EXIST_MSG ="授权设备已存在";
	
	
}

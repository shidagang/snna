package cn.com.na.utils;
		
/**   
 * 基础异常类
 * @author liuyong
 */
public class BaseException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**错误代码*/
	protected int errorCode;
	protected String errorMsg;

	public BaseException() {
		super();
	}

	public BaseException(String message) {
		super(message);
		this.errorMsg = message;
	}

	public BaseException(int errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
		this.errorMsg = message;
	}

	public BaseException(Throwable cause) {
		super(cause);
	}

	public BaseException(String message, Throwable cause) {
		super(message, cause);
	}

	public BaseException(int errorCode, String message, Throwable cause) {
		super(message, cause);
		this.errorCode = errorCode;
	}

	/**
	 * 获取错误代码
	 * @return errorCode 错误代码
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * 设置错误代码
	 * @param errorCode 错误代码
	 */
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * 获取errorMsg
	 * @return errorMsg errorMsg
	 */
	public String getErrorMsg() {
		return errorMsg;
	}

	/**
	 * 设置errorMsg
	 * @param errorMsg errorMsg
	 */
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
}

	
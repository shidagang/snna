package cn.com.na.utils;
		
/**   
 * 业务层异常类
 *@author liuyong
 */
public class ServiceException extends BaseException{
	
	private static final long serialVersionUID = 1L;

	public ServiceException(int errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	public ServiceException(int errorCode, String message, Throwable cause) {
		super(message, cause);
		this.errorCode = errorCode;
	}
	
	public ServiceException(Throwable cause){
		super(cause);
	}
}

	
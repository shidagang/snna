package cn.com.na.bean;
		
/**   
 * 查询传递对象参数基类
 * @author LIUYONG
 * 2016-12-20
 */
public class QueryParam extends Pagination{
	private static final long serialVersionUID = -8415748341532144065L;
	
	/**
	 * 查询设备类别
	 * A:查询用户被授权设备
	 * B:查询用户授权设备
	 */
	private String queryDeviceType;

	public String getQueryDeviceType() {
		return queryDeviceType;
	}

	public void setQueryDeviceType(String queryDeviceType) {
		this.queryDeviceType = queryDeviceType;
	}
	
}

	
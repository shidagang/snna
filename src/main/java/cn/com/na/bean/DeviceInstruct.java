package cn.com.na.bean;

import java.io.Serializable;

/**
 * 
 * @author liuyong
 * 设备类目指令表
 * Table: deviceinstruct
 */
public class DeviceInstruct  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
		private Integer id; //指令id
		private Integer dcId;//设备分类ID
		private Integer instruct;//指令值
		private String note;//指令描述
		
		
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Integer getDcId() {
			return dcId;
		}
		public void setDcId(Integer dcId) {
			this.dcId = dcId;
		}
		public Integer getInstruct() {
			return instruct;
		}
		public void setInstruct(Integer instruct) {
			this.instruct = instruct;
		}
		public String getNote() {
			return note;
		}
		public void setNote(String note) {
			this.note = note;
		}
	
		
		
		

}

package cn.com.na.bean;

import java.io.Serializable;

/**
 * 
 * @author David
 * 设备类目实体类
 * Table: deviceclass
 */
public class DeviceClass  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
		private int dcld; //设备类ID
		private String dcName;//设备名称
		private String description;//设备描述
		private String note;//备注
		public int getDcld() {
			return dcld;
		}
		public void setDcld(int dcld) {
			this.dcld = dcld;
		}
		public String getDcName() {
			return dcName;
		}
		public void setDcName(String dcName) {
			this.dcName = dcName;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getNote() {
			return note;
		}
		public void setNote(String note) {
			this.note = note;
		}
		@Override
		public String toString() {
			return "Category [dcld=" + dcld + ", dcName=" + dcName
					+ ", description=" + description + ", note=" + note + "]";
		}
		
		
		

}

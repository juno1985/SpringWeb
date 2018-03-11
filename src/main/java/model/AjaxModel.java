package model;

public class AjaxModel {
	
	private Integer code;
	private String msg;
	public AjaxModel() {
		super();
	}
	public AjaxModel(Integer code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	

}

package com.project.jobportal.response;

public class ResponseBody {
	
	private String success;
	private String message;
	private Object data;
	
	public ResponseBody() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResponseBody(String success, String message, Object data) {
		super();
		this.success = success;
		this.message = message;
		this.data = data;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}

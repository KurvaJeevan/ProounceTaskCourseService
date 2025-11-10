package com.example.ProounceTask;

public class ResponseStructure <T>{
	private int statuscode;
	private T value;
	private String message;
	@Override
	public String toString() {
		return "ResponseStructure [statuscode=" + statuscode + ", value=" + value + ", message=" + message + "]";
	}
	public ResponseStructure(int statuscode, T value, String message) {
		super();
		this.statuscode = statuscode;
		this.value = value;
		this.message = message;
	}
	public int getStatuscode() {
		return statuscode;
	}
	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ResponseStructure() {
		// TODO Auto-generated constructor stub
	}
	
}

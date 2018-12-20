package com.codetest.vis.exceptions;
public class VehicleServiceException extends Exception {

	private static final long serialVersionUID = 4351720088030656859L;
	private int errorId=1213;

	public int getErrorId() {
		return errorId;
	}
	
	public VehicleServiceException(String msg) {
		super(msg);
	}

	public VehicleServiceException(String msg, int errorId) {
		super(msg);
		this.errorId = errorId;
	}

	public VehicleServiceException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
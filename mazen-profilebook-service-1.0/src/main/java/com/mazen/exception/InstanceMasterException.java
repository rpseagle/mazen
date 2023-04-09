package com.mazen.exception;

public class InstanceMasterException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4507096499608849965L;
	
	public InstanceMasterException() {
		super();
	}
	
	public InstanceMasterException(String pMessage, Throwable pCause, boolean pEnableSuppresion, boolean pWriteStackTrace) {
		super(pMessage, pCause, pEnableSuppresion, pWriteStackTrace );
	}
	

	public InstanceMasterException(String pMessage, Throwable pCause) {
		super(pMessage, pCause);
	}

	public InstanceMasterException(String pMessage) {
		super(pMessage);
	}

	public InstanceMasterException(Throwable pCause) {
		super(pCause);
	}
	
	

}

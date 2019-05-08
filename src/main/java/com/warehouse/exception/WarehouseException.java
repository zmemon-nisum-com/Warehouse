package com.warehouse.exception;

public class WarehouseException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	String resonse;

	public WarehouseException(String message) {
		resonse = message;
	}

	public String toString() {
		return "WarehouseException[" + resonse + "]";
	}
}
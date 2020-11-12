package me.airini.auto_attendance.exception;

public class IllegalSignalException extends RuntimeException {
	public IllegalSignalException(String signal) {
		super("The Signal (ID : " + signal + ") is not registered...");
	}
}

package me.airini.auto_attendance.exception;

public class IllegalUserIDException extends RuntimeException {
	public IllegalUserIDException(String userID) {
		super("The User (ID : " + userID + ") is not registered...");
	}
}

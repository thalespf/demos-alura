/**
 * 
 */
package com.thalespf.demo.android.presentation.ui.exception;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 *
 */
@SuppressWarnings("serial")
public class ValidationError extends Exception {

	public ValidationError() {
	}

	/**
	 * @param detailMessage
	 */
	public ValidationError(String detailMessage) {
		super(detailMessage);
	}

	/**
	 * @param throwable
	 */
	public ValidationError(Throwable throwable) {
		super(throwable);
	}

	/**
	 * @param detailMessage
	 * @param throwable
	 */
	public ValidationError(String detailMessage, Throwable throwable) {
		super(detailMessage, throwable);
	}

}

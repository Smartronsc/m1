package com.androidcommand.app.validataion;

import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

public class RantRaveValidationErrorBuilder {
		
	public static RantRaveValidationError fromBindingErrors(Errors errors) {
		RantRaveValidationError error = new RantRaveValidationError("Validation failed. " + errors.getErrorCount() + " error(s)");
		for (ObjectError objectError : errors.getAllErrors()) {
			error.addValidationError(objectError.getDefaultMessage());
		}
		return error;
	}
}

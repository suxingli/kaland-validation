package com.kaland.validation;

import java.text.MessageFormat;

import com.kaland.validation.exception.ValidationException;

/**
 * 非空校验器
 * @author 苏行利
 * @date 2019-10-03 20:12:20
 */
public class NotNullValidator extends Validator {

	@Override
	public void valid(String name, Object value) throws ValidationException {
		if (value == null || (value instanceof String && value.equals(""))) {
			throw new ValidationException(-3, MessageFormat.format("{0}必填", name == null ? "参数" : name));
		}
	}

}

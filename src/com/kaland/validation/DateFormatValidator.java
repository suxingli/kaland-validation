package com.kaland.validation;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.kaland.validation.exception.ValidationException;

/**
 * 日期格式校验器
 * @author 苏行利
 * @date 2019-10-08 17:12:51
 */
public class DateFormatValidator extends Validator {
	private String pattern;

	/**
	 * 构造方法
	 * @author 苏行利
	 * @param pattern 日期格式
	 * @date 2019-10-08 17:17:55
	 */
	public DateFormatValidator(String pattern) {
		super();
		this.pattern = pattern;
	}

	@Override
	public void valid(String name, Object value) throws ValidationException {
		if (value == null) {
			return;
		}
		if (!(value instanceof String)) {
			throw new ValidationException(-12, MessageFormat.format("{0}格式不正确", name));
		}
		try {
			DateFormat dateFormat = new SimpleDateFormat(pattern);
			dateFormat.setLenient(false);
			dateFormat.parse(value.toString());
		} catch (ParseException e) {
			throw new ValidationException(-12, MessageFormat.format("{0}格式不正确", name));
		}
	}

}

package com.kaland.validation;

import java.text.MessageFormat;
import java.util.regex.Pattern;

import com.kaland.validation.exception.ValidationException;

/**
 * 最大值校验器
 * @author 苏行利
 * @date 2019-10-04 02:18:42
 */
public class PatternValidator extends Validator {
	private String pattern; // 正则表达式

	/**
	 * 构造方法
	 * @author 苏行利
	 * @param pattern 正则表达式
	 * @date 2019-10-04 03:35:50
	 */
	public PatternValidator(String pattern) {
		super();
		this.pattern = pattern;
	}

	@Override
	public void valid(String name, Object value) throws ValidationException {
		if (value == null) {
			return;
		}
		if (!Pattern.compile(pattern).matcher(value.toString()).matches()) {
			throw new ValidationException(-12, MessageFormat.format("{0}格式不正确", name));
		}
	}

}

package com.kaland.validation;

import java.text.MessageFormat;

import com.kaland.validation.annotation.Min;
import com.kaland.validation.exception.ValidationException;

/**
 * 最小值校验器
 * @author 苏行利
 * @date 2019-10-04 03:23:07
 */
public class MinValidator extends Validator {
	private Number min; // 最小值

	/**
	 * 构造方法
	 * @author 苏行利
	 * @param min 最小值
	 * @date 2019-10-04 03:23:40
	 */
	public MinValidator(Number min) {
		super();
		this.min = min;
	}

	@Override
	public void valid(String name, Object value) throws ValidationException {
		if (value == null) {
			return;
		}
		if (!(value instanceof Number)) {
			throw new RuntimeException(Min.class.getCanonicalName() + "只能在数值类型的属性上使用");
		}
		if (((Number) value).doubleValue() < min.doubleValue()) {
			throw new ValidationException(-10, MessageFormat.format("{0}不能小于{1}", name, min));
		}
	}

}

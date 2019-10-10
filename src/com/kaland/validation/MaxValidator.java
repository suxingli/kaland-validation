package com.kaland.validation;

import java.text.MessageFormat;

import com.kaland.validation.annotation.Max;
import com.kaland.validation.exception.ValidationException;

/**
 * 最大值校验器
 * @author 苏行利
 * @date 2019-10-04 02:18:42
 */
public class MaxValidator extends Validator {
	private Number max; // 最大值

	/**
	 * 构造方法
	 * @author 苏行利
	 * @param max 最大值
	 * @date 2019-10-04 02:43:06
	 */
	public MaxValidator(Number max) {
		super();
		this.max = max;
	}

	@Override
	public void valid(String name, Object value) throws ValidationException {
		if (value == null) {
			return;
		}
		if (!(value instanceof Number)) {
			throw new RuntimeException(Max.class.getCanonicalName() + "只能在数值类型的属性上使用");
		}
		if (((Number) value).doubleValue() > max.doubleValue()) {
			throw new ValidationException(-11, MessageFormat.format("{0}不能大于{1}", name, max));
		}
	}

}

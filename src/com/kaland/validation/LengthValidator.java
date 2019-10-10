package com.kaland.validation;

import java.text.MessageFormat;

import com.kaland.validation.annotation.Length;
import com.kaland.validation.exception.ValidationException;

/**
 * 长度校验器
 * @author 苏行利
 * @date 2019-10-04 03:46:46
 */
public class LengthValidator extends Validator {
	private long min; // 最小长度
	private long max; // 最大长度

	/**
	 * 构造方法
	 * @author 苏行利
	 * @param min 最小长度
	 * @param max 最大长度
	 * @date 2019-10-04 03:47:53
	 */
	public LengthValidator(long min, long max) {
		super();
		this.min = min;
		this.max = max;
	}

	@Override
	public void valid(String name, Object o) throws ValidationException {
		if (o == null) {
			return;
		}
		if (!(o instanceof String)) {
			throw new RuntimeException(Length.class.getCanonicalName() + "只能在字符串型的属性上使用");
		}
		String value = (String) o;
		if (value.length() < min) {
			if (min == max) {
				throw new ValidationException(-9, MessageFormat.format("{0}只能为{1}个字符", name, min));
			}
			throw new ValidationException(-7, MessageFormat.format("{0}不能少于{1}个字符", name, min));
		}
		if (value.length() > max) {
			if (min == max) {
				throw new ValidationException(-9, MessageFormat.format("{0}只能为{1}个字符", name, min));
			}
			throw new ValidationException(-8, MessageFormat.format("{0}不能超过{1}个字符", name, max));
		}
	}

}

package com.kaland.validation;

import com.kaland.validation.exception.ValidationException;

/**
 * 校验器
 * @author 苏行利
 * @date 2019-10-03 19:54:33
 */
public abstract class Validator {

	/**
	 * 校验
	 * @author 苏行利
	 * @param name 名称
	 * @param value 值
	 * @throws ValidationException
	 * @date 2019-10-03 20:19:23
	 */
	public abstract void valid(String name, Object value) throws ValidationException;

}

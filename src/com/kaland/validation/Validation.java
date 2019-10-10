package com.kaland.validation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.kaland.validation.annotation.Length;
import com.kaland.validation.annotation.Max;
import com.kaland.validation.annotation.Min;
import com.kaland.validation.annotation.NotNull;
import com.kaland.validation.annotation.Pattern;
import com.kaland.validation.exception.ValidationException;
import com.kaland.validation.reflections.Reflections;

/**
 * 校验工具类
 * @author 苏行利
 * @date 2019-10-04 03:22:43
 */
public abstract class Validation {

	/**
	 * 校验
	 * @author 苏行利
	 * @param o 校验对象
	 * @throws ValidationException
	 * @date 2019-10-03 20:59:40
	 */
	public static void valid(Object o) throws ValidationException {
		if (o == null) {
			return;
		}
		String name = null;
		Object value = null;
		Method getMethod = null;
		com.kaland.validation.annotation.Field _field = null;
		Field[] fields = o.getClass().getDeclaredFields();
		try {
			for (Field field : fields) {
				_field = field.getAnnotation(com.kaland.validation.annotation.Field.class);
				getMethod = Reflections.getter(o.getClass(), field);
				name = (_field == null || _field.name().equals("")) ? field.getName() : _field.name();
				value = getMethod.invoke(o);
				if (field.isAnnotationPresent(NotNull.class)) { // 非空校验
					new NotNullValidator().valid(name, value);
				}
				if (field.isAnnotationPresent(Length.class)) { // 长度校验
					Length len = field.getAnnotation(Length.class);
					new LengthValidator(len.min(), len.max()).valid(name, value);
				}
				if (field.isAnnotationPresent(Min.class)) { // 最小值校验
					new MinValidator(field.getAnnotation(Min.class).value()).valid(name, value);
				}
				if (field.isAnnotationPresent(Max.class)) { // 最大值校验
					new MaxValidator(field.getAnnotation(Max.class).value()).valid(name, value);
				}
				if (field.isAnnotationPresent(Pattern.class)) { // 正则表达式校验
					new PatternValidator(field.getAnnotation(Pattern.class).value()).valid(name, value);
				}
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 校验
	 * @author 苏行利
	 * @param name 名称
	 * @param value 值
	 * @param validators 校验器列表
	 * @throws ValidationException
	 * @date 2019-10-03 21:01:01
	 */
	public static void valid(String name, String value, Validator... validators) throws ValidationException {
		if (validators == null || validators.length == 0) {
			return;
		}
		for (Validator validator : validators) {
			validator.valid(name, value);
		}
	}

	/**
	 * 校验
	 * @author 苏行利
	 * @param name 名称
	 * @param value 值
	 * @param validators 校验器列表
	 * @throws ValidationException
	 * @date 2019-10-04 13:38:00
	 */
	public static void valid(String name, Number value, Validator... validators) throws ValidationException {
		if (validators == null || validators.length == 0) {
			return;
		}
		for (Validator validator : validators) {
			validator.valid(name, value);
		}
	}

}

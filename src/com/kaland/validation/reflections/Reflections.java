package com.kaland.validation.reflections;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射工具类
 * @author 苏行利
 * @date 2019-10-03 21:07:43
 */
public class Reflections {
	private static final String GET = "get";
	private static final String SET = "set";
	private static final String IS = "is";
	private static final String BOOLEAN = "boolean";

	/**
	 * 获取属性的get方法
	 * @author 苏行利
	 * @param c 类型
	 * @param field 属性
	 * @return 属性的get方法
	 * @date 2019-10-03 21:13:59
	 */
	public static Method getter(Class<?> c, Field field) {
		if (c == null || field == null) {
			return null;
		}
		StringBuffer getter = new StringBuffer();
		if (field.getType().toString().toLowerCase().equals(BOOLEAN)) { // 布尔类型
			getter.append(IS);
		} else {
			getter.append(GET);
		}
		getter.append(field.getName().substring(0, 1).toUpperCase());
		getter.append(field.getName().substring(1));
		return getMethod(c, getter.toString());
	}

	/**
	 * 获取属性的get方法
	 * @author 苏行利
	 * @param c 类型
	 * @param fieldName 属性名
	 * @return 属笥的get方法
	 * @date 2019-10-03 21:14:49
	 */
	public static Method getter(Class<?> c, String fieldName) {
		try {
			return getter(c, c.getDeclaredField(fieldName));
		} catch (SecurityException e) {
			return null;
		} catch (NoSuchFieldException e) {
			return null;
		}
	}

	/**
	 * 获取属性的set方法
	 * @author 苏行利
	 * @param c 类
	 * @param field 属性
	 * @return 属性的set方法
	 * @date 2019-10-03 21:15:24
	 */
	public static Method setter(Class<?> c, Field field) {
		if (c == null || field == null) {
			return null;
		}
		StringBuffer setter = new StringBuffer(SET);
		setter.append(field.getName().substring(0, 1).toUpperCase());
		setter.append(field.getName().substring(1));
		return getMethod(c, setter.toString(), field.getType());
	}

	/**
	 * 获取类的方法
	 * @author 苏行利
	 * @param c 类型
	 * @param method 方法
	 * @param parameterTypes 参数类型列表
	 * @return 方法
	 * @date 2019-10-03 21:16:06
	 */
	public static Method getMethod(Class<?> c, String method, Class<?>... parameterTypes) {
		if (c == null || method == null || method.equals("")) { // 类或方法为空
			return null;
		}
		try {
			if (parameterTypes == null || parameterTypes.length == 0) {
				return c.getMethod(method);
			}
			return c.getMethod(method, parameterTypes);
		} catch (SecurityException e) {
			return null;
		} catch (NoSuchMethodException e) {
			return null;
		}
	}
}

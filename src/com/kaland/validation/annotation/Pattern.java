package com.kaland.validation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 正则表达式注解
 * @author 苏行利
 * @date 2019-10-04 03:32:29
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
public @interface Pattern {

	/**
	 * 正则表达式
	 * @author 苏行利
	 * @return 正则表达式
	 * @date 2019-10-04 03:32:57
	 */
	String value();

}

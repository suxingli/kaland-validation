package com.kaland.validation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 最小值注解
 * @author 苏行利
 * @date 2019-10-04 01:57:28
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
public @interface Min {

	/**
	 * 必须是一个数字，其值必须大于等于指定的值
	 * @author 苏行利
	 * @return 最小值
	 * @date 2019-10-04 02:04:44
	 */
	long value();

}

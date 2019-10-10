package com.kaland.validation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 最大值注解
 * @author 苏行利
 * @date 2019-10-04 02:14:35
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
public @interface Max {

	/**
	 * 必须是一个数字，其值必须小于等于指定的值
	 * @author 苏行利
	 * @return 最大值
	 * @date 2019-10-04 02:14:55
	 */
	double value();

}

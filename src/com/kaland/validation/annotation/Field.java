package com.kaland.validation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 属性
 * @author 苏行利
 * @date 2019-10-03 23:17:36
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
public @interface Field {

	/**
	 * 属性名称
	 * @author 苏行利
	 * @return 属性名称
	 * @date 2019-10-03 23:18:15
	 */
	String name() default "";

}

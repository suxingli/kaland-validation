package com.kaland.validation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 长度注解
 * @author 苏行利
 * @date 2019-10-04 03:45:25
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
public @interface Length {

	/**
	 * 最小长度
	 * @author 苏行利
	 * @return 最小长度
	 * @date 2019-10-04 03:45:35
	 */
	long min() default 0;

	/**
	 * 最大长度
	 * @author 苏行利
	 * @return 最大长度
	 * @date 2019-10-04 03:46:09
	 */
	long max() default Long.MAX_VALUE;

}

package com.kaland.validation.exception;

/**
 * 校验异常
 * @author 苏行利
 * @date 2019-10-03 20:14:16
 */
public class ValidationException extends Exception {
	private static final long serialVersionUID = -7146214299362151687L;
	private String code; // 异常码

	/**
	 * 构造方法
	 * @author 苏行利
	 * @param code 异常码
	 * @param message 异常信息
	 * @date 2019-10-03 20:17:28
	 */
	public ValidationException(String code, String message) {
		super(message);
		this.code = code;
	}

	/**
	 * 构造方法
	 * @author 苏行利
	 * @param code 异常码
	 * @param message 异常信息
	 * @date 2019-10-03 20:22:45
	 */
	public ValidationException(Integer code, String message) {
		super(message);
		this.code = code == null ? "-1" : code.toString();
	}

	/**
	 * 
	 * 构造方法
	 * @author 苏行利
	 * @param code 异常码
	 * @param message 异常信息
	 * @param e 异常源
	 * @date 2019-10-03 20:23:34
	 */
	public ValidationException(String code, String message, Throwable e) {
		super(message, e);
		this.code = code;
	}

	/**
	 * 构造方法
	 * @author 苏行利
	 * @param code 异常码
	 * @param message 异常信息
	 * @param e 异常源
	 * @date 2019-10-03 20:23:57
	 */
	public ValidationException(Integer code, String message, Throwable e) {
		super(message, e);
		this.code = code == null ? "-1" : code.toString();
	}

	/**
	 * 获取异常码
	 * @author 苏行利
	 * @return 异常码
	 * @date 2019-10-03 20:24:23
	 */
	public String getCode() {
		return code;
	}
	
	@Override
	public String toString() {
		return super.toString() + "(" + this.getCode() + ")";
	}

}

package com.cc.common.util.crypto.digest;

/**
 * Created with IntelliJ IDEA.
 * User: cheng.chen
 * Date: 2019/9/4 10:26
 * Description: 摘要算法类型
 * 注意：此对象实例化后为非线程安全！
 */
public enum DigestAlgorithm {
	MD2("MD2"), 
	MD5("MD5");

	private String value;

	/**
	 * 构造
	 * 
	 * @param value 算法字符串表示
	 */
	private DigestAlgorithm(String value) {
		this.value = value;
	}

	/**
	 * 获取算法字符串表示
	 * @return 算法字符串表示
	 */
	public String getValue() {
		return this.value;
	}
}
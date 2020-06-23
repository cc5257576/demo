package com.cc.common.util.crypto.digest;

import com.cc.common.util.CharsetUtil;

import javax.crypto.SecretKey;
import java.io.File;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * Created with IntelliJ IDEA.
 * User: cheng.chen
 * Date: 2019/9/4 10:26
 * Description: 摘要算法工具类
 */
public class DigestUtil {

	// ------------------------------------------------------------------------------------------- MD5
	/**
	 * 计算32位MD5摘要值
	 * 
	 * @param data 被摘要数据
	 * @return MD5摘要
	 */
	public static byte[] md5(byte[] data) {
		return new MD5().digest(data);
	}

	/**
	 * 计算32位MD5摘要值
	 * 
	 * @param data 被摘要数据
	 * @param charset 编码
	 * @return MD5摘要
	 */
	public static byte[] md5(String data, String charset) {
		return new MD5().digest(data, charset);
	}

	/**
	 * 计算32位MD5摘要值，使用UTF-8编码
	 * 
	 * @param data 被摘要数据
	 * @return MD5摘要
	 */
	public static byte[] md5(String data) {
		return md5(data, CharsetUtil.UTF_8);
	}

	/**
	 * 计算32位MD5摘要值
	 * 
	 * @param data 被摘要数据
	 * @return MD5摘要
	 */
	public static byte[] md5(InputStream data) {
		return new MD5().digest(data);
	}


	/**
	 * 计算32位MD5摘要值，并转为16进制字符串
	 * 
	 * @param data 被摘要数据
	 * @return MD5摘要的16进制表示
	 */
	public static String md5Hex(byte[] data) {
		return new MD5().digestHex(data);
	}

	/**
	 * 计算32位MD5摘要值，并转为16进制字符串
	 * 
	 * @param data 被摘要数据
	 * @param charset 编码
	 * @return MD5摘要的16进制表示
	 */
	public static String md5Hex(String data, String charset) {
		return new MD5().digestHex(data, charset);
	}
	
	/**
	 * 计算32位MD5摘要值，并转为16进制字符串
	 * 
	 * @param data 被摘要数据
	 * @param charset 编码
	 * @return MD5摘要的16进制表示
	 * @since 4.6.0
	 */
	public static String md5Hex(String data, Charset charset) {
		return new MD5().digestHex(data, charset);
	}

	/**
	 * 计算32位MD5摘要值，并转为16进制字符串
	 * 
	 * @param data 被摘要数据
	 * @return MD5摘要的16进制表示
	 */
	public static String md5Hex(String data) {
		return md5Hex(data, CharsetUtil.UTF_8);
	}

	/**
	 * 计算32位MD5摘要值，并转为16进制字符串
	 * 
	 * @param data 被摘要数据
	 * @return MD5摘要的16进制表示
	 */
	public static String md5Hex(InputStream data) {
		return new MD5().digestHex(data);
	}

	
	// ------------------------------------------------------------------------------------------- MD5 16
	/**
	 * 计算16位MD5摘要值，并转为16进制字符串
	 * 
	 * @param data 被摘要数据
	 * @return MD5摘要的16进制表示
	 * @since 4.6.0
	 */
	public static String md5Hex16(byte[] data) {
		return new MD5().digestHex16(data);
	}

	/**
	 * 计算16位MD5摘要值，并转为16进制字符串
	 * 
	 * @param data 被摘要数据
	 * @param charset 编码
	 * @return MD5摘要的16进制表示
	 * @since 4.6.0
	 */
	public static String md5Hex16(String data, Charset charset) {
		return new MD5().digestHex16(data, charset);
	}

	/**
	 * 计算16位MD5摘要值，并转为16进制字符串
	 * 
	 * @param data 被摘要数据
	 * @return MD5摘要的16进制表示
	 * @since 4.6.0
	 */
	public static String md5Hex16(String data) {
		return md5Hex16(data, CharsetUtil.CHARSET_UTF_8);
	}

	/**
	 * 计算16位MD5摘要值，并转为16进制字符串
	 * 
	 * @param data 被摘要数据
	 * @return MD5摘要的16进制表示
	 * @since 4.6.0
	 */
	public static String md5Hex16(InputStream data) {
		return new MD5().digestHex16(data);
	}

	/**
	 * 32位MD5转16位MD5
	 * 
	 * @param md5Hex 32位MD5
	 * @return 16位MD5
	 * @since 4.4.1
	 */
	public static String md5HexTo16(String md5Hex) {
		return md5Hex.substring(8, 24);
	}
}

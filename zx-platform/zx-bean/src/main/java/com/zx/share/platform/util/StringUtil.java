package com.zx.share.platform.util;

import org.apache.commons.lang.math.RandomUtils;

import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author fenggang
 */
public class StringUtil {

	private static final String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
	private static final Pattern CHECK_MOBILE = Pattern.compile("^[1][0-9][0-9]{9}$"); // 验证手机号
	private static final Pattern CHECK_MOBILE_TEL = Pattern.compile("(13[0-9]|15[^4,\\D]|17[678]|18[0-9]|14[57])[0-9]{8}$");;

	/**
	 * <pre>
	 * 判断是否为空，为空则返回true
	 * 为空的条件：null、""、"null"
	 * </pre>
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean isBlank(Object obj) {
		if (obj == null) {
			return true;
		}
		String str = obj.toString().trim();
		if ("".equals(str) || "null".equalsIgnoreCase(str)) {
			return true;
		}
		return false;
	}

	/**
	 * <pre>
	 * 判断是否不为空，不为空则返回true
	 * 为空的条件：null、""、"null"
	 * </pre>
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean isNotBlank(Object obj) {
		return !isBlank(obj);
	}

	/**
	 * <pre>
	 * 获取换行符
	 * </pre>
	 * 
	 * @return
	 */
	public static String getNewLine() {
		return System.getProperty("line.separator");
	}

	/**
	 * 获取uuid字符串
	 */
	public static String UUID() {
		return UUID.randomUUID().toString();
	}

	/**
	 * 去除前后空格，若obj为null返回""空字串
	 * 
	 * @param obj
	 * @return
	 */
	public static String trim(Object obj) {
		if (obj == null) {
			return "";
		}
		return obj.toString().trim();
	}

	/**
	 * <p>
	 * 生成随机码
	 *
	 * <p>
	 * 若指定的长度为0，则返回空白字符串
	 *
	 * @param codeLength
	 *          随机码长度
	 * @return
	 */
	public static String randomCode(int codeLength) {
		if (codeLength <= 0) {
			return "";
		}

		long powResult = 1L;
		for (int i = 0; i < codeLength / 2; i++) {
			powResult *= 10;
		}
		if ((codeLength & 0x1) == 0) {
			powResult *= powResult;
		} else {
			powResult *= powResult * 10;
		}
		long randomResult = RandomUtils.nextLong(new Random(System.currentTimeMillis()));
		if (randomResult < 0) {
			randomResult += Long.MAX_VALUE;
		}
		StringBuilder code = new StringBuilder(Long.toString(randomResult));
		if (code.length() > codeLength) {
			code.setLength(codeLength);
		} else {
			int[] source = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
			int sourceHash = source.hashCode();
			int index = code.length();
			while ((index < codeLength)) {
				code.append(sourceHash % 10);
				sourceHash /= 10;
				index++;
			}
		}
		return String.valueOf(code);
	}

	/**
	 * 验证手机号
	 * 
	 * @param mobiles
	 * @return false->手机号格式不正确，true->格式正确
	 */
	public static boolean isMobileNO(String mobiles) {
		if (isBlank(mobiles)) {
			return false;
		}
		Pattern p = CHECK_MOBILE_TEL;
		Matcher m = p.matcher(mobiles);
		return m.matches();
	}

	/** 
	 * 手机号验证 
	 *  
	 * @param  str 
	 * @return 验证通过返回true 
	 */  
	public static boolean isMobile(String str) {   
		Pattern p = null;  
		Matcher m = null;  
		boolean b = false;   
		p = CHECK_MOBILE;
		m = p.matcher(str);  
		b = m.matches();   
		return b;  
	}
	/**
	 * 消除html标签
	 * @param str
	 * @return
	 */
	public static String regExHtml(String str){
		if(StringUtil.isBlank(str)){
			return "";
		}
		Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);  
        Matcher m_html = p_html.matcher(str);  
        str = m_html.replaceAll(""); // 过滤html标签  
        return str;
	}
}

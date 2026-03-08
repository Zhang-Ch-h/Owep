/**  
 * @Project: ediansoft-common
 * @Title: DoubleUtil.java
 * @Package: com.ediansoft.qijj.common.util
 * @Description: TODO
 * @author: QIJJ 
 * @since: 2016-3-10 上午10:54:45
 * @Copyright: 2016. All rights reserved.
 * @Version: v1.0   
 */
package com.kclm.owep.utils.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @ClassName: DoubleUtil
 * @Description: Double类型数据加减乘除工具类，同样适用非Double与非Double类型数据加减乘除运算/BigDecimal类型数据运算
 *               。注：整数与Double类型数据可直接使用运算符 ，返回Double类型数据即可;分母不能为0
 * @author: huangfei
 * @date: 2017年4月1日 上午11:47:27
 */
public class DoubleUtil {

	private static final DecimalFormat df = new DecimalFormat("######0.00");

	private static final int DEF_DIV_SCALE = 10;

	/**
	 * @Title: decimalFormat
	 * @Description: 格式化Double类型数据,保留相应位数,四舍五入
	 * @param v1
	 * @return
	 * @date: 2017年4月1日 上午11:48:06
	 * @return: Double
	 */
	public static Double decimalFormat(Double v1) {
		String str = df.format(v1);

		return Double.valueOf(str);
	}

	/**
	 * * 两个Double数相加 *
	 * 
	 * @param v1
	 *            *
	 * @param v2
	 *            *
	 * @return Double
	 */
	public static Double add(Double v1, Double v2) {
		BigDecimal b1 = null;
		BigDecimal b2 = null;

		if (v1 != null && v2 != null) {
			b1 = new BigDecimal(v1.toString());
			b2 = new BigDecimal(v2.toString());

			return new Double(b1.add(b2).doubleValue());
		} else {
			return null;
		}
	}

	/**
	 * @Title: addBd
	 * @Description: 相加返回BigDecimal类型数据
	 * @param v1
	 * @param v2
	 * @return
	 * @date: 2017年4月1日 上午11:48:26
	 * @return: BigDecimal
	 */
	public static BigDecimal addBd(Object v1, Object v2) {
		BigDecimal b1 = BigDecimal.ZERO;
		BigDecimal b2 = BigDecimal.ZERO;

		if (v1 != null && v2 != null) {
			b1 = new BigDecimal(v1.toString());
			b2 = new BigDecimal(v2.toString());

			return b1.add(b2);
		} else {
			return BigDecimal.ZERO;
		}
	}

	/**
	 * * 两个Double数相加，并保留scale位小数 *
	 * 
	 * @param v1
	 *            *
	 * @param v2
	 *            *
	 * @param scale
	 *            *
	 * @return Double,四舍五入后结果
	 */
	public static Double add(Double v1, Double v2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}

		BigDecimal b1 = null;
		BigDecimal b2 = null;
		if (v1 != null && v2 != null) {
			b1 = new BigDecimal(v1.toString());
			b2 = new BigDecimal(v2.toString());

			return new Double(b1.add(b2).setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue());
		} else {
			return null;
		}
	}

	/**
	 * @Title: addBd
	 * @Description:  相加返回BigDecimal类型数据,四舍五入
	 * @param v1
	 * @param v2
	 * @param scale
	 * @return
	 * @date: 2017年4月1日 上午11:48:45
	 * @return: BigDecimal
	 */
	public static BigDecimal addBd(Object v1, Object v2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}

		BigDecimal b1 = BigDecimal.ZERO;
		BigDecimal b2 = BigDecimal.ZERO;
		if (v1 != null && v2 != null) {
			b1 = new BigDecimal(v1.toString());
			b2 = new BigDecimal(v2.toString());

			return b1.add(b2).setScale(scale, BigDecimal.ROUND_HALF_UP);
		} else {
			return BigDecimal.ZERO;
		}
	}

	/**
	 * * 两个Double数相减 *
	 * 
	 * @param v1
	 *            *
	 * @param v2
	 *            *
	 * @return Double
	 */
	public static Double sub(Double v1, Double v2) {
		BigDecimal b1 = null;
		BigDecimal b2 = null;

		if (v1 != null && v2 != null) {
			b1 = new BigDecimal(v1.toString());
			b2 = new BigDecimal(v2.toString());

			return new Double(b1.subtract(b2).doubleValue());
		} else {
			return null;
		}
	}

	/**
	 * @Title: subBd
	 * @Description: 相减返回BigDecimal类型数据
	 * @param v1
	 * @param v2
	 * @return
	 * @date: 2017年4月1日 上午11:48:58
	 * @return: BigDecimal
	 */
	public static BigDecimal subBd(Object v1, Object v2) {
		BigDecimal b1 = BigDecimal.ZERO;
		BigDecimal b2 = BigDecimal.ZERO;

		if (v1 != null && v2 != null) {
			b1 = new BigDecimal(v1.toString());
			b2 = new BigDecimal(v2.toString());

			return b1.subtract(b2);
		} else {
			return BigDecimal.ZERO;
		}
	}

	/**
	 * * 两个Double数相减，并保留scale位小数 *
	 * 
	 * @param v1
	 *            *
	 * @param v2
	 *            *
	 * @param scale
	 *            *
	 * @return Double,四舍五入后结果
	 */
	public static Double sub(Double v1, Double v2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}

		BigDecimal b1 = null;
		BigDecimal b2 = null;
		if (v1 != null && v2 != null) {
			b1 = new BigDecimal(v1.toString());
			b2 = new BigDecimal(v2.toString());

			return new Double(b1.subtract(b2).setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue());
		} else {
			return null;
		}
	}

/**
 * @Title: subBd
 * @Description:  相减返回BigDecimal类型数据，四舍五入
 * @param v1
 * @param v2
 * @param scale
 * @return
 * @date: 2017年4月1日 上午11:49:15
 * @return: BigDecimal
 */
	public static BigDecimal subBd(Object v1, Object v2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}

		BigDecimal b1 = BigDecimal.ZERO;
		BigDecimal b2 = BigDecimal.ZERO;
		if (v1 != null && v2 != null) {
			b1 = new BigDecimal(v1.toString());
			b2 = new BigDecimal(v2.toString());

			return b1.subtract(b2).setScale(scale, BigDecimal.ROUND_HALF_UP);
		} else {
			return BigDecimal.ZERO;
		}
	}

	/**
	 * * 两个Double数相乘 *
	 * 
	 * @param v1
	 *            *
	 * @param v2
	 *            *
	 * @return Double,四舍五入后结果
	 */
	public static Double mul(Double v1, Double v2) {
		BigDecimal b1 = null;
		BigDecimal b2 = null;

		if (v1 != null && v2 != null) {
			b1 = new BigDecimal(v1.toString());
			b2 = new BigDecimal(v2.toString());

			return new Double(b1.multiply(b2).doubleValue());
		} else {
			return null;
		}
	}

	/**
	 * @Title: mulBd
	 * @Description:  相乘返回BigDecimal类型数据
	 * @param v1
	 * @param v2
	 * @return
	 * @date: 2017年4月1日 上午11:49:31
	 * @return: BigDecimal
	 */
	public static BigDecimal mulBd(Object v1, Object v2) {
		BigDecimal b1 = BigDecimal.ZERO;
		BigDecimal b2 = BigDecimal.ZERO;

		if (v1 != null && v2 != null) {
			b1 = new BigDecimal(v1.toString());
			b2 = new BigDecimal(v2.toString());

			return b1.multiply(b2);
		} else {
			return BigDecimal.ZERO;
		}
	}

	/**
	 * * 两个Double数相乘，并保留scale位小数 *
	 * 
	 * @param v1
	 *            *
	 * @param v2
	 *            *
	 * @param scale
	 *            *
	 * @return Double,四舍五入后结果
	 */
	public static Double mul(Double v1, Double v2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}

		BigDecimal b1 = null;
		BigDecimal b2 = null;
		if (v1 != null && v2 != null) {
			b1 = new BigDecimal(v1.toString());
			b2 = new BigDecimal(v2.toString());

			return new Double(b1.multiply(b2).setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue());
		} else {
			return null;
		}
	}

	/**
	 * @Title: mulBd
	 * @Description: 相乘返回BigDecimal类型数据，四舍五入
	 * @param v1
	 * @param v2
	 * @param scale
	 * @return
	 * @date: 2017年4月1日 上午11:49:53
	 * @return: BigDecimal
	 */
	public static BigDecimal mulBd(Object v1, Object v2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}

		BigDecimal b1 = BigDecimal.ZERO;
		BigDecimal b2 = BigDecimal.ZERO;
		if (v1 != null && v2 != null) {
			b1 = new BigDecimal(v1.toString());
			b2 = new BigDecimal(v2.toString());

			return b1.multiply(b2).setScale(scale, BigDecimal.ROUND_HALF_UP);
		} else {
			return BigDecimal.ZERO;
		}
	}

	/**
	 * * 两个Double数相除 *
	 * 
	 * @param v1
	 *            *
	 * @param v2
	 *            *
	 * @return Double,四舍五入后结果
	 */
	public static Double div(Double v1, Double v2) {
		BigDecimal b1 = null;
		BigDecimal b2 = null;

		if (v1 != null && v2 != null) {
			b1 = new BigDecimal(v1.toString());
			b2 = new BigDecimal(v2.toString());

			return new Double(b1.divide(b2, DEF_DIV_SCALE, BigDecimal.ROUND_HALF_UP).doubleValue());
		} else {
			return null;
		}
	}

	/**
	 * @Title: divBd
	 * @Description: 相除返回BigDecimal类型数据
	 * @param v1
	 * @param v2
	 * @return
	 * @date: 2017年4月1日 上午11:50:06
	 * @return: BigDecimal
	 */
	public static BigDecimal divBd(Object v1, Object v2) {
		BigDecimal b1 = BigDecimal.ZERO;
		BigDecimal b2 = BigDecimal.ZERO;

		if (v1 != null && v2 != null) {
			b1 = new BigDecimal(v1.toString());
			b2 = new BigDecimal(v2.toString());

			return b1.divide(b2, DEF_DIV_SCALE, BigDecimal.ROUND_HALF_UP);
		} else {
			return BigDecimal.ZERO;
		}
	}

	/**
	 * * 两个Double数相除，并保留scale位小数 *
	 * 
	 * @param v1
	 *            *
	 * @param v2
	 *            *
	 * @param scale
	 *            *
	 * @return Double,四舍五入后结果
	 */
	public static Double div(Double v1, Double v2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}

		BigDecimal b1 = null;
		BigDecimal b2 = null;
		if (v1 != null && v2 != null) {
			b1 = new BigDecimal(v1.toString());
			b2 = new BigDecimal(v2.toString());

			return new Double(b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue());
		} else {
			return null;
		}
	}

	/**
	 * @Title: divBd
	 * @Description: 相除返回BigDecimal类型数据，四舍五入
	 * @param v1
	 * @param v2
	 * @param scale
	 * @return
	 * @date: 2017年4月1日 上午11:50:22
	 * @return: BigDecimal
	 */
	public static BigDecimal divBd(Object v1, Object v2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}

		BigDecimal b1 = BigDecimal.ZERO;
		BigDecimal b2 = BigDecimal.ZERO;
		if (v1 != null && (v2 != null)) {
			b1 = new BigDecimal(v1.toString());
			b2 = new BigDecimal(v2.toString());

			return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP);
		} else {
			return BigDecimal.ZERO;
		}
	}

	public static void main(String[] args) {
		int a = 11;
		int b = 3;
		double c = (double) a / b;
		System.out.println("非格式化-------:" + c);
		System.out.println("格式化-------:" + decimalFormat(c));

		int a1 = 2;

		Double d1 = 1.3;
		Double d2 = 0.7;

		Double dd = a1 * d1;
		Double dd1 = a1 / d1;
		Double dd2 = a1 + d1;
		Double dd3 = a1 + d1;
		System.out.println("dd-------" + dd);
		System.out.println("dd1-------" + dd1);
		System.out.println("dd2-------" + dd2);
		System.out.println("dd3-------" + dd3);

		System.out.println("Double与非Double类型数据运算,返回Double类型数据");
		System.out.println(add(Double.valueOf(a1), d2));
		System.out.println(add(Double.valueOf(a1), d2, 1));
		System.out.println(sub(Double.valueOf(a1), d2));
		System.out.println(sub(Double.valueOf(a1), d2, 1));
		System.out.println(mul(Double.valueOf(a1), d2));
		System.out.println(mul(Double.valueOf(a1), d2, 0));
		System.out.println(div(Double.valueOf(a1), d2));
		System.out.println(div(Double.valueOf(a1), d2, 1));

		System.out.println("Double类型数据运算,返回Double类型数据");
		System.out.println(add(d1, d2));
		System.out.println(add(d1, d2, 0));
		System.out.println(sub(d1, d2));
		System.out.println(sub(d1, d2, 0));
		System.out.println(mul(d1, d2));
		System.out.println(mul(d1, d2, 0));
		System.out.println(div(d1, d2));
		System.out.println(div(d1, d2, 1));

		System.out.println("传入任意类型参数，返回BigDecimal类型数据");
		System.out.println(addBd(d1, d2));
		System.out.println(addBd(d1, d2, 0));
		System.out.println(subBd(d1, d2));
		System.out.println(subBd(d1, d2, 0));
		System.out.println(mulBd(d1, d2));
		System.out.println(mulBd(0, d2, 1));
		System.out.println(divBd(null, null));
		System.out.println(divBd(0, 1, 1));

		long minuteNextDate = 20;
		Integer timeCharge = 3;
		System.out.println(minuteNextDate - timeCharge);

		Double nextPay = Double.valueOf(minuteNextDate) * Double.valueOf(timeCharge) / 100;
		System.out.println(nextPay);

		double f = 1.1;
		double d = 1.2;
		System.out.println(d + f);

		double t = 1.2;
		double g = t * 2;
		System.out.println(a + b);
		System.out.println(g);

		Double gg = add((f + d), g, 2);// 多个相加，必须精细化计算
		System.out.println(gg);
	}
}

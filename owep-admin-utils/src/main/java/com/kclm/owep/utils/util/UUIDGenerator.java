package com.kclm.owep.utils.util;

import java.io.Serializable;
import java.net.InetAddress;
import java.util.Random;
import java.util.UUID;

/**
 * @ClassName UUIDGenerator
 * @Description: UUID生成器32位(数字+字母混合)
 * @author: huangfei
 * @since: 2014-9-19 下午3:45:26
 */
public class UUIDGenerator {

	private UUIDGenerator() {

	}

	public static final int NUM_EIGHT = 8;

	public static final int NUM_TENTHREE = 13;

	public static final int NUM_NINE = 9;

	public static final int NUM_TENFOUR = 14;

	public static final int NUM_TENEIGHT = 18;

	public static final int NUM_TENNINE = 19;

	public static final int NUM_TWOTHREE = 23;

	public static final int NUM_TWOFOUR = 24;

	private final static String sep = "";

	private static final int IP;

	private static short counter = (short) 0;

	private static final int JVM = (int) (System.currentTimeMillis() >>> 8);

	private static long uniqueID = System.currentTimeMillis();

	static {
		int ipadd;
		try {
			ipadd = IptoInt(InetAddress.getLocalHost().getAddress());
		} catch (Exception e) {
			ipadd = 0;
		}
		IP = ipadd;
	}

	public static int IptoInt(byte[] bytes) {
		int result = 0;
		for (int i = 0; i < 4; i++) {
			result = (result << 8) - Byte.MIN_VALUE + bytes[i];
		}
		return result;
	}

	/**
	 * Unique across JVMs on this machine (unless they load this class in the
	 * same quater second - very unlikely)
	 */
	protected int getJVM() {
		return JVM;
	}

	/**
	 * Unique in a millisecond for this JVM instance (unless there are >
	 * Short.MAX_VALUE instances created in a millisecond)
	 */
	protected short getCount() {
		synchronized (UUIDGenerator.class) {
			if (counter < 0)
				counter = 0;
			return counter++;
		}
	}

	/**
	 * Unique in a local network
	 */
	protected int getIP() {
		return IP;
	}

	/**
	 * Unique down to millisecond
	 */
	protected short getHiTime() {
		return (short) (System.currentTimeMillis() >>> 32);
	}

	protected int getLoTime() {
		return (int) System.currentTimeMillis();
	}

	protected String format(int intval) {
		String formatted = Integer.toHexString(intval);
		StringBuffer buf = new StringBuffer("00000000");
		buf.replace(8 - formatted.length(), 8, formatted);
		return buf.toString();
	}

	protected String format(short shortval) {
		String formatted = Integer.toHexString(shortval);
		StringBuffer buf = new StringBuffer("0000");
		buf.replace(4 - formatted.length(), 4, formatted);
		return buf.toString();
	}

	public Serializable generateStringKey() {
		return new StringBuffer(36).append(format(getIP())).append(sep).append(format(getJVM())).append(sep).append(format(getHiTime())).append(sep).append(format(getLoTime())).append(sep)
				.append(format(getCount())).toString();
	}

	public Long generateLongKey() {
		return new Long(-(getIP() + getJVM() + getHiTime() + getLoTime() + getCount()));
	}

	/**
	 * @Description： 以UUID的方式生成数字字母混合32位主键
	 * @author: huangfei
	 * @since: 2015-5-13 上午12:16:26
	 */
	public static synchronized String generaterStringPrimaryKey() {
		UUID uuid = UUID.randomUUID();
		if (null == uuid || "".equals(uuid.toString())) {
			throw new NullPointerException("uuid is null");
		}
		String primaryKey = String.valueOf(uuid);

		if (null != primaryKey && primaryKey.contains("-")) {
			primaryKey = primaryKey.replaceAll("-", "");
		}
		return primaryKey;
	}

	/**
	 * @Description： 生成纯数字UUID19位(前边或带-号)
	 * @author: huangfei
	 * @since: 2015-5-13 上午12:12:10
	 */
	public static synchronized Long generaterLongPrimaryKey() {
		UUID uuid = UUID.randomUUID();
		return uuid.getMostSignificantBits();
	}

	/**
	 * @Description： 生成纯数字UUID16位
	 * @author: huangfei
	 * @since: 2015-5-13 上午12:13:45
	 */
	public static String generate() {
		uniqueID++;
		return String.valueOf(uniqueID * 1000L + (new Random()).nextInt(999));
	}

	/**
	 * @Description： 生成纯数字UUID16位
	 * @author: huangfei
	 * @since: 2015-5-13 上午12:13:45
	 */
	public static synchronized Long generaterLongPrimaryKeyByTime() {
		uniqueID++;
		return uniqueID * 1000L + (new Random()).nextInt(999);
	}

	public static void resetPrimaryKey() {
		uniqueID = System.currentTimeMillis();
	}

	/**
	 * @Description： 获取nanoTime+两位随机数生成 UUID
	 * @author: huangfei
	 * @since: 2015-5-12 下午11:53:24
	 */
	public static synchronized Long generaterLongKeyByNanoTime() {
		return System.nanoTime() + (new Random()).nextInt(99);
	}

	/**
	 * @Description： 获取nanoTime生成 UUID
	 * @author: huangfei
	 * @since: 2014-11-3 上午11:43:51
	 */
	public synchronized static Long generaterKeyByNanoTime() {
		return System.nanoTime();
	}

	/**
	 * @Title: getUUID
	 * @Description: 获取UUID
	 * @return
	 * @return: String
	 * @throws:
	 * @author: huangfei
	 * @date: 2013-8-10 上午8:07:31
	 */
	public static String getUUID() {
		UUID uuid = UUID.randomUUID();
		String str = uuid.toString();
		/**
		 * 去掉"-"符号
		 */
		String temp = str.substring(0, NUM_EIGHT) + str.substring(NUM_NINE, NUM_TENTHREE) + str.substring(NUM_TENFOUR, NUM_TENEIGHT) + str.substring(NUM_TENNINE, NUM_TWOTHREE)
				+ str.substring(NUM_TWOFOUR);

		return temp;
	}

	/**
	 * @Title: getUUID
	 * @Description: 获得指定数量的UUID
	 * @param number
	 * @return
	 * @return: String[]
	 * @throws:
	 * @author: huangfei
	 * @date: 2013-8-10 上午8:07:46
	 */
	public static String[] getUUID(int number) {
		if (number < 1) {
			return null;
		}
		String[] ss = new String[number];
		for (int i = 0; i < number; i++) {
			ss[i] = getUUID();
		}
		return ss;
	}

	public static String[] chars = new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3",
			"4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };

	public static String generateShortUuid() {
		StringBuffer shortBuffer = new StringBuffer();
		String uuid = UUID.randomUUID().toString().replace("-", "");
		for (int i = 0; i < 8; i++) {
			String str = uuid.substring(i * 4, i * 4 + 4);
			int x = Integer.parseInt(str, 16);
			shortBuffer.append(chars[x % 0x3E]);
		}
		return shortBuffer.toString();

	}

	/**
	 * @Description： Test
	 * @author: huangfei
	 * @since: 2014-2-24 下午9:36:16
	 */
	public static void main(String[] args) {
		System.out.println(generaterKeyByNanoTime());
		System.out.println(generaterLongKeyByNanoTime());

	}
}

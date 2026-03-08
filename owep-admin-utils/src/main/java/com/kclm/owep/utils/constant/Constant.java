package com.kclm.owep.utils.constant;

/**
 * @ClassName: Constant
 * @Description: 静态常量类
 * @author: huangfei
 * @date: 2017年4月1日 上午11:35:47
 */
public class Constant {

    public final static String UTF_8 = "utf-8";

    /**
     * 版本更新标题
     */
    public static final String VERSION_TITLE = "title";
    /**
     * 版本更新项
     */
    public static final String VERSION_ITEM = "item";
    /**
     * 在线人数
     */
    public static final String ONLINE_COUNT = "onlineCount";
    /**
     * 管理员
     */
    public final static int TYPE_MANAGER = 1;
    /**
     * 教师
     */
    public final static int TYPE_TEACHER = 2;
    /**
     * 咨询师
     */
    public final static int TYPE_SALSEMAN = 4;
    /**
     * HR
     */
    public final static int TYPE_HR = 2;

    /**
     * 选择题
     */
    public final static int QUESTYPE_CHOOSE = 1;
    /**
     * 填空题
     */
    public final static int QUESTYPE_FILL = 2;
    /**
     * 简答题
     */
    public final static int QUESTYPE_SHOR = 3;
    /**
     * 判断题
     */
    public final static int QUESTYPE_TF = 4;
    /**
     * 多选题
     */
    public final static int QUESTYPE_MANYCHOOSE = 5;
    /**
     * 数据库备份属性文件
     */
    public final static String DB_PROPERTIESNAME = "/dbbackup.properties";
    /**
     * 数据库IP地址
     */
    public final static String DB_HOSTIP = "hostip";
    /**
     * 数据库名称
     */
    public final static String DB_USERNAME = "username";
    /**
     * 数据库密码
     */
    public final static String DB_PASSWORD = "password";
    /**
     * 备份名称
     */
    public final static String DB_DATABASE = "database";
    /**
     * 备份路径
     */
    public final static String DB_FILEPATH = "filepath";
    /**
     * 版本更新
     */
    public final static String VERSION = "/version.properties";
    /**
     * 用户使用状态
     */
    public final static int USER_STATUS = 1;
    /**
     * 学生信息完善
     */
    public final static String STU_PERSTATUS = "1";
    /**
     * 邮箱使用 (请求的链接不正确或失效,请重新操作)
     */
    public final static String USER_EMAIL_NOT_LINK = "请求的链接不正确或失效,请重新操作.";
    /**
     * 链接错误,无法找到匹配用户,请重新申请找回密码.
     */
    public final static String USER_EMAIL_NOTUSER = "链接错误,无法找到匹配用户,请重新申请找回密码.";
    /**
     * 链接不正确,是否已经过期了,请重新申请
     */
    public final static String USER_EMAIL_NOT_OUTDATE = "链接不正确,是否已经过期了,请重新申请";
    /**
     * 密码修改成功!
     */
    public final static String USER_EMAIL_RESET_PASSWORD = "密码修改成功!";
    /**
     * 修改密码失败,请返回重新修改!
     */
    public final static String USER_EMAIL_RESET_FALI = "修改密码失败,请返回重新修改!";
    public final static String PWD_NOT_EQUALS = "两次密码不一样！";
    public final static String PWD_IS_EMPTY = "密码不可以为空！";
    public final static String VERIFY_ERROR = "验证码错误！";
    /**
     * 表示owep-web发送
     */
    public final static int CONTROLLERTYPE_ONE = 1;
    /**
     * 表示owep-stu发送
     */
    public final static int CONTROLLERTYPE_TWO = 2;
    /**
     * 热门视频
     */
    public final static String COURSE_VIDEOSTATUSONE = "1";
    /**
     * 免费视频
     */
    public final static String COURSE_VIDEOSTATUSCOST = "2";
    /**
     * 分页参数 开始页
     */
    public static int PAGE_IDISPLAYSTART = 0;
    /**
     * 分页参数 结束页
     */
    public static int PAGE_IDISPLAYLENGTH = 6;
    /**
     * 学员故事,如果为0表示查询全部
     */
    public static int NEWS_STUSTORY = 1;

    /**
     * 新闻资讯,如果为0表示查询全部
     */
    public static int NEWS_NEWSINFO = 2;

    /**
     * 表示正常(没有删除)
     **/
    public static int LOGIC_DELETE_1 = 1;
    /**
     * 表示已删除
     **/
    public static int LOGIC_DELETE_0 = 0;

}

package utils;

/**
 * Description 枚举接口
 * 1.实现该接口得到处理枚举的方法
 * 2.和Mybatis自动枚举转换为相对的Code值
 *
 * @author duanzh
 * @version 1.0
 * @date 2020/5/13 3:07 下午
 */
public interface MyBaseEnum {

    /**
     * map容器初始化参数
     * 留意下面条件（扩容因子默认0.75）
     * initialCapacity * 0.75 > 子类枚举数目
     */
    int initialCapacity = 48;

    /**
     * 返回关键字段的值
     *
     * @return
     */
    default String getName() {
        return toString();
    }

    /**
     * 需要二进制打标功能的枚举：Code必须从1开始，不能为0
     * 用于替代枚举的ordinal()方法
     * 用枚举的排序来参与计算肯定不靠谱
     *
     * @return
     */
    Integer getCode();
}

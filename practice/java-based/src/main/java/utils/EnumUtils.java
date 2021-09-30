package utils;

import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * 枚举工具类
 *   1.一些方便使用枚举功能
 *   2.用于二进制打标（Long类型）
 *
 * @author duanzh
 * @version 1.0
 * @date 2020/5/13 3:10 下午
 * <br/>
 */
public class EnumUtils {

    private static Map<String, MyBaseEnum[]> enumMap;

    private static Map<String, List<String>> enumNameMap;

    /**
     * 得到该类型的所有枚举实例
     *
     * @param clazz
     */
    public static <T extends MyBaseEnum> MyBaseEnum[] getEnums(Class<T> clazz) {
        if (enumMap == null) {
            enumMap = new ConcurrentHashMap<>(MyBaseEnum.initialCapacity);
        }
        if (enumMap.get(clazz.getName()) == null) {
            MyBaseEnum[] enums = clazz.getEnumConstants();
            if (enums == null) {
                throw new IllegalArgumentException(clazz.getSimpleName() + " does not represent an Enum type.");
            }
            enumMap.put(clazz.getName(), enums);
        }
        return enumMap.get(clazz.getName());
    }

    /**
     * 得到该类型的所有枚举实例的name
     *
     * @param clazz
     */
    public static <T extends MyBaseEnum> List<String> getEnumNames(Class<T> clazz) {
        if (enumNameMap == null) {
            enumNameMap = new HashMap<>(MyBaseEnum.initialCapacity);
        }
        if (enumNameMap.get(clazz.getName()) == null) {
            MyBaseEnum[] enums = getEnums(clazz);
            List<String> valueList = new ArrayList<>(enums.length);
            for (MyBaseEnum MyBaseEnum : enums) {
                valueList.add(MyBaseEnum.getName());
            }
            enumNameMap.put(clazz.getName(), valueList);
        }
        return enumNameMap.get(clazz.getName());
    }

    /**
     * 获取code返回枚举对象，为空返回默认值
     *
     * @param clazz
     * @param code
     * @param def
     * @param <T>
     * @return
     */
    public static <T extends MyBaseEnum> T codeOfDefault(Class<T> clazz, Integer code, T def) {

        return Optional.ofNullable(codeOf(clazz, code)).orElse(def);
    }

    /**
     * 获取code返回枚举对象
     *
     * @param clazz
     * @param code
     */
    public static <T extends MyBaseEnum> T codeOf(Class<T> clazz, Integer code) {
        MyBaseEnum[] enums = getEnums(clazz);
        for (MyBaseEnum e : enums) {
            if (code != null && e.getCode().equals(code)) {

                @SuppressWarnings("unchecked")
                T enumMes = (T) e;
                return enumMes;
            }
        }
        return null;
    }

    /**
     * enum对应的code的集合转化成对应的枚举集合。
     */
    public static <T extends MyBaseEnum> List<T> codeOfList(Class<T> clazz, Integer... arr) {
        if (arr == null) {
            return Collections.EMPTY_LIST;
        }

        List<T> result = new ArrayList(arr.length);
        for (Integer val : arr) {
            T t = codeOf(clazz, val);
            if (t != null) {
                result.add(t);
            }
        }
        return result;
    }

    /**
     * 获取value返回枚举对象，为空返回默认
     *
     * @param clazz
     * @param name
     * @param def
     * @param <T>
     * @return
     */
    public static <T extends MyBaseEnum> T valueOfDefault(Class<T> clazz, String name, T def) {

        return Optional.ofNullable(valueOf(name, clazz)).orElse(def);
    }

    /**
     * 获取value返回枚举对象
     *
     * @param clazz
     * @param name
     */
    public static <T extends MyBaseEnum> T valueOf(String name, Class<T> clazz) {
        MyBaseEnum[] enums = getEnums(clazz);
        for (MyBaseEnum e : enums) {
            if (StringUtils.isNotBlank(name) && e.getName().equals(name)) {

                @SuppressWarnings("unchecked")
                T enumMes = (T) e;
                return enumMes;
            }
        }
        return null;
    }

    /**
     * enum对应的关键字段的集合转化成对应的枚举集合。
     */
    public static <T extends MyBaseEnum> List<T> valueOfList(Class<T> clazz, String... arr) {
        if (arr == null) {
            return Collections.EMPTY_LIST;
        }

        List<T> result = new ArrayList(arr.length);
        for (String val : arr) {
            T t = valueOf(val, clazz);
            if (t != null) {
                result.add(t);
            }
        }
        return result;
    }

    /**
     * enum对应的关键字段的集合转化成对应的数值。
     */
    public static <T extends MyBaseEnum> long toEnumBit(Class<T> clazz, String... arr) {
        // 计算数值
        long value = 0L;
        if (arr == null) {
            return value;
        }

        MyBaseEnum[] enums = getEnums(clazz);
        for (String val : arr) {
            for (MyBaseEnum e : enums) {
                if (e.getName().equals(val)) {
                    value += 1L << e.getCode();
                }
            }
        }
        return value;
    }

    /**
     * 将bit转换成表示的所有enum的关键字段，并将结果格式成字符串
     */
    public static <T extends MyBaseEnum> String toEnumString(Class<T> clazz, long bit) {
        /**
         * enum的ordinal以0起始。但以位表示enum时，0表示没有任何enum存在，所以这里不是小于0而是小于1。
         */
        if (bit < 1L) {
            return null;
        }
        List<MyBaseEnum> list = toEnums(clazz, bit);

        String s = list.stream().map(MyBaseEnum::getName).collect(Collectors.joining(","));
        return s;
    }

    /**
     * 将bit转换成表示的所有enum
     */
    public static <T extends MyBaseEnum> List<MyBaseEnum> toEnums(Class<T> clazz, long bit) {
        /**
         * enum的ordinal以0起始。但以位表示enum时，0表示没有任何enum存在，所以这里不是小于0而是小于1。
         */
        if (bit < 1L) {
            return Collections.EMPTY_LIST;
        }

        MyBaseEnum[] enums = getEnums(clazz);
        List<MyBaseEnum> result = new ArrayList<>(enums.length);
        for (MyBaseEnum e : enums) {
            // 以bit表示的task监测点。
            long currentBitPoint = bit & (1L << e.getCode());
            if (currentBitPoint > 0L) {
                result.add(e);
            }
        }
        return result;
    }

    /**
     * @param clazz
     * @param collection 为null抛出NPE
     * @return collection元素为空不参考clazz 返回true
     */
    public static <T extends MyBaseEnum> boolean checkValues(Class<T> clazz, Collection<String> collection) {
        int result = 0;
        for (CharSequence charSequence : collection) {
            result += getEnumNames(clazz).contains(charSequence) ? 1 : 0;
        }
        return result == collection.size();
    }

    /**
     * 比较Value
     *
     * @param value
     * @param enumType 为null抛出NPE
     * @param <T       extends MyBaseEnum>
     * @return
     */
    public static <T extends MyBaseEnum> boolean equals(String value, T enumType) {
        return valueOf(value, enumType.getClass()) == enumType;
    }

    /**
     * 比较Code
     *
     * @param code
     * @param enumType 为null抛出NPE
     * @param <T       extends MyBaseEnum>
     * @return
     */
    public static <T extends MyBaseEnum> boolean equals(Integer code, T enumType) {
        return codeOf(enumType.getClass(), code) == enumType;
    }


}

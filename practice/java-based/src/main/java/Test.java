import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author : zhduan
 * @version : 1.0
 * @date: 2021/9/10 4:42
 * @Description : PACKAGE_NAME
 */
public class Test {

    public static void main(String[] args) {
        HashMap<Object, Object> map = new HashMap<>();
        Object a = map.put("a", 1);
        Object a1 = map.put("a", 2);
        System.out.println(a);
        System.out.println(a1);
        System.out.println(map);

        HashSet<Object> set = new HashSet<>();
    }
}

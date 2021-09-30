package network;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author : zhduan
 * @version : 1.0
 * @date: 2021/9/11 6:13
 * @Description : network
 */
public class Api {

    /**
     * 需要深入研究 类加载器：ClassLoader
     *
     * 问题：是否可以利用反射获取Class类本身的Class对象？
     * Exception in thread "main" java.lang.SecurityException: Cannot make a java.lang.Class constructor accessible
     *
     * @param args
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     */
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

//        Class<?> aClass = Class.forName("java.lang.Class");
        Class<?> aClass = Class.forName("network.A");

//        Constructor cons = aClass.getDeclaredConstructor();
//        cons.setAccessible(true);
////
//        Object a = cons.newInstance();
//        System.out.println(a);
//        Method say = aClass.getMethod("say", null);
//        say.invoke(a);
        Class<? extends Class> c1 = aClass.getClass();

        ClassLoader loader = aClass.getClassLoader();
        Class<?> clazz = loader.loadClass("java.lang.Class");

        System.out.println(c1.hashCode());
        System.out.println(clazz.hashCode());
        System.out.println(aClass.hashCode());

        Class aClass1 = Class.class.newInstance();

    }



}

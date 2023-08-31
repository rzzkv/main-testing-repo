package jUnit;

import org.junit.jupiter.params.ParameterizedTest;

import java.lang.reflect.Method;

public class MiniJUnit {

    public static void main(String[] args) throws Exception {

        Method[] methods = JUnitSimpleTest.class.getDeclaredMethods();
        for (Method method : methods) {
            ParameterizedTest annotation = method.getAnnotation(ParameterizedTest.class);
            if (annotation != null) {
                JUnitSimpleTest instance = JUnitSimpleTest.class.getConstructor().newInstance();method.invoke(instance);
                System.out.println("TEST PASSED!!!");
//                try {
//                    method.invoke(instance);
//                } catch (Exception e) {
//                    System.out.println("TEST BROKEN!!!");
//                    return;
//                }
//                System.out.println("TEST PASSED!!!");
//            }else {
//                System.out.println("@Test annotation does not exist");
            }
        }
    }
}
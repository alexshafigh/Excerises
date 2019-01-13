package com;

import com.Exercise9.Annotations.Test;
import com.Exercise9.Class.AnnotTest;
import com.Exercise9.Exceptions.MyException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Excercise9Main {
    public static void main(String[] args) {

        runTest(new AnnotTest());
    }

    public static void runTest(AnnotTest annotTest) {
        // Load annotTest --> done as input
        //find all methos in annotTest with @Test
        //run all above Methods  //** for running methods use invoke
        //everyOne on above methos in which give an exception goes to exceplist
        ///********* the method which throws exception you get the Exception and throw an new Exception as Your exception name and put the methods exception in your exceptions's cause
        //everyOne on above methods in which give no exception goes to succsslist
        //at the end divide exceplist.lenght by allmethods.size() which shows fail Percent
        // and divide succsslist.lenght by allmethods.size() which shows success Percent

        List<Method> successMethodList = new ArrayList<>();
        List<Method> failureMethodList = new ArrayList<>();
        Method[] methods = annotTest.getClass().getDeclaredMethods();
        int all_size = 0;
        double success_methods = 0;
        double fails_methods = 0;
        for (Method method : methods) {
            method.setAccessible(true);
            if (method.isAnnotationPresent(Test.class)) {
                System.out.println("---------------------------------");
                System.out.println(" Method " + method.getName() + "()");
                System.out.println("---------------------------------");
                all_size++;
                try {
                    method.invoke(annotTest);
                    successMethodList.add(method);
                    success_methods++;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    failureMethodList.add(method);
                    fails_methods++;
                    try {
                        System.out.println(" Throws Exception");
                        throw new MyException(" Exception ", e.getCause());
                    } catch (Exception e1) {
                        System.out.println(e1.toString());
                    }
                }
            } else {
                System.out.println(" ***********************************");
                System.out.println(" Method " + method.getName() + "()" + "has No " + Test.class.toString() + " Annotation");
                System.out.println(" ***********************************");
            }
            success_methods = success_methods / 1.0;
            fails_methods = fails_methods / 1.0;
            if (all_size != 0) {
                float sx = (float) (success_methods / all_size);
                float fl = (float) (fails_methods / all_size);
                System.out.println(" Success Percent Ever is " + sx * 100 + "%");
                System.out.println(" Failure Percent Ever is " + fl * 100 + "%");
            }
        }
    }
}

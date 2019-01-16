package com.Exercise11;

import com.Exercise11.Annotation.I2;
import com.Exercise11.Annotation.Transactional;
import com.Exercise11.Class.ProxyFactory;
import com.Exercise11.Class.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyTest {
    public static void main(String[] args) {

        //Access to Service  Class by a proxy Object
        //read all its functions
        //list all functions with transactional interface
        //call every method in the list
        //print ("Start Transaction")
        //invoke method
        //if no exception happend print ("Commit Transaction")
        //else print("Transaction Rollback")
        Service service = new Service();
//        Class aClass = Service.class;
        Method[] methods = service.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Transactional.class)) {
                try {
                    System.out.println("Mmethod " + method.getName() + " Start Transaction");
                    method.invoke(service);
                    System.out.println(" Transaction Commited ");
                    System.out.println("-------------------------------------------------");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    System.out.println("Mmethod " + method.getName() + " Rolled Backed");
                    System.out.println("**************************************************" +
                            "");
//                     e.printStackTrace();
                }
            }
        }


//        Class c = getProxy().getClass();
//        Method[] methods = c.getDeclaredMethods();
//        for (Method method:methods){
//            if (method.isAnnotationPresent(Transactional.class)){
//                System.out.println(method.getName());
//                try {
//                    System.out.println("Mmethod " + method.getName() + "Start Transaction");
//                    method.invoke(c);
//                } catch (IllegalAccessException e) {
//                    e.printStackTrace();
//                } catch (InvocationTargetException e) {
//                    System.out.println("Mmethod" + method.getName() + "Rolled Backed");
//                    e.printStackTrace();
//                }
//            }
//        }

    }

    public static I2 getProxy() {
        return (I2) ProxyFactory.createProxy(new Service());
    }
}

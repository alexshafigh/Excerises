package com.Exercise11.Class;

import com.Exercise11.Interfaces.I2;

public class ProxyFactory {

    private static Service service;
//    static com.Exercise11.Class.Proxy proxy;

//
//    public static Object createProxyForMe(Class aClass){
//        return   java.lang.reflect.Proxy.newProxyInstance(aClass.getClass().getClassLoader(),
//                                                        aClass.getClass().getInterfaces() ,
//                                                        new IHandler(aClass.getClass())
//        );
//    }

    public static I2 createProxyForMe(Service servicez){
        service = servicez;
        return  (I2) java.lang.reflect.Proxy.newProxyInstance(servicez.getClass().getClassLoader(),
                servicez.getClass().getInterfaces(),
                new IHandler(servicez));
    }

//    public static Service createProxy(String s) {
//        Service service = null;
//        switch (s){
//            case "Service":{
//                service = (Service) proxy.getInstance();
//            }
//        }
//        return service;
//    }

//    public static Object createProxy(Service service) {
//        return java.lang.reflect.Proxy.newProxyInstance(service.getClass().getClassLoader(),
//                service.getClass().getInterfaces(),
//                new ProxyFactory(service));
//    }

}


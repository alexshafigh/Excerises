package com.Exercise11.Class;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ProxyFactory implements InvocationHandler {

    private Service service;

    private ProxyFactory(Service service) {
        this.service = service;
    }

    public static Object createProxy(Service service) {
        return java.lang.reflect.Proxy.newProxyInstance(service.getClass().getClassLoader(),
                service.getClass().getInterfaces(),
                new ProxyFactory(service));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        try {
//            System.out.println("Mmethod" + method.getName() + "Start Transaction");
            result = method.invoke(service, args);
        } catch (InvocationTargetException e) {
//            System.out.println("Mmethod" + method.getName() + "Rolled Backed");
        } catch (Exception r) {
            r.printStackTrace();
        }
        return result;
    }

}


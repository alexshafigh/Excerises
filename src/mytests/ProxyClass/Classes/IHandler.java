package mytests.ProxyClass.Classes;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class IHandler implements InvocationHandler {

    private Target target;

    private IHandler(Target target) {
        this.target = target;
    }

    public static Object createProxyForMe(Target target) {
        return java.lang.reflect.Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new IHandler(target)
        );
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        try {
            result = method.invoke(target, args);
        } catch (Exception r) {
            r.printStackTrace();
        }
        return result;
    }
}

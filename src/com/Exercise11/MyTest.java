package com.Exercise11;

import com.Exercise11.Annotation.Transactional;
import com.Exercise11.Class.ProxyFactory;
import com.Exercise11.Class.Service;
import com.Exercise11.Interfaces.I2;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

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


        System.out.println(Runtime.getRuntime().availableProcessors());


        //use of proxy class for calling service
        //Solution1
//        I2 service = Proxy.getInstance() ;


        //use of proxy Factory class for calling service
        //Solution2
//        I2 service = ProxyFactory.createProxy("Service");

        //make proxy class be Synthesized By reflection.proxy
        // solution 3
//        ((I2)ProxyFactory.createProxyForMe(Service.class)).m1();
//        if ( ProxyFactory.createProxyForMe(new Service()) instanceof I2 )
//            System.out.println("salam");

//            getService().m1();

//        (Service)((I2)(ProxyFactory.createProxyForMe(new Service())))    .m1();
//        getService();
//
//        for (int i = 0 ; i< getService().getClass().getAnnotations().length ; i++)
//            System.out.println(getService().getClass().getAnnotations()[i].toString());
//

        Method[] declaredMethods = Service.class.getDeclaredMethods();
        List<Method> methodz = new ArrayList<>();

        for (int t= 0 ; t< declaredMethods.length ; t++){
            if (declaredMethods[t].isAnnotationPresent(Transactional.class))
                methodz.add(declaredMethods[t]);
        }



//        Method[] methods = getService().getClass().getDeclaredMethods();
//        List<Method> methodss = Arrays.asList(methods);
//        for (Method method:methodss){
//            int counter = 0;
//            if (methodz.contains(methodss.get(counter)) && counter < methodss.size() ) {

////
//                for (Method method:methodz)
//                {
//                System.out.println(method.getName());
//                try {
////                    System.out.println("Mmethod " + method.getName() + " Start Transaction");
//                      method.invoke(getService());
////                    System.out.println(" Transaction Commited ");
////                    System.out.println("-------------------------------------------------");
//                } catch (IllegalAccessException e) {
////                    e.printStackTrace();
//                } catch (InvocationTargetException e) {
////                    System.out.println("Mmethod " + method.getName() + " Rolled Backed");
////                    System.out.println("**************************************************" +
////                            "");
////                     e.printStackTrace();
//                }catch (Exception e){e.printStackTrace();}
//        }
////        counter ++;
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


        public static I2 getService(){
            return ProxyFactory.createProxyForMe(new Service());
        }
}

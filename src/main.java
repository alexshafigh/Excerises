import com.Excercise6.GeneralPublisher;
import com.Excercise6.GeneralSubscriber;
import com.Excercise6.SingletonPublisher;
import com.Excercise6.SingletonSubscriber;

import javax.xml.transform.Source;

public class main {
    public static void main(String[] args) {

        //////Singletonetone Subscriber
        /*
        SingletonPublisher publisher = SingletonPublisher.getPublisher();
        SingletonSubscriber subscriber  = new SingletonSubscriber("P1" , publisher);
        SingletonSubscriber subscriber1 = new SingletonSubscriber("P2" , publisher);
        SingletonSubscriber subscriber2 = new SingletonSubscriber("P3" , publisher);

        publisher.printAllSubscribers();
        publisher.sendMessageToAll();
        for (SingletonSubscriber subscriber3:publisher.getAllSubscribers())
            System.out.println(subscriber3.getMessage());

        publisher.sendMessage(subscriber1 , "Salam Babaam");
        System.out.println("============ After Sending Custom Message =========");
        for (SingletonSubscriber subscriber4:publisher.getAllSubscribers())
            System.out.println(subscriber4.getMessage());
*/

        //////Multitone Subscriber

        GeneralPublisher gp1 = new GeneralPublisher("gp1");
        GeneralPublisher gp2 = new GeneralPublisher("gp2");

        GeneralSubscriber gs1 = new GeneralSubscriber("gs1");
        GeneralSubscriber gs2 = new GeneralSubscriber("gs2");
        GeneralSubscriber gs3 = new GeneralSubscriber("gs3");

        gs1.setPublisher(gp1);
        gs1.setPublisher(gp2);

        gs2.setPublisher(gp1);
        gs2.setPublisher(gp2);

        gs3.setPublisher(gp1);

        System.out.println("============  list gs1  Publisher =========");
        for (GeneralPublisher generalPublisher1:gs1.getAllPublishers())
            System.out.println(generalPublisher1.getName());

        System.out.println("============  list gs2  Publisher =========");
        for (GeneralPublisher generalPublisher2:gs2.getAllPublishers())
            System.out.println(generalPublisher2.getName());

        System.out.println("============  list gs3  Publisher =========");
        for (GeneralPublisher generalPublisher3:gs3.getAllPublishers())
            System.out.println(generalPublisher3.getName());


        System.out.println("============  list gp1  Subscribers =========");
            gp1.printAllSubscribers();

        System.out.println("============  list gp2  Subscribers =========");
        gp2.printAllSubscribers();


        //////////solution2
//        SingletonPublisher  publisher = new SingletonPublisher();
//        SingletonSubscriber subscriber = new SingletonSubscriber();
//        SingletonSubscriber subscriber1 = new SingletonSubscriber();
//        SingletonSubscriber subscriber2 = new SingletonSubscriber();
//        publisher.subscribe(subscriber);
//        publisher.subscribe(subscriber1);
//        publisher.subscribe(subscriber2);





    }
}

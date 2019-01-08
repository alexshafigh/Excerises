package com.Excercise6;

import com.Excercise6.Interfaces.Publisher;
import com.Excercise6.Interfaces.Subscriber;

import java.util.ArrayList;
import java.util.List;

public class SingletonPublisher implements Publisher {
//    static Set<SingletonSubscriber> subscriberslist = new HashSet<>(); ///first Implementation
    List<Subscriber> subscriberslist = new ArrayList<>();  //Second Implementation
    static SingletonPublisher publisher;


    private SingletonPublisher() {
    }

    public static SingletonPublisher getPublisher() {
        if (publisher == null) return publisher = new SingletonPublisher();
        else return publisher;
    }

    public void printAllSubscribers() {
        for (Subscriber subscriber : subscriberslist) {
            System.out.println(subscriber.getName());
        }
    }
    @Override
    public void addSubscriber(Subscriber subscriber) {
        if (!subscriberslist.contains(subscriber))
            subscriberslist.add((SingletonSubscriber) subscriber);
    }
    public void sendMessageToAll() { // send a message to all subscriberslist
        for (Subscriber subscriber : subscriberslist) {
            subscriber.setMessage(" Hey Dude... You Are Under My Provision");
        }
    }
    public void sendMessage(SingletonSubscriber subscriber , String custom_message) { // send a message to all subscriberslist
        subscriberslist.get(subscriberslist.indexOf(subscriber)).setMessage(custom_message);
    }

    @Override
    public List<Subscriber> getAllSubscribers() {
/*Initial Version
        List<SingletonSubscriber> subscriberList = new ArrayList<>();
        Iterator iterator = subscriberslist.iterator();
        while (iterator.hasNext()) subscriberList.add((SingletonSubscriber) iterator.next());
        return subscriberList;
  /*/
        return subscriberslist; //second version
    }
}

package com.Excercise6;

import java.util.*;

public class SingletonPublisher {
//    static Set<SingletonSubscriber> subscriberslist = new HashSet<>(); ///first Implementation
    static List<SingletonSubscriber> subscriberslist = new ArrayList<>();  //Second Implementation
    static SingletonPublisher publisher;

    private SingletonPublisher() {
    }

    public static SingletonPublisher getPublisher() {
        if (publisher == null) return publisher = new SingletonPublisher();
        else return publisher;
    }

    public void printAllSubscribers() {
        for (SingletonSubscriber subscriber : subscriberslist) {
            System.out.println(subscriber.getName());
        }
    }
    void addSubscriber(SingletonSubscriber subscriber) {
        if (!subscriberslist.contains(subscriber))
            subscriberslist.add(subscriber);
    }
    public void sendMessageToAll() { // send a message to all subscriberslist
        for (SingletonSubscriber subscriber : subscriberslist) {
            subscriber.setMessage(" Hey Dude... You Are Under My Provision");
        }
    }
    public void sendMessage(SingletonSubscriber subscriber , String custom_message) { // send a message to all subscriberslist
        subscriberslist.get(subscriberslist.indexOf(subscriber)).setMessage(custom_message);
    }
    public List<SingletonSubscriber> getAllSubscribers() {
/*Initial Version
        List<SingletonSubscriber> subscriberList = new ArrayList<>();
        Iterator iterator = subscriberslist.iterator();
        while (iterator.hasNext()) subscriberList.add((SingletonSubscriber) iterator.next());
        return subscriberList;
  /*/
        return subscriberslist; //second version
    }
}

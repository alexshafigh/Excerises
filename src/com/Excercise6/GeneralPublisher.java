package com.Excercise6;

import com.Excercise6.Interfaces.Subscriber;

import java.util.ArrayList;
import java.util.List;

public class GeneralPublisher {
    List<GeneralSubscriber> subscriberslist = new ArrayList<>();  //Second Implementation
    String name;

    public GeneralPublisher(String name) {
        this.name = name;
    }
    public void printAllSubscribers() {
        for (GeneralSubscriber subscriber : subscriberslist) {
            System.out.println(subscriber.getName());
        }
    }
    void addSubscriber(GeneralSubscriber subscriber) {
        if (!subscriberslist.contains(subscriber))
            subscriberslist.add(subscriber);
    }
    public void sendMessageToAll() { // send a message to all subscriberslist
        for (Subscriber subscriber : subscriberslist) {
            subscriber.setMessage(" Hey Dude... You Are Under My Provision");
        }
    }
    public void sendMessage(SingletonSubscriber subscriber , String custom_message) { // send a message to all subscriberslist
        subscriberslist.get(subscriberslist.indexOf(subscriber)).setMessage(custom_message);
    }

    public List<GeneralSubscriber> getAllSubscribers() {
/*Initial Version
        List<SingletonSubscriber> subscriberList = new ArrayList<>();
        Iterator iterator = subscriberslist.iterator();
        while (iterator.hasNext()) subscriberList.add((SingletonSubscriber) iterator.next());
        return subscriberList;
  /*/
//        return subscriberslist; //second version

        return subscriberslist; //Third version
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

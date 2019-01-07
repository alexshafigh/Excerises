package com.Excercise6;

import com.Excercise6.Interfaces.Subscriber;

public class SingletonSubscriber implements Subscriber {
    final SingletonPublisher publisher;
    private String name;
    private String message ;

    public SingletonSubscriber(String name , SingletonPublisher publisher) {
        this.name = name ;
        this.publisher = publisher;
        this.message = " No Message ";
        publisher.addSubscriber(this);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void getAllPublishers(){
        //for all publishers in Publiher set i have to iterate Through set
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SingletonPublisher getPublisher() {
        return publisher;
    }
}

package com.Excercise6;

import com.Excercise6.Interfaces.Subscriber;

import java.util.ArrayList;
import java.util.List;

public class GeneralSubscriber implements Subscriber {

    List<GeneralPublisher> publishers = new ArrayList<>();  //first Implementation
    private String name;
    private String message ;

    public GeneralSubscriber(String name) {
        this.name = name ;
        this.message = " No Message ";
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    public void setPublisher(GeneralPublisher publisher){
        if (!publishers.contains(publisher))
            publishers.add(publisher);
        publisher.addSubscriber(this);
    }
    public List<GeneralPublisher> getAllPublishers(){
        //for all publishers in Publiher set i have to iterate Through set
        return publishers;
    }
}

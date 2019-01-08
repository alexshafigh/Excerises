package com.Excercise6.Interfaces;

import java.util.ArrayList;
import java.util.List;

public interface Publisher {
    List<Subscriber> SUBSCRIBERS = new ArrayList<>();
    Publisher PUBLISHER = null;
    String name = null;
    void addSubscriber(Subscriber subscriber);
    List<Subscriber> getAllSubscribers();
}

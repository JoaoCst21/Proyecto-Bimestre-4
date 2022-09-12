package org.joao.com.controller;

public interface Subscriber<PublisherClass, FunctionClass> {
    public void startSubscription();

    public void handleEvent(PublisherClass component, FunctionClass event);
}

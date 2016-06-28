package edu.galileo.android.facebookrecipes.libs.base;

/**
 * Created by Alvaro on 16-06-2016.
 */
public interface EventBus {
    void register(Object subscriber);
    void unregister(Object subscriber);
    void post(Object event);
}

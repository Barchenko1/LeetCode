package com.test.concurrent;

public class SynchronizeClass {
    private Object object = null;

    public Object getObject() {
        synchronized (SynchronizeClass.class) {
            return object;
        }
    }

    public void setObject(Object object) {
        synchronized (SynchronizeClass.class) {
            this.object = object;
        }
    }
}

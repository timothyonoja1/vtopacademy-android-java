package com.vtopacademy;

/** Represents result's callback*/
public interface ResultCallback<T> {

    /** Represents oncomplete. */
    void onComplete(T result);

}
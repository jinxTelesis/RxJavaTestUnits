package com.example.rxjavatestunits;

import org.junit.Test;

import io.reactivex.Observable;

import static junit.framework.Assert.assertTrue;

public class RxJavaUnitTest {

    String result="";

    public void returnAValue(){
        result = "";
        Observable<String> observer = Observable.just("hello");
        observer.subscribe( s -> result=s);
        assertTrue(result.equals("Hello"));

    }
}

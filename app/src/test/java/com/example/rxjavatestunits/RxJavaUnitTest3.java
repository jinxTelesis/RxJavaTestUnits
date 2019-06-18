package com.example.rxjavatestunits;

import org.junit.Test;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.observers.TestObserver;

import static junit.framework.Assert.assertTrue;

public class RxJavaUnitTest3 {

    //https://proandroiddev.com/rxjava-2-unit-testing-tips-207887d3f15c
    //https://proandroiddev.com/rxjava-2-unit-testing-tips-207887d3f15c
    //https://proandroiddev.com/rxjava-2-unit-testing-tips-207887d3f15c
    //https://www.infoq.com/articles/Testing-RxJava2/
    //https://www.infoq.com/articles/Testing-RxJava2/
    //todo https://www.infoq.com/articles/Testing-RxJava2/


    String result="";

    // Simple subscription to a fix value
    @Test
    public void returnAValue(){
        result = "";
        Observable<String> observer = Observable.just("Hello"); // provides data
        observer.subscribe(s -> result=s); // Callable as subscriber
        assertTrue(result.equals("Hello"));
    }

    @Test
    public void expectNPE(){
        Observable<Todo> todoObservable = Observable.create(new ObservableOnSubscribe<Todo>() {
            @Override
            public void subscribe(ObservableEmitter<Todo> emitter) throws Exception {
                try {
                    List<Todo> todos = RxJavaUnitTest3.this.getTodos();
                    if (todos == null){
                        throw new NullPointerException("todos was null");
                    }
                    for (Todo todo : todos) {
                        emitter.onNext(todo);
                    }
                    emitter.onComplete();
                } catch (Exception e) {
                    emitter.onError(e);
                }
            }
        });
        TestObserver<Object> testObserver = new TestObserver<>();
        todoObservable.subscribeWith(testObserver);

        // expect a NPE by using the TestObserver
        testObserver.assertError(NullPointerException.class);
    }

    public List<Todo> getTodos() {
        return null;
    }

    public class Todo {
    }


}

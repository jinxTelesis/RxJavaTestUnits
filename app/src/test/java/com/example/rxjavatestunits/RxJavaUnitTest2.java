package com.example.rxjavatestunits;

import org.junit.Test;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.observers.TestObserver;
import io.reactivex.subscribers.TestSubscriber;


public class RxJavaUnitTest2 {

    @Test
    public void anObserableStraemOfEventsAndDataShouldEmitsEachItemINOrder(){

        Observable<String> pipelineOfData = Observable.just("Foo","Bar");

        //pipelineOfData.subscribe() testObserver

        //List<Object> dataEmitted = testObserver.value();
        //assertThat(dataEmitted).hasSize(2);
        //assertThat(dataEmitted).containsOnlyOnce("Foo");
        //assertThat(dataEmitted).containsOnlyOnce("Bar);

        TestSubscriber<Integer> ts = Flowable.range(1,5).test();

        TestObserver<Integer> to = Observable.range(1,5).test();

        TestObserver<Integer> tso = Single.just(1).test();

        TestObserver<Integer> tmo = Maybe.just(1).test();

        //TestObserver<Void> tco = Completable.complete().test(); this didn't match

    }
}

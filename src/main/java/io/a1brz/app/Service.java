package io.a1brz.app;

import io.reactivex.rxjava3.core.Flowable;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
class Service {
    Flowable<String> stream() {
        return Flowable.just("This", "is", "a", "stream");
    }
}
package com.assignment.nytimes.utils.rx.scheduler;

import io.reactivex.CompletableTransformer;
import io.reactivex.FlowableTransformer;
import io.reactivex.ObservableTransformer;
import io.reactivex.SingleTransformer;

/**
 * Created by Dhaval Parmar on 30/03/19.
 * Email : dhaval.parmar@wwindia.com
 * <p>
 * Transformer for any RxJava stream so it subscribes to a separate thread and is
 * observed on the android UI thread.
 */
public interface RxScheduler {

    CompletableTransformer forCompletable();

    <T> FlowableTransformer<T, T> forFlowable();

    <T> ObservableTransformer<T, T> forObservable();

    <T> SingleTransformer<T, T> forSingle();
}

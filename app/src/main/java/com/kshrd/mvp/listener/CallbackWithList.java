package com.kshrd.mvp.listener;
import java.util.List;

/**
 * Created by pirang on 7/14/17.
 */

public interface CallbackWithList<T> {

    void onSuccess(List<T> list);

    void onFailed();

    void onError();

    void onComplete();
}

package app.daeng.rssreader.interfaces;

/**
 * Created by isfaaghyth on 18/2/17.
 */

public interface NetworkListener {
    void onSuccess(String result);
    void onError(String err);
}

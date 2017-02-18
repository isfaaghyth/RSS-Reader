package app.daeng.rssreader.networks;

import app.daeng.rssreader.BuildConfig;

/**
 * Created by isfaaghyth on 18/2/17.
 */

public class URLs {
    private static String BASE_URL = BuildConfig.BASE_URL;
    private static String RSS_FEED = "/rssfeeds/5880659.cms";

    public static String getRssFeed() {
        return BASE_URL + RSS_FEED;
    }
}

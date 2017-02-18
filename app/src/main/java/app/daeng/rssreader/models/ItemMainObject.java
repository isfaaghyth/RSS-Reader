package app.daeng.rssreader.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by isfaaghyth on 18/2/17.
 */

public class ItemMainObject {

    private Channel channel;

    public Channel getChannel() {
        return channel;
    }

    public class Channel {
        @SerializedName("item")
        private List<Item> item;

        public List<Item> getItem() {
            return item;
        }

        public class Item {
            private String title;
            private String description;
            private String link;

            public String getTitle() {
                return title;
            }

            public String getDescription() {
                return description;
            }

            public String getLink() {
                return link;
            }
        }
    }
}

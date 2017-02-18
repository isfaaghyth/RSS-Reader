package app.daeng.rssreader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.google.gson.reflect.TypeToken;
import com.stanfy.gsonxml.GsonXml;
import com.stanfy.gsonxml.GsonXmlBuilder;
import com.stanfy.gsonxml.XmlParserCreator;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.util.List;

import app.daeng.rssreader.adapters.DataMainAdapter;
import app.daeng.rssreader.interfaces.NetworkListener;
import app.daeng.rssreader.models.ItemMainObject;
import app.daeng.rssreader.networks.RSSResponse;
import app.daeng.rssreader.networks.URLs;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements NetworkListener {

    @BindView(R.id.lst_item)
    RecyclerView lstItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        request();
    }

    private void request() {
        RSSResponse networkRequest = new RSSResponse(this, this);
        networkRequest.RSSResponse(Request.Method.GET, URLs.getRssFeed());
    }

    @Override
    public void onSuccess(String result) {
        XmlParserCreator parserCreator = new XmlParserCreator() {
            @Override
            public XmlPullParser createParser() {
                try {
                    return XmlPullParserFactory.newInstance().newPullParser();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        };

        GsonXml gsonXml = new GsonXmlBuilder()
                .setXmlParserCreator(parserCreator)
                .setSkipRoot(true)
                .setPrimitiveArrays(true)
                .setSameNameLists(true)
                .create();
        ItemMainObject itemObjects = gsonXml.fromXml(result, ItemMainObject.class);
        lstItem.setLayoutManager(new LinearLayoutManager(this));
        lstItem.setAdapter(new DataMainAdapter(itemObjects.getChannel().getItem()));
    }

    @Override
    public void onError(String err) {

    }
}

package app.daeng.rssreader.networks;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by isfaaghyth on 18/2/17.
 */

public class RSSRequest extends StringRequest {
    private Map param = new HashMap();

    public RSSRequest(Map param, int method, String url,
                                Response.Listener<String> listener,
                                Response.ErrorListener errorListener) {
        super(method, url, listener, errorListener);
        this.param = param;
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return param;
    }
}

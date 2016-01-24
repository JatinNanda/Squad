package swamphacks.squad;

/**
 * Created by Jay on 1/23/16.
 */

import android.net.Uri;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class OCRRestClientUsage {
    final String API_KEY = "1b66fe0abd43b7d0b4db24e4fb10749c";
    final String BASE_URL = "http://api.newocr.com/v1/";
    AsyncHttpClient client = new AsyncHttpClient();
    Uri builtUri = Uri.parse(BASE_URL).buildUpon()
            .appendPath("upload?")
            .appendQueryParameter("key", API_KEY)
            .build();
    static RequestParams params = new RequestParams();


    public static void getPublicTimeline() throws JSONException {
        try {
            params.put("Host:", "api.newocr.com");
            params.put("Content-Type:", "multipart/form-data; boundary=---------------------------41184676334");
            params.put("Content-Length:", PhotoIntentActivity.getImageView().getWidth() * PhotoIntentActivity.getImageView().getHeight());

        } catch (Exception e1) {
            e1.printStackTrace();
        }
        OCRRestClient.get("statuses/public_timeline.json", params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                System.out.println("TOASTY!!!!!");
                System.out.println("TOASTY!!!!!");
                System.out.println("TOASTY!!!!!");
                System.out.println("TOASTY!!!!!");
                System.out.println("TOASTY!!!!!");
                // If the response is JSONObject instead of expected JSONArray
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray timeline) {
                // Pull out the first event on the public timeline
                System.out.println("TOASTY!!!!!");
                System.out.println("TOASTY!!!!!");
                System.out.println("TOASTY!!!!!");
                System.out.println("TOASTY!!!!!");
            }
        });
    }

}

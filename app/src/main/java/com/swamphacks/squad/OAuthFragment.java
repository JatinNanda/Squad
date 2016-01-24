package com.swamphacks.squad;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class OAuthFragment extends DialogFragment {

    private WebView webViewOauth;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private  class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            //check if the login was successful and the access token returned
            //this test depend of your API
            if (url.contains("access_token=")) {
                //save your token
                saveAccessToken(url);
                return true;
            }
            return false;
        }
    }

    private void saveAccessToken(String url) {
        // extract the token if it exists
        String paths[] = url.split("access_token=");
        if (paths.length > 1) {
            MyApplication.token=paths[1];
            this.dismiss();
            return;
        }
    }

    @Override
    public void onViewCreated(View arg0, Bundle arg1) {
        super.onViewCreated(arg0, arg1);
        try {
            //load the url of the oAuth login page
            webViewOauth
                    .loadUrl("https://api.venmo.com/v1/oauth/authorize?client_id=3461&scope=make_payments%20access_profile&response_type=token");
            //set the web client
            webViewOauth.setWebViewClient(new MyWebViewClient());
            //activates JavaScript (just in case)
            WebSettings webSettings = webViewOauth.getSettings();
            webSettings.setJavaScriptEnabled(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Retrieve the webview
        View v = inflater.inflate(R.layout.oauth_screen, container, false);
        webViewOauth = (WebView) v.findViewById(R.id.web_oauth);
        getDialog().setTitle("Use your Venmo account");
        return v;
    }
}

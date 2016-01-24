package com.swamphacks.squad;

import android.app.Application;
import android.content.res.Configuration;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;

public class MyApplication extends Application {

    /* *************************************
     *              GENERAL                *
     ***************************************/

    /* A reference to the Firebase */
    public static Firebase mFirebaseRef;

    /* Data from the authenticated user */
    public static AuthData mAuthData;

    /* Listener for Firebase session changes */
    public static Firebase.AuthStateListener mAuthStateListener;

    public static String token;
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        // if changing configurations, stop tracking firebase session.
        mFirebaseRef.removeAuthStateListener(mAuthStateListener);
    }

}

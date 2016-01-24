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
        mFirebaseRef = new Firebase(getResources().getString(R.string.firebase_url));

        /* Check if the user is authenticated with Firebase already. If this is the case we can set the authenticated
         * user and hide hide any login buttons */
        mFirebaseRef.addAuthStateListener(mAuthStateListener);
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

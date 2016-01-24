package com.swamphacks.squad;


import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.List;

//One database overall
public class Database {
    private static List chosen;
    private static Firebase ref = new Firebase("https://squadpay.firebaseio.com/");

    public static void saveSquad(String code, Squad squad) {
        //write in all elements with code as key
        ref.child(code).child("squad").setValue(squad);

    }

    public static void saveUser(String code, User user) {
        ref.child(code).child(user.getUsername()).setValue(user);
    }

    public static List getElements(String code) {
        Firebase qRef = new Firebase("https://squadpay.firebaseio.com/"+code);
        qRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                chosen = (List) dataSnapshot.getValue();
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        try {
            Thread.sleep(1000);
        }
        catch(InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return chosen;
    }




 }

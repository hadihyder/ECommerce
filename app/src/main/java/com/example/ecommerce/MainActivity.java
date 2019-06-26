package com.example.ecommerce;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    public static final String TAG="TAG+++";
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference users = database.getReference("ecommerce-2345b");
    Toolbar toolbar;
    EditText username;
    EditText password;
    // Context ctx=getApplicationContext();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.login);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }
    public void login(View view){

        username= (EditText)findViewById(R.id.editTextUsername);
        password= (EditText)findViewById(R.id.editTextPassword);

        signin(username.getText().toString() , password.getText().toString());
        {
//           Toast toast = Toast.makeText(this,"Logged In Successfully",Toast.LENGTH_SHORT);
//           toast.show();
//           Intent intent= new Intent(this,Register.class);
//           startActivity(intent);
///
        }

    }

    public void registerpage(View view){
        Intent i = new Intent(MainActivity.this,Register.class);
        startActivity(i);
    }

    private void signin(final String username, final String password) {
        users.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.child(username).exists()){
                    if(!username.isEmpty()){
                        User login=dataSnapshot.child(username).getValue(User.class);
                        Log.d(TAG, String.valueOf(login));
                        if(login.getPassword().equals(password)){
                        Toast t=Toast.makeText(MainActivity.this,"SuccessLogin...,",Toast.LENGTH_LONG);
                        t.show();
                        }
                        else{
                            Toast.makeText(MainActivity.this,"Failed....",Toast.LENGTH_LONG).show();
                        }
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}

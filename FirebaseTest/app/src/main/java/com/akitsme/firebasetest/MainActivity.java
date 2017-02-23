package com.akitsme.firebasetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.database.DataSnapshot;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText editTextName;
    private EditText editTextAddress;
    private Button buttonSave;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Person> arrayList= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fetch_main);



            Firebase.setAndroidContext(this);

            buttonSave = (Button) findViewById(R.id.buttonSave);
            editTextName = (EditText) findViewById(R.id.editTextName);
            editTextAddress = (EditText) findViewById(R.id.editTextAddress);
            recyclerView=(RecyclerView)findViewById(R.id.recyclerview);
            mLayoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(mLayoutManager);
           // arrayList.clear();
             //recyclerView.setAdapter(new customAdapter(arrayList));
            buttonSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Creating firebase object
                    Firebase ref = new Firebase("https://samplefirebase-adcaa.firebaseio.com/Users");

                    //Getting values to store
                    String name = editTextName.getText().toString().trim();
                    final String address = editTextAddress.getText().toString().trim();
                    //Creating Person object
                    Person person = new Person();

                    //Adding values
                    person.setName(name);
                    person.setAddress(address);

                    //Storing values to firebase
                    //ref.child("Name2").setValue(person);
                    Firebase child = ref.child(name);
                    child.setValue(person);
                    editTextAddress.setText(" ");
                    editTextName.setText(" ");


                    //Value event listener for realtime data update
                    ref.addValueEventListener(new ValueEventListener() {

                        @Override
                        public void onDataChange(com.firebase.client.DataSnapshot snapshot) {
                            arrayList.clear();
                            //recyclerView.getAdapter().notifyDataSetChanged();
                            for (com.firebase.client.DataSnapshot postSnapshot : snapshot.getChildren()) {

                                //Getting the data from snapshot
                                Person person = postSnapshot.getValue(Person.class);
                                //Adding it to a string

                                arrayList.add(person);
                                //Displaying it on textview
                                //textViewPersons.setText(string);
                            }
                                recyclerView.setAdapter(new customAdapter(arrayList));
                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {
                            System.out.println("The read failed: " + firebaseError.getMessage());
                        }
                    });

                }
            });
        }

    }


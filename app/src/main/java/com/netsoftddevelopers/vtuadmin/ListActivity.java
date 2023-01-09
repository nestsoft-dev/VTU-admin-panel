package com.netsoftddevelopers.vtuadmin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.netsoftddevelopers.vtuadmin.Adapters.DataItem;

import com.netsoftddevelopers.vtuadmin.Adapters.MyListAdapter;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    FirebaseFirestore firestoremtn,firestoreglo,firestoreairtel,firestoreninemobile;
    ArrayList<DataItem> mtnlist,glolist,airtelList,nineMobileList;
    MyListAdapter mtnAdapter,gloAdapter,airtelAdapter,ninmobileAdapter;
    RecyclerView recyclerMtn,recyclerAirtel,recyclerGlo,recyclerNineMobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerNineMobile = findViewById(R.id.recyclerNineMobile);
        recyclerMtn = findViewById(R.id.recyclerMtn);
        recyclerAirtel = findViewById(R.id.recyclerAirtel);
        recyclerGlo = findViewById(R.id.recyclerGlo);







//
//        airtelList = new ArrayList<>();
//        airtelAdapter = new MyListAdapter(this,airtelList);
//        recyclerAirtel.setAdapter(airtelAdapter);
//        recyclerAirtel.setLayoutManager(new LinearLayoutManager(this));
//        recyclerAirtel.setHasFixedSize(true);



        firestoremtn = FirebaseFirestore.getInstance();
        mtnlist = new ArrayList<>();
        firestoremtn.collection("MtnData")
                .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        for (DocumentSnapshot ds : task.getResult()){
                            DataItem dataItem = new DataItem(
                                    ds.getString("id"),
                                    ds.getString("planDuration"),
                                    ds.getString("planAmount"),
                                    ds.getString("dataSize"));
                            mtnlist.add(dataItem);

                        }
                        mtnAdapter = new MyListAdapter(ListActivity.this,mtnlist);
                        recyclerMtn.setLayoutManager(new LinearLayoutManager(ListActivity.this));
                        recyclerMtn.setAdapter(mtnAdapter);
                    }
                });

        firestoreairtel = FirebaseFirestore.getInstance();
        airtelList = new ArrayList<>();
        firestoreairtel.collection("AirtelData")
                .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        for (DocumentSnapshot ds : task.getResult()){
                            DataItem dataItem = new DataItem(
                                    ds.getString("id"),
                                    ds.getString("planDuration"),
                                    ds.getString("planAmount"),
                                    ds.getString("dataSize"));
                            airtelList.add(dataItem);

                        }
                        airtelAdapter = new MyListAdapter(ListActivity.this,airtelList);
                        recyclerAirtel.setAdapter(airtelAdapter);
                        recyclerAirtel.setLayoutManager(new LinearLayoutManager(ListActivity.this));
                    }
                });

        firestoreglo = FirebaseFirestore.getInstance();

        glolist = new ArrayList<>();
        firestoreglo.collection("GloData")
                .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        for (DocumentSnapshot ds : task.getResult()){
                            DataItem dataItem = new DataItem(
                                    ds.getString("id"),
                                    ds.getString("planDuration"),
                                    ds.getString("planAmount"),
                                    ds.getString("dataSize"));
                            glolist.add(dataItem);

                        }
                        gloAdapter = new MyListAdapter(ListActivity.this,glolist);
                        recyclerGlo.setAdapter(gloAdapter);
                        recyclerGlo.setLayoutManager(new LinearLayoutManager(ListActivity.this));
                    }
                });

        firestoreninemobile = FirebaseFirestore.getInstance();
        nineMobileList = new ArrayList<>();
        firestoreninemobile.collection("NineMobile")
                .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        for (DocumentSnapshot ds : task.getResult()){
                            DataItem dataItem = new DataItem(
                                    ds.getString("id"),
                                    ds.getString("planDuration"),
                                    ds.getString("planAmount"),
                                    ds.getString("dataSize"));
                            nineMobileList.add(dataItem);

                        }
                        ninmobileAdapter = new MyListAdapter(ListActivity.this,nineMobileList);
                        recyclerNineMobile.setAdapter(ninmobileAdapter);
                        recyclerNineMobile.setLayoutManager(new LinearLayoutManager(ListActivity.this));
                        recyclerNineMobile.setHasFixedSize(true);
                    }
                });


    }
}
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
import com.netsoftddevelopers.vtuadmin.Adapters.ListModel;
import com.netsoftddevelopers.vtuadmin.Adapters.MyListAdapter;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    FirebaseFirestore firestoremtn,firestoreglo,firestoreairtel,firestoreninemobile;
    ArrayList<ListModel> mtnlist,glolist,airtelList,nineMobileList;
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


        firestoremtn = FirebaseFirestore.getInstance();
        firestoreairtel = FirebaseFirestore.getInstance();
        firestoreglo = FirebaseFirestore.getInstance();
        firestoreninemobile = FirebaseFirestore.getInstance();


        mtnlist = new ArrayList<>();
        mtnAdapter = new MyListAdapter(this,mtnlist);
        recyclerMtn.setAdapter(mtnAdapter);
        recyclerMtn.setLayoutManager(new LinearLayoutManager(this));
        recyclerMtn.setHasFixedSize(true);


        glolist = new ArrayList<>();
        gloAdapter = new MyListAdapter(this,glolist);
        recyclerGlo.setAdapter(gloAdapter);
        recyclerGlo.setLayoutManager(new LinearLayoutManager(this));
        recyclerGlo.setHasFixedSize(true);


        airtelList = new ArrayList<>();
        airtelAdapter = new MyListAdapter(this,airtelList);
        recyclerAirtel.setAdapter(airtelAdapter);
        recyclerAirtel.setLayoutManager(new LinearLayoutManager(this));
        recyclerAirtel.setHasFixedSize(true);

        nineMobileList = new ArrayList<>();
        ninmobileAdapter = new MyListAdapter(this,nineMobileList);
        recyclerNineMobile.setAdapter(ninmobileAdapter);
        recyclerNineMobile.setLayoutManager(new LinearLayoutManager(this));
        recyclerNineMobile.setHasFixedSize(true);


        firestoremtn.collection("MtnData")
                .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        for (DocumentSnapshot ds : task.getResult()){
                            ListModel dataItem = new ListModel(
                                    ds.getString("id"),
                                    ds.getString("planID"),
                                    ds.getString("planAmount"),
                                    ds.getString("dataSize"),
                                    ds.getString("planType"));
                            mtnlist.add(dataItem);

                        }
                    }
                });

        firestoreairtel.collection("AirtelData")
                .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        for (DocumentSnapshot ds : task.getResult()){
                            ListModel dataItem = new ListModel(
                                    ds.getString("id"),
                                    ds.getString("planID"),
                                    ds.getString("planAmount"),
                                    ds.getString("dataSize"),
                                    ds.getString("planType"));
                            airtelList.add(dataItem);

                        }
                    }
                });


        firestoreglo.collection("GloData")
                .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        for (DocumentSnapshot ds : task.getResult()){
                            ListModel dataItem = new ListModel(
                                    ds.getString("id"),
                                    ds.getString("planID"),
                                    ds.getString("planAmount"),
                                    ds.getString("dataSize"),
                                    ds.getString("planType"));
                            glolist.add(dataItem);

                        }
                    }
                });


        firestoreninemobile.collection("NineMobile")
                .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        for (DocumentSnapshot ds : task.getResult()){
                            ListModel dataItem = new ListModel(
                                    ds.getString("id"),
                                    ds.getString("planID"),
                                    ds.getString("planAmount"),
                                    ds.getString("dataSize"),
                                    ds.getString("planType"));
                            nineMobileList.add(dataItem);

                        }
                    }
                });


    }
}
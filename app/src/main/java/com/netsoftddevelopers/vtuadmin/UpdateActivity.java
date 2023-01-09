package com.netsoftddevelopers.vtuadmin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.netsoftddevelopers.vtuadmin.Core.ItemAdapter;
import com.netsoftddevelopers.vtuadmin.Core.ItemModel;

import java.util.ArrayList;

public class UpdateActivity extends AppCompatActivity {
    FirebaseFirestore mtnfirestore,airtelfirestore,glofirestore,ninefirestore;
    EditText planId,planAmount,dataSize,planType;
    Spinner selectType;
    private ArrayList<ItemModel> networkList;
    private ItemAdapter networkAdapter;
    int getIndex;
    Button updateBtn,deleteBtn;
    String plantype,planamount,datasize,id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        planAmount = findViewById(R.id.planAmount);
        dataSize = findViewById(R.id.dataSize);
        planType = findViewById(R.id.planType);
        selectType = findViewById(R.id.selectType);
        updateBtn = findViewById(R.id.UpdateBtn);
        deleteBtn = findViewById(R.id.deleteBtn);



         planamount = getIntent().getStringExtra("planAmount");
       datasize = getIntent().getStringExtra("datasize");
         plantype = getIntent().getStringExtra("planDuration");
         id = getIntent().getStringExtra("id");


        planAmount.setText(planamount);
        dataSize.setText(datasize);
        planType.setText(plantype);

        networkList = new ArrayList<>();
        networkList.add(new ItemModel("MTN",R.drawable.mtn));
        networkList.add(new ItemModel("Airtel",R.drawable.airtel));
        networkList.add(new ItemModel("Glo",R.drawable.glo));
        networkList.add(new ItemModel("9Mobile",R.drawable.ninemobile));

        networkAdapter = new ItemAdapter(this,networkList);
        selectType.setAdapter(networkAdapter);
        selectType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                getIndex = i + 1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String   nplanAMOUNT = planAmount.getText().toString();
                String   ndataSIZE = dataSize.getText().toString();
                String  nplanTYPE = planType.getText().toString();


                if (getIndex == 1){
                    createMTN(nplanAMOUNT,ndataSIZE,nplanTYPE);
                }else if (getIndex == 2){
                    createAirtel(nplanAMOUNT,ndataSIZE,nplanTYPE);
                }else if (getIndex == 3){
                    createGlo(nplanAMOUNT,ndataSIZE,nplanTYPE);
                }else if (getIndex == 4){
                    createNINE(nplanAMOUNT,ndataSIZE,nplanTYPE);
                }
            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                String   nplanAMOUNT = planAmount.getText().toString();
                String   ndataSIZE = dataSize.getText().toString();
                String  nplanTYPE = planType.getText().toString();


                if (getIndex == 1){
                    createMTNDe(nplanAMOUNT,ndataSIZE,nplanTYPE);
                }else if (getIndex == 2){
                    createAirtelDe(nplanAMOUNT,ndataSIZE,nplanTYPE);
                }else if (getIndex == 3){
                    createGloDe(nplanAMOUNT,ndataSIZE,nplanTYPE);
                }else if (getIndex == 4){
                    createNINEDe(nplanAMOUNT,ndataSIZE,nplanTYPE);
                }

            }
        });





    }

    private void createAirtel( String nplanAMOUNT, String ndataSIZE, String nplanTYPE) {
        airtelfirestore = FirebaseFirestore.getInstance();
        airtelfirestore.collection("AirtelData").document(id).update(
        "planAmount",nplanAMOUNT,
        "dataSize",ndataSIZE,
        "planType",nplanTYPE)
        .addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(UpdateActivity.this, "Updated", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(UpdateActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void createGlo(String nplanAMOUNT, String ndataSIZE, String nplanTYPE) {
        glofirestore = FirebaseFirestore.getInstance();
        glofirestore.collection("GloData").document(id).update(
                        "planAmount",nplanAMOUNT,
                        "dataSize",ndataSIZE,
                        "planType",nplanTYPE)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(UpdateActivity.this, "Updated", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(UpdateActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void createNINE(String nplanAMOUNT, String ndataSIZE, String nplanTYPE) {
        ninefirestore = FirebaseFirestore.getInstance();
        ninefirestore.collection("NineMobile").document(id).update(
                        "planAmount",nplanAMOUNT,
                        "dataSize",ndataSIZE,
                        "planType",nplanTYPE)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(UpdateActivity.this, "Updated", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(UpdateActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void createMTN( String nplanAMOUNT, String ndataSIZE, String nplanTYPE) {
        mtnfirestore = FirebaseFirestore.getInstance();
        mtnfirestore.collection("MtnData").document(id).update(
                        "planAmount",nplanAMOUNT,
                        "dataSize",ndataSIZE,
                        "planType",nplanTYPE)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(UpdateActivity.this, "Updated", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(UpdateActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }



    private void createAirtelDe( String nplanAMOUNT, String ndataSIZE, String nplanTYPE) {
        airtelfirestore = FirebaseFirestore.getInstance();
        airtelfirestore.collection("AirtelData").document(id).delete(
                       )
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(UpdateActivity.this, "Updated", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(UpdateActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void createGloDe(String nplanAMOUNT, String ndataSIZE, String nplanTYPE) {
        glofirestore = FirebaseFirestore.getInstance();
        glofirestore.collection("GloData").document(id).delete()
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(UpdateActivity.this, "Updated", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(UpdateActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void createNINEDe(String nplanAMOUNT, String ndataSIZE, String nplanTYPE) {
        ninefirestore = FirebaseFirestore.getInstance();
        ninefirestore.collection("NineMobile").document(id).delete()
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(UpdateActivity.this, "Updated", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(UpdateActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void createMTNDe( String nplanAMOUNT, String ndataSIZE, String nplanTYPE) {
        mtnfirestore = FirebaseFirestore.getInstance();
        mtnfirestore.collection("MtnData").document(id).delete()
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(UpdateActivity.this, "Updated", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(UpdateActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
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
    String plantype,planid,planamount,datasize,id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        planId = findViewById(R.id.planId);
        planAmount = findViewById(R.id.planAmount);
        dataSize = findViewById(R.id.dataSize);
        planType = findViewById(R.id.planType);
        selectType = findViewById(R.id.selectType);
        updateBtn = findViewById(R.id.UpdateBtn);
        deleteBtn = findViewById(R.id.deleteBtn);



         planid = getIntent().getStringExtra("planid");
         planamount = getIntent().getStringExtra("planAmount");
       datasize = getIntent().getStringExtra("datasize");
         plantype = getIntent().getStringExtra("plantype");

        planId.setText(planid);
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

              String  nplanID = planId.getText().toString();
                String   nplanAMOUNT = planAmount.getText().toString();
                String   ndataSIZE = dataSize.getText().toString();
                String  nplanTYPE = planType.getText().toString();


                if (getIndex == 1){
                    createMTN(nplanID,nplanAMOUNT,ndataSIZE,nplanTYPE);
                }else if (getIndex == 2){
                    createAirtel(nplanID,nplanAMOUNT,ndataSIZE,nplanTYPE);
                }else if (getIndex == 3){
                    createGlo(nplanID,nplanAMOUNT,ndataSIZE,nplanTYPE);
                }else if (getIndex == 4){
                    createNINE(nplanID,nplanAMOUNT,ndataSIZE,nplanTYPE);
                }
            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });





    }

    private void createAirtel(String nplanID, String nplanAMOUNT, String ndataSIZE, String nplanTYPE) {
        airtelfirestore = FirebaseFirestore.getInstance();
airtelfirestore.collection("AirtelData").document(id).update("planID",nplanID,
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

    private void createGlo(String nplanID, String nplanAMOUNT, String ndataSIZE, String nplanTYPE) {
        glofirestore = FirebaseFirestore.getInstance();
        airtelfirestore.collection("GloData").document(id).update("planID",nplanID,
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

    private void createNINE(String nplanID, String nplanAMOUNT, String ndataSIZE, String nplanTYPE) {
        ninefirestore = FirebaseFirestore.getInstance();
        airtelfirestore.collection("NineMobile").document(id).update("planID",nplanID,
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

    private void createMTN(String nplanID, String nplanAMOUNT, String ndataSIZE, String nplanTYPE) {
        mtnfirestore = FirebaseFirestore.getInstance();
        airtelfirestore.collection("MtnData").document(id).update("planID",nplanID,
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
}
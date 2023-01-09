package com.netsoftddevelopers.vtuadmin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.netsoftddevelopers.vtuadmin.Core.ItemAdapter;
import com.netsoftddevelopers.vtuadmin.Core.ItemModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    FirebaseFirestore firestore;
    private ArrayList<ItemModel> networkList;
    private ItemAdapter networkAdapter;
    Spinner selectType;
    int getIndex;
    EditText planDuration,planAmount,dataSize;
    Button upload,listBtn;
    String planAMOUNT,dataSIZE,planDurations;
    ProgressDialog progressDialog;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Updating file");
        progressDialog.setCancelable(false);

        selectType = findViewById(R.id.selectType);
        
        planAmount = findViewById(R.id.planAmount);
        dataSize = findViewById(R.id.planDatasize);
        planDuration = findViewById(R.id.planDuration);

        upload = findViewById(R.id.uploadBtn);
        listBtn = findViewById(R.id.listBtn);

        firestore = FirebaseFirestore.getInstance();
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

        listBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ListActivity.class));
            }
        });
        
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                planAMOUNT = planAmount.getText().toString();
                dataSIZE = dataSize.getText().toString();
                planDurations = planDuration.getText().toString();


                if ( planAMOUNT.isEmpty() || dataSIZE.isEmpty() || planDurations.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please fill all filed", Toast.LENGTH_SHORT).show();
                }else {
                    progressDialog.show();

                    if (getIndex == 1) {
                        createMTN(planDurations, planAMOUNT, dataSIZE);
                    } else if (getIndex == 2) {
                        createAirtel(planDurations, planAMOUNT, dataSIZE);
                    } else if (getIndex == 3) {
                        createGlo(planDurations, planAMOUNT, dataSIZE);
                    } else if (getIndex == 4) {
                        createNINE(planDurations, planAMOUNT, dataSIZE);
                    }
                }
            }
        });

    }


    private void createMTN(String planDurations, String planAMOUNT,String dataSIZE) {
        String plans = UUID.randomUUID().toString();
        Map<String,Object> transaction = new HashMap<>();
        transaction.put("id",plans);
        transaction.put("planDuration",planDurations);
        transaction.put("planAmount",planAMOUNT);
        transaction.put("dataSize",dataSIZE+"MB");

        firestore.collection("MtnData").document(plans).set(transaction)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(MainActivity.this, "MTN data saved", Toast.LENGTH_LONG).show();
                        progressDialog.dismiss();
                    }
                });

    }

    private void createAirtel(String planDurations, String planAMOUNT,String dataSIZE) {
        String plans = UUID.randomUUID().toString();
        Map<String,Object> transaction = new HashMap<>();
        transaction.put("id",plans);
        transaction.put("planDuration",planDurations);
        transaction.put("planAmount",planAMOUNT);
        transaction.put("dataSize",dataSIZE+"MB");

        firestore.collection("AirtelData").document(plans).set(transaction)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        progressDialog.dismiss();
                        Toast.makeText(MainActivity.this, "Airtel data saved", Toast.LENGTH_LONG).show();
                    }
                });
    }

    private void createGlo(String planDurations, String planAMOUNT,String dataSIZE) {
        String plans = UUID.randomUUID().toString();
        Map<String,Object> transaction = new HashMap<>();
        transaction.put("id",plans);
        transaction.put("planDuration",planDurations);
        transaction.put("planAmount",planAMOUNT);
        transaction.put("dataSize",dataSIZE+"MB");

        firestore.collection("GloData").document(plans).set(transaction)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        progressDialog.dismiss();
                        Toast.makeText(MainActivity.this, "Glo data saved", Toast.LENGTH_LONG).show();
                    }
                });
    }

    private void createNINE(String planDurations, String planAMOUNT,String dataSIZE) {
        String plans = UUID.randomUUID().toString();
        Map<String,Object> transaction = new HashMap<>();
        transaction.put("id",plans);
        transaction.put("planDuration",planDurations);
        transaction.put("planAmount",planAMOUNT);
        transaction.put("dataSize",dataSIZE+"MB");


        firestore.collection("NineMobile").document(plans).set(transaction)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        progressDialog.dismiss();
                        Toast.makeText(MainActivity.this, "NineMobile data saved", Toast.LENGTH_LONG).show();
                    }
                });
    }
}
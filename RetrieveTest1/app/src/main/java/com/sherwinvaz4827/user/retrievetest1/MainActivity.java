package com.sherwinvaz4827.user.retrievetest1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private StorageReference mStorageReff;
    private DatabaseReference mDatabaseReff;
    private RecyclerView mRecyclerView;
    private ArrayList<Images> imagesList;
    private Context mContext=MainActivity.this;
    private ImageAdapter imageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDatabaseReff= FirebaseDatabase.getInstance().getReference();
        mStorageReff= FirebaseStorage.getInstance().getReference();
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);


        mRecyclerView=findViewById(R.id.recyclerview1);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);
        init1();


        imagesList=new ArrayList<>();


    }

    private void init1() {

        clearAll();
        Query query=mDatabaseReff.child("HeroComboList");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot:dataSnapshot.getChildren())
                {
                    Images images=new Images();
                    images.setUrl1(snapshot.child("url1").getValue().toString());
                    images.setUrl2(snapshot.child("url2").getValue().toString());
                    images.setUrl3(snapshot.child("url3").getValue().toString());
                    images.setUrl4(snapshot.child("url4").getValue().toString());
                    images.setUrl5(snapshot.child("url5").getValue().toString());
                    images.setUrl6(snapshot.child("url6").getValue().toString());
                    images.setUrl7(snapshot.child("url7").getValue().toString());
                    images.setUrl8(snapshot.child("url8").getValue().toString());
                    images.setUrl9(snapshot.child("url9").getValue().toString());
                    images.setUrl10(snapshot.child("urla10").getValue().toString());

                    imagesList.add(images);

                    imageAdapter=new ImageAdapter(mContext,imagesList);

                    mRecyclerView.setAdapter(imageAdapter);


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void clearAll() {
        if(imagesList!=null)
        {
            imagesList.clear();

            if(imageAdapter!=null)
            {
                imageAdapter.notifyDataSetChanged();
            }
        }
        imagesList=new ArrayList<>();
    }


}

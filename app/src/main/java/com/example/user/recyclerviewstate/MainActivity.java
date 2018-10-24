package com.example.user.recyclerviewstate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerview;
    private AdapterClass adapterClass;
    private List<DataModel> list ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();

        for(int i = 0; i < 100; i++)
        {
            list.add(i,new DataModel(String.valueOf(i),false));
        }

        recyclerview = findViewById(R.id.recyclerview);
        recyclerview.setHasFixedSize(true);
        recyclerview.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        adapterClass = new AdapterClass(getApplicationContext(),list);
        recyclerview.setAdapter(adapterClass);


    }
}

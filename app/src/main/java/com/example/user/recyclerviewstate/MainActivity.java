package com.example.user.recyclerviewstate;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.support.v7.widget.RecyclerView.SCROLL_STATE_IDLE;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
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
            list.add(i,new DataModel(String.valueOf(i),0,false));
        }

        recyclerview = findViewById(R.id.recyclerview);
        recyclerview.setHasFixedSize(true);
        recyclerview.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        adapterClass = new AdapterClass(getApplicationContext(),list);
        recyclerview.setAdapter(adapterClass);

        registerForContextMenu(recyclerview);


        recyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState)
            {
                super.onScrollStateChanged(recyclerView, newState);

                if(newState == SCROLL_STATE_IDLE )
                {
                    if(recyclerView != null)
                    {
                        LinearLayoutManager layoutManager = ((LinearLayoutManager) recyclerView.getLayoutManager());

                        final int firstPosition = layoutManager.findFirstVisibleItemPosition();
                        final int lastPosition = layoutManager.findLastVisibleItemPosition();

                        Rect rvRect = new Rect();
                        recyclerView.getGlobalVisibleRect(rvRect);


                        for (int i = firstPosition; i <= lastPosition; i++) {
                            Rect rowRect = new Rect();
                            layoutManager.findViewByPosition(i).getGlobalVisibleRect(rowRect);

                            int percentFirst;
                            if (rowRect.bottom >= rvRect.bottom){
                                int visibleHeightFirst =rvRect.bottom - rowRect.top;
                                percentFirst = (visibleHeightFirst * 100) / layoutManager.findViewByPosition(i).getHeight();
                            }else {
                                int visibleHeightFirst = rowRect.bottom - rvRect.top;
                                percentFirst = (visibleHeightFirst * 100) / layoutManager.findViewByPosition(i).getHeight();
                            }

                            if (percentFirst>100)
                                percentFirst = 100;

                            list.get(i).setPercentage(percentFirst);
                            adapterClass.notifyItemChanged(i);
                        }

                    }
                    else
                    {
                        Log.d(TAG,"recyclerview is null");
                    }
                }

            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        menu.setHeaderTitle("Select The Action");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item){
        if(item.getItemId()==R.id.call){
            Toast.makeText(getApplicationContext(),"calling code",Toast.LENGTH_LONG).show();
        }
        else if(item.getItemId()==R.id.sms){
            Toast.makeText(getApplicationContext(),"sending sms code",Toast.LENGTH_LONG).show();
        }else{
            return false;
        }
        return true;
    }
}

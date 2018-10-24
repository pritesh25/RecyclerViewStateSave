package com.example.user.recyclerviewstate;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

public class AdapterClass extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<DataModel> list;

    private Context context;


    public AdapterClass(Context context, List<DataModel> list) {

        this.context = context;
        this.list    = list;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        if(viewHolder instanceof MyViewHolder)
        {
            MyViewHolder holder = (MyViewHolder)viewHolder;
            holder.name.setText(list.get(i).getName());

            if (list.get(i).getChecked()) {
                holder.checkBox.setChecked(true);
            }
            else {
                holder.checkBox.setChecked(false);
            }
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private CheckBox checkBox;

        public MyViewHolder(View view)
        {
            super(view);

            name     = view.findViewById(R.id.name);
            checkBox = view.findViewById(R.id.checkbox);

            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clickEvent();
                }

                private void clickEvent() {

                    if (list.get(getAdapterPosition()).getChecked()) {
                        checkBox.setChecked(false);
                        list.get(getAdapterPosition()).setChecked(false);
                    }
                    else {
                        checkBox.setChecked(true);
                        list.get(getAdapterPosition()).setChecked(true);
                    }
                }
            });

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clickEvent();
                }

                private void clickEvent() {

                    if (list.get(getAdapterPosition()).getChecked()) {
                        checkBox.setChecked(false);
                        list.get(getAdapterPosition()).setChecked(false);
                    }
                    else {
                        checkBox.setChecked(true);
                        list.get(getAdapterPosition()).setChecked(true);
                    }
                }
            });

        }
    }
}

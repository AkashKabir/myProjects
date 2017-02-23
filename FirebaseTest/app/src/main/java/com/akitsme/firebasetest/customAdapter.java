package com.akitsme.firebasetest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by AKASH on 23-02-2017.
 */

public class customAdapter extends RecyclerView.Adapter<customAdapter.myHolder> {

    private ArrayList<Person> arrayList;
    customAdapter(ArrayList<Person> arrayList){
        this.arrayList=arrayList;
    }
    @Override
    public customAdapter.myHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.user,parent,false);
        return new myHolder(view);
    }

    @Override
    public void onBindViewHolder(customAdapter.myHolder holder, int position) {
            holder.name.setText(arrayList.get(position).getName());
            holder.address.setText(arrayList.get(position).getAddress());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class myHolder extends RecyclerView.ViewHolder{
        private TextView name;
        private TextView address;
        public myHolder(View itemView) {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.name);
            address=(TextView)itemView.findViewById(R.id.address);
        }
    }

}

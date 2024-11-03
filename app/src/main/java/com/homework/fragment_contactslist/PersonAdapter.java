package com.homework.fragment_contactslist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {
    private ArrayList<com.homework.fragment_contactslist.Person>People;
    ItemSelected activity;

    public interface ItemSelected{
        void onItemClicked(int Index);
    }

    public PersonAdapter(Context context, ArrayList<Person> list){
        this.People=list;
        activity=(ItemSelected)context;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvName;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName =itemView.findViewById(R.id.tvName);
            imageView=itemView.findViewById(R.id.imageCon);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    activity.onItemClicked(People.indexOf(view.getTag()));
                }
            });
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemView.setTag(People.get(position));
        holder.tvName.setText(People.get(position).getName());
        holder.imageView.setImageResource(People.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return People.size();
    }
}


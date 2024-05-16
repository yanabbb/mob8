package com.example.mob8.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mob8.R;
import com.example.mob8.data.model.PeopleEntity;

import java.util.List;

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.PeopleEntityViewHolder> {
    private List<PeopleEntity> people;
    public void setPeopleEntities(List<PeopleEntity> peopleEntities) {
        people = peopleEntities;
        notifyDataSetChanged();
    }
    @Override
    public PeopleEntityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new PeopleEntityViewHolder(view);
    }
    @Override
    public void onBindViewHolder(PeopleEntityViewHolder holder, int position) {
        if (people != null) {
            PeopleEntity currentEntity = people.get(position);
            holder.textViewName.setText(currentEntity.getName());
        } else {
            holder.textViewName.setText("No PeopleEntity");
        }
    }
    static class PeopleEntityViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewName;
        public PeopleEntityViewHolder(View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textView);
        }
    }
    @Override
    public int getItemCount() {
        return people != null ? people.size() : 0;
    }

}
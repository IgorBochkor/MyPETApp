package com.demo.mypetapp.human;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.demo.mypetapp.R;

import java.util.List;

public class HumanAdaptor extends RecyclerView.Adapter<HumanAdaptor.HumanAdaptorViewHolder> {


    public List<Human> getHumans() {
        return humans;
    }

    public void setHumans(List<Human> humans) {
        this.humans = humans;
    }


    private List<Human> humans;

    @NonNull
    @Override
    public HumanAdaptorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new HumanAdaptorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HumanAdaptorViewHolder holder, int position) {
        Human human = humans.get(position);
        holder.textViewName.setText(human.getName());
        holder.textViewLastname.setText(human.getLastName());

    }

    @Override
    public int getItemCount() {
        return humans.size();
    }


    class HumanAdaptorViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewName;
        private TextView textViewLastname;
        public HumanAdaptorViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewLastname = itemView.findViewById(R.id.textViewLastname);
        }
    }
}

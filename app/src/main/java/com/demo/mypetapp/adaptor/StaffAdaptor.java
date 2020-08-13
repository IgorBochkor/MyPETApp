package com.demo.mypetapp.adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.demo.mypetapp.POJO.Staff;
import com.demo.mypetapp.R;

import java.util.List;

public class StaffAdaptor extends RecyclerView.Adapter<StaffAdaptor.StaffAdaptorViewHolder> {

    

    private List<Staff> staffList;

    public List<Staff> getStaffList() {
        return staffList;
    }

    public void setStaffList(List<Staff> staffList) {
        this.staffList = staffList;
        notifyDataSetChanged(); //щоб після установки співробітників у нас обновився список
    }

    @NonNull
    @Override
    public StaffAdaptorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new StaffAdaptorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StaffAdaptorViewHolder holder, int position) {
        Staff staff = staffList.get(position);
        holder.textViewName.setText(staff.getName());
        holder.textViewLastname.setText(staff.getAge());

    }

    @Override
    public int getItemCount() {
        return staffList.size();
    }


    class StaffAdaptorViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewName;
        private TextView textViewLastname;

        public StaffAdaptorViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewLastname = itemView.findViewById(R.id.textViewLastname);
        }
    }
}

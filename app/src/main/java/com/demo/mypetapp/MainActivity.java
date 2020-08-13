package com.demo.mypetapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.demo.mypetapp.POJO.Staff;
import com.demo.mypetapp.POJO.StaffList;
import com.demo.mypetapp.adaptor.StaffAdaptor;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView textViewName;
    private TextView textViewLastname;
    private StaffAdaptor adaptor;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewName = findViewById(R.id.textViewName);
        textViewLastname = findViewById(R.id.textViewLastname);
        recyclerView = findViewById(R.id.recycleView);

        adaptor = new StaffAdaptor();
        List<Staff> staffList = new ArrayList<>();
        adaptor.setStaffList(staffList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adaptor);

        Api api = Api.getApi();
        ApiService apiService = api.getApiService();
        apiService.getStaff().enqueue(new Callback<StaffList>() {
            @Override
            public void onResponse(Call<StaffList> call, Response<StaffList> response) {
                adaptor.setStaffList(response.body().getStaff());
            }

            @Override
            public void onFailure(Call<StaffList> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Network Error! " + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("error_code   ", t.getMessage());

            }
        });
    }
}
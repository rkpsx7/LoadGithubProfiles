package com.example.loadgithubprofiles;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainFragment extends Fragment {
    private ArrayList<ResponseDTOItem> dataList = new ArrayList<>();
    private Adapter adapter;
    private RecyclerView recyclerView;
    private Button btn_fetch;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerView);
        btn_fetch = view.findViewById(R.id.btn_fetch);
        btn_fetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callApi();
            }
        });


    }

    private void setAdapter() {
        adapter = new Adapter(dataList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.requireActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void callApi() {
        ApiService apiService = Network.getInstance().create(ApiService.class);
        apiService.getResponse().enqueue(new Callback<List<ResponseDTOItem>>() {
            @Override
            public void onResponse(Call<List<ResponseDTOItem>> call, Response<List<ResponseDTOItem>> response) {
                dataList = (ArrayList<ResponseDTOItem>) response.body();
                setAdapter();
            }

            @Override
            public void onFailure(Call<List<ResponseDTOItem>> call, Throwable t) {

            }
        });
    }
}
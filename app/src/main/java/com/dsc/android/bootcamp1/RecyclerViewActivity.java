package com.dsc.android.bootcamp1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private List<RecyclerViewData> userList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        recyclerView = findViewById(R.id.recycler_view);
        //createMockList();
        apicall();
        setRecyclerView();
    }

    private void apicall(){
        ApiServices apiServices = AppClient.getInstance().createService(ApiServices.class);
        Call<UserWrapper> call = apiServices.getUserList();
        call.enqueue(new Callback<UserWrapper>() {
            @Override
            public void onResponse(Call<UserWrapper> call, Response<UserWrapper> response) {
                if (response.isSuccessful()){
                    if (response.body() != null){
                        userList.addAll(response.body().getRecyclerViewData());
                    }
                }
            }

            @Override
            public void onFailure(Call<UserWrapper> call, Throwable t) {

            }
        });

    }


   // private void createMockList(){
     //   RecyclerViewData data;
     //   data = new RecyclerViewData("https://bit.ly/2NT7svr","Tejaswinee","1234567890");
    //    mockDataList.add(data);
    //    data = new RecyclerViewData("https://bit.ly/2NT7svr","Devanshu","0987654321");
     //   mockDataList.add(data);
       // data = new RecyclerViewData("https://bit.ly/2NT7svr","Naina","9878725678");
       // mockDataList.add(data);
      //  data = new RecyclerViewData("https://bit.ly/2NT7svr","Anuja","6098923678");
     //   mockDataList.add(data);
     //   data = new RecyclerViewData("https://bit.ly/2NT7svr","Ankur","7234012345");
       // mockDataList.add(data);
   // }
//
    private void setRecyclerView(){
        recyclerViewAdapter = new RecyclerViewAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerViewAdapter.setRecyclerViewDataList(userList);
        recyclerViewAdapter.notifyDataSetChanged();
    }
}

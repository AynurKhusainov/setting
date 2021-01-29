package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private  static final String TAG= "MainActivity";
    ApiIntrface apiIntrface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiIntrface=ApiClient.getClient().create((ApiIntrface.class));

    }

    public void aaa(View view) {
        Call<List<Todo>> Call= apiIntrface.getTodos();
        Call.enqueue(new Callback<List<Todo>>() {
            @Override
            public void onResponse(retrofit2.Call<List<Todo>> call, Response<List<Todo>> response) {
                Log.e(TAG, "onResponse"+ response.body());
            }

            @Override
            public void onFailure(retrofit2.Call<List<Todo>> call, Throwable t) {
                Log.e(TAG,"onFailure"+t.getLocalizedMessage());
            }
        });
    }

    public void bbb(View view) {
        Call<Todo> todoCall =apiIntrface.getTodo(3);
        todoCall.enqueue(new Callback<Todo>() {
            @Override
            public void onResponse(Call<Todo> call, Response<Todo> response) {
                    Log.e(TAG,"onResponse: "+response.body());
            }

            @Override
            public void onFailure(Call<Todo> call, Throwable t) {
                    Log.e(TAG,"onFailure"+t.getLocalizedMessage());
            }
        });
    }

    public void ccc(View view) {
        Call<List<Todo>> ListCall = apiIntrface.getTodosUsingQuery(2,false);
        ListCall.enqueue(new Callback<List<Todo>>() {
            @Override
            public void onResponse(Call<List<Todo>> call, Response<List<Todo>> response) {
                Log.e(TAG,"onResponse: "+ response.body());
            }

            @Override
            public void onFailure(Call<List<Todo>> call, Throwable t) {

            }
        });
    }

    public void ddd(View view) {

        Todo todo=new Todo(3,"Get me milk", false);
        Call

    }
}
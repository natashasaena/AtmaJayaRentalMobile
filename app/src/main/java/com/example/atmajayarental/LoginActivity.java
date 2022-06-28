package com.example.atmajayarental;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.example.atmajayarental.api.ApiClient;
import com.example.atmajayarental.api.ApiInterface;
import com.example.atmajayarental.databinding.ActivityLoginBinding;
import com.example.atmajayarental.databinding.ActivityMainBinding;
import com.example.atmajayarental.response.TokenResponse;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private TextInputLayout inputUsername, inputPassword;
    private MaterialButton btnClear, btnLogin;
    private ApiInterface apiService;
    private ActivityLoginBinding binding;
    private AutoCompleteTextView edRole;
    private static final String[] ROLE_LIST = new String[]{"Manager", "Customer", "Driver"};
    private String chooseRole;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        apiService = ApiClient.getClient().create(ApiInterface.class);
        inputUsername = findViewById(R.id.inputLayoutUsername);
        inputPassword = findViewById(R.id.inputLayoutPassword);
        edRole = findViewById(R.id.ed_role);

        ArrayAdapter<String> adapterRole = new ArrayAdapter<>(this, R.layout.item_list, ROLE_LIST);
        edRole.setAdapter(adapterRole);

        btnClear = findViewById(R.id.btnClear);
        btnLogin = findViewById(R.id.btnLogin);

        binding.btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputUsername.getEditText().setText("");
                inputPassword.getEditText().setText("");
            }
        });

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseRole = edRole.getText().toString();
                if(chooseRole.equals("Customer")){
                    CallLoginService();
                }else if (chooseRole.equals("Manager")) {
                    CallLoginService3();
                } else if(chooseRole.equals("Driver")){
                    CallLoginService2();

                }else{
                    Toast.makeText(LoginActivity.this,"Inputan Anda Kosong",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void CallLoginService(){
        try{
            final String username = inputUsername.getEditText().getText().toString();
            final String password = inputPassword.getEditText().getText().toString();

            ApiInterface service = ApiClient.getClient().create(ApiInterface.class);
            Call<ResponseBody> srvLogin = service.login(username,password);
            srvLogin.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    if(response.isSuccessful()){
                        try{
                            String ResponseJson = response.body().string();
                            Gson objGson = new Gson();
                            TokenResponse objResp = objGson.fromJson(ResponseJson,TokenResponse.class);
                            //objResp.getAccess_token()
                            Toast.makeText(LoginActivity.this, "Berhasil Login", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity.this,HomeActivity.class));
                        }catch (Exception e){
                            e.printStackTrace();
                            Toast.makeText(LoginActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(LoginActivity.this, "Username atau Password Salah", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    Toast.makeText(LoginActivity.this, "System error occured:"+t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }catch(Exception e){
            e.printStackTrace();
            Toast.makeText(LoginActivity.this, "Network Error", Toast.LENGTH_SHORT).show();
        }

    }

    public void CallLoginService2(){
        try{
            final String username = inputUsername.getEditText().getText().toString();
            final String password = inputPassword.getEditText().getText().toString();

            ApiInterface service = ApiClient.getClient().create(ApiInterface.class);
            Call<ResponseBody> srvLogin = service.loginDriver(username,password);
            srvLogin.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    if(response.isSuccessful()){
                        try{
                            String ResponseJson = response.body().string();
                            Gson objGson = new Gson();
                            TokenResponse objResp = objGson.fromJson(ResponseJson,TokenResponse.class);
                            //objResp.getAccess_token()
                            Toast.makeText(LoginActivity.this, "Berhasil Login", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity.this,Rating.class));
                        }catch (Exception e){
                            e.printStackTrace();
                            Toast.makeText(LoginActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(LoginActivity.this, "Username atau Password Salah", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    Toast.makeText(LoginActivity.this, "System error occured:"+t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }catch(Exception e){
            e.printStackTrace();
            Toast.makeText(LoginActivity.this, "Network Error", Toast.LENGTH_SHORT).show();
        }

    }

    public void CallLoginService3(){
        try{
            final String username = inputUsername.getEditText().getText().toString();
            final String password = inputPassword.getEditText().getText().toString();

            ApiInterface service = ApiClient.getClient().create(ApiInterface.class);
            Call<ResponseBody> srvLogin = service.loginManager(username,password);
            srvLogin.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    if(response.isSuccessful()){
                        try{
                            String ResponseJson = response.body().string();
                            Gson objGson = new Gson();
                            TokenResponse objResp = objGson.fromJson(ResponseJson,TokenResponse.class);
                            //objResp.getAccess_token()
                            Toast.makeText(LoginActivity.this, "Berhasil Login", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity.this,MainActivity.class));
                        }catch (Exception e){
                            e.printStackTrace();
                            Toast.makeText(LoginActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(LoginActivity.this, "Username atau Password Salah", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    Toast.makeText(LoginActivity.this, "System error occured:"+t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }catch(Exception e){
            e.printStackTrace();
            Toast.makeText(LoginActivity.this, "Network Error", Toast.LENGTH_SHORT).show();
        }

    }
}
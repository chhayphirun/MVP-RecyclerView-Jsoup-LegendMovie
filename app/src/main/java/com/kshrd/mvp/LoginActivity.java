package com.kshrd.mvp;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.kshrd.mvp.mvp.LoginContract;
import com.kshrd.mvp.mvp.LoginPresenter;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    private LoginContract.Presenter presenter;
    private ProgressDialog progressDialog;
    private EditText etUserName;
    private EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        presenter = new LoginPresenter(this);
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Loading....");

        findViewById(R.id.btnLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.login(
                        etUserName.getText().toString(),
                        etPassword.getText().toString()
                );
            }
        });
    }

    private void initView() {
        etUserName = (EditText) findViewById(R.id.etUserName);
        etPassword = (EditText) findViewById(R.id.etPassword);
    }


    @Override
    public void showLoading() {
        progressDialog.show();
    }

    @Override
    public void hideLoading() {
        progressDialog.dismiss();
    }

    @Override
    public void onLoginSuccess() {
        Toast.makeText(this, "Login Successfully", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginFailed() {
        Toast.makeText(this, "Invalid Information", Toast.LENGTH_SHORT).show();
    }
}

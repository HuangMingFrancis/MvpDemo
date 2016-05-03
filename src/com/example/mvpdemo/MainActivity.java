package com.example.mvpdemo;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvpdemo.bean.User;
import com.example.mvpdemo.presenter.UserInfoPresenter;
import com.example.mvpdemo.view.IShowUserView;


public class MainActivity extends Activity implements IShowUserView{

	private Button btn,btn1,btn_login;
	private EditText et_user_name,et_user_psw;
    private TextView name_tv, age_tv, sex_tv;  
    private ProgressDialog pd = null;  
    private UserInfoPresenter userInfoPresenter;  
  
    @Override  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_main);  
        userInfoPresenter = new UserInfoPresenter(this);  
        btn = (Button) findViewById(R.id.btn);  
        btn1 = (Button) findViewById(R.id.btn1);  
        btn_login=(Button)findViewById(R.id.btn_login);
        et_user_name=(EditText)findViewById(R.id.et_user_name);
        et_user_psw=(EditText)findViewById(R.id.et_user_psw);
        name_tv = (TextView) findViewById(R.id.name_tv);  
        age_tv = (TextView) findViewById(R.id.age_tv);  
        sex_tv = (TextView) findViewById(R.id.sex_tv);  
        pd = new ProgressDialog(this);  
        pd.setMessage("正在加载……");  
  
        btn.setOnClickListener(new View.OnClickListener() {  
  
            @Override  
            public void onClick(View v) {  
                userInfoPresenter.getUserInfoToShow(1);  
            }  
        });  
        btn1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				userInfoPresenter.editUserInfoToShow(2);
			}
		});
        btn_login.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				User user=new User();
				user.setName(et_user_name.getText().toString());
				user.setId(et_user_psw.getText().toString());
				userInfoPresenter.Login(user);
				
			}
		});
    }  
  
    @Override  
    public void showLoading() {  
        pd.show();  
    }  
  
    @Override  
    public void hideLoading() {  
        pd.cancel();  
    }  
  
    @Override  
    public void toMainActivity(User user) {  
        name_tv.setText(user.getName());  
        age_tv.setText(user.getAge());  
        sex_tv.setText(user.getSex());  
    }  
  
    @Override  
    public void showFailedError() {  
        Toast.makeText(this, "获取信息有误", Toast.LENGTH_SHORT).show();  
    }

	@Override
	public void jumpActivity() {
		startActivity(new Intent(this,LoginSuccess.class));
	}  
}

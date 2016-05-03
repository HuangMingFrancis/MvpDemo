package com.example.mvpdemo.presenter;

import java.nio.ReadOnlyBufferException;

import android.R.integer;
import android.os.Handler;

import com.example.mvpdemo.bean.User;
import com.example.mvpdemo.model.GetUserInfo;
import com.example.mvpdemo.model.IGetUser;
import com.example.mvpdemo.model.LoginResult;
import com.example.mvpdemo.model.OnUserInfoListener;
import com.example.mvpdemo.view.IShowUserView;

/**
 * Presenter是Model和View之间交互的桥梁，里面有一些业务逻辑的操作
 * 
 * @author Francis
 * 
 */
public class UserInfoPresenter {
	private IGetUser iGetUser;
	private IShowUserView iShowUserView;
	private Handler mHandler = new Handler();

	public UserInfoPresenter(IShowUserView iShowUserView) {
		this.iShowUserView = iShowUserView;
		this.iGetUser = new GetUserInfo();
	}

	public void getUserInfoToShow(int id) {
		iShowUserView.showLoading();
		iGetUser.getUserInfo(id, new OnUserInfoListener() {

			@Override
			public void getUserInfoSuccess(final User user) {
				// 需要在UI线程执行
				mHandler.post(new Runnable() {
					@Override
					public void run() {
						iShowUserView.toMainActivity(user);
						iShowUserView.hideLoading();
					}
				});
			}

			@Override
			public void getUserInfoFailed() {
				mHandler.post(new Runnable() {
					@Override
					public void run() {
						iShowUserView.showFailedError();
						iShowUserView.hideLoading();
					}
				});
			}
		});
	}

	public void editUserInfoToShow(int id) {
		iShowUserView.showLoading();
		iGetUser.editUserInfo(id, new OnUserInfoListener() {

			@Override
			public void getUserInfoSuccess(final User user) {
				mHandler.post(new Runnable() {

					@Override
					public void run() {
						iShowUserView.toMainActivity(user);
						iShowUserView.hideLoading();
					}
				});
			}

			@Override
			public void getUserInfoFailed() {
				mHandler.post(new Runnable() {
					@Override
					public void run() {
						iShowUserView.showFailedError();
						iShowUserView.hideLoading();
					}
				});
			}
		});
	}
	public void Login(User user){
		iShowUserView.showLoading();
		iGetUser.login(user, new LoginResult() {
			
			@Override
			public void loginSuccess() {
				mHandler.post(new Runnable(){
					@Override
					public void run() {
						iShowUserView.jumpActivity();
						iShowUserView.hideLoading();
					}
				});
				
			}
			
			@Override
			public void loginFail() {
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						iShowUserView.showFailedError();
						iShowUserView.hideLoading();
					}
				});
				
			}
		});
	}
}

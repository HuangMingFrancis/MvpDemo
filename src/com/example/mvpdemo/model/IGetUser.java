package com.example.mvpdemo.model;

import com.example.mvpdemo.bean.User;

import android.R.integer;

/**
 * Model�����ӿ�
 * @author Francis
 *
 */
public interface IGetUser {
	public void getUserInfo(int id, OnUserInfoListener listener);
	public void editUserInfo(int id,OnUserInfoListener listener);
	public void login(User user,LoginResult listener);
}

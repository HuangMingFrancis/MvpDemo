package com.example.mvpdemo.model;

import com.example.mvpdemo.bean.User;
/**
 * Model²ã³éÏó½Ó¿Ú
 * @author Francis
 *
 */
public interface OnUserInfoListener {
	void getUserInfoSuccess(User user);  
    void getUserInfoFailed();  
}

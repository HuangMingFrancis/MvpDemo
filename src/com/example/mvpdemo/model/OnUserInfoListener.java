package com.example.mvpdemo.model;

import com.example.mvpdemo.bean.User;
/**
 * Model�����ӿ�
 * @author Francis
 *
 */
public interface OnUserInfoListener {
	void getUserInfoSuccess(User user);  
    void getUserInfoFailed();  
}

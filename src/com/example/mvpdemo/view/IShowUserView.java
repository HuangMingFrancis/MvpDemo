package com.example.mvpdemo.view;

import com.example.mvpdemo.bean.User;
/**
 * Presenter��View������ͨ���ӿڣ�����������Ҫ����һ��IShowUserView�Ľӿڣ�����ӿڷ�װ�ķ��������϶�����ͼչʾ�й�
 * @author Francis
 *
 */
public interface IShowUserView {
	void showLoading();  
	  
    void hideLoading();  
  
    void toMainActivity(User user);  
  
    void showFailedError();
    void jumpActivity();
}

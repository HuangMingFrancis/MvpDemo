package com.example.mvpdemo.view;

import com.example.mvpdemo.bean.User;
/**
 * Presenter与View交互是通过接口，所以我们需要定义一个IShowUserView的接口，这个接口封装的方法基本上都跟视图展示有关
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

package com.example.mvpdemo.model;


import com.example.mvpdemo.bean.User;
/**
 * Model层抽象接口实现
 * @author Francis
 *
 */
public class GetUserInfo implements IGetUser {

	@Override
	public void getUserInfo(final int id,final OnUserInfoListener listener) {
		// 模拟子线程耗时操作
		new Thread() {
			@Override
			public void run() {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// 模拟信息获取成功
				if (id == 1) {
					User user = new User();
					user.setName("非著名程序员");
					user.setAge("26");
					user.setSex("男");
					user.setId("1");
					listener.getUserInfoSuccess(user);
				} else {
					listener.getUserInfoFailed();
				}
			}
		}.start();
	}

	@Override
	public void editUserInfo(final int id,final OnUserInfoListener listener) {
		new Thread(){
			public void run() {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (id==2) {
					User user=new User();
					user.setName("黃明");
					user.setAge("22");
					user.setSex("男");
					user.setId("2");
					listener.getUserInfoSuccess(user);
				}
				else {
					listener.getUserInfoFailed();
				}
			};
		}.start();
	}

	@Override
	public void login(final User user,final LoginResult listener) {
		new Thread(){
			public void run() {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (user.getName().equals("黄明")&&user.getId().equals("2")) {
					listener.loginSuccess();
				}
				else {
					listener.loginFail();
				}
			};
		}.start();
	}


}

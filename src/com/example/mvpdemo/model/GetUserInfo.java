package com.example.mvpdemo.model;


import com.example.mvpdemo.bean.User;
/**
 * Model�����ӿ�ʵ��
 * @author Francis
 *
 */
public class GetUserInfo implements IGetUser {

	@Override
	public void getUserInfo(final int id,final OnUserInfoListener listener) {
		// ģ�����̺߳�ʱ����
		new Thread() {
			@Override
			public void run() {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// ģ����Ϣ��ȡ�ɹ�
				if (id == 1) {
					User user = new User();
					user.setName("����������Ա");
					user.setAge("26");
					user.setSex("��");
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
					user.setName("�S��");
					user.setAge("22");
					user.setSex("��");
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
				if (user.getName().equals("����")&&user.getId().equals("2")) {
					listener.loginSuccess();
				}
				else {
					listener.loginFail();
				}
			};
		}.start();
	}


}

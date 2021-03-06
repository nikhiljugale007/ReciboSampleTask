package com.example.recibosampletask;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class UserRepositary {
	private UserDao userDao;
	private LiveData<List<User>> allUsers;

	public UserRepositary(Application application) {
		UserDatabase database = UserDatabase.getInstance(application);
		this.userDao = database.userDao();

	}

	public LiveData<List<User>> getAllUsers(int limit , int offset){
		return userDao.getUsers(limit, offset);
	}
	public void inserUser(User user){
		new InsertUserAsyncTask(userDao).execute(user);
	}
	public void updateUser(User user){
		new UpdatetUserAsyncTask(userDao).execute(user);
	}


	private static class InsertUserAsyncTask extends AsyncTask<User, Void, Void>{
		private UserDao userDao;

		public InsertUserAsyncTask(UserDao userDao) {
			this.userDao = userDao;
		}

		@Override
		protected Void doInBackground(User... users) {
			userDao.inserUser(users[0]);
			return null;
		}
	}

	private static class UpdatetUserAsyncTask extends AsyncTask<User, Void, Void>{
		private UserDao userDao;

		public UpdatetUserAsyncTask(UserDao userDao) {
			this.userDao = userDao;
		}

		@Override
		protected Void doInBackground(User... users) {
			userDao.inserUser(users[0]);
			return null;
		}
	}
}

package com.example.recibosampletask;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ViewModel extends AndroidViewModel {
	private UserRepositary userRepositary;
	private LiveData<List<User>> allUsers;

	public ViewModel(@NonNull Application application) {
		super(application);
		userRepositary = new UserRepositary(application);
	}
	public LiveData<List<User>> getAllUser(int limit , int offset){
		return userRepositary.getAllUsers(limit,offset);
	}
	public void insertUser(User user){
		userRepositary.inserUser(user);
	}

	public void updateUser(User user){
		userRepositary.updateUser(user);
	}

	public LiveData<List<User>> getAllUsers() {
		return allUsers;
	}
}

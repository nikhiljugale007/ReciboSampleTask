package com.example.recibosampletask;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class User extends BaseObservable {
	private String firstName;
	private String lastName;
	private String phone;

	public User(String firstName, String lastName, String phone) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
	}

	@Bindable
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
		notifyPropertyChanged(BR.firstName);
	}

	@Bindable
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
		notifyPropertyChanged(BR.lastName);
	}

	@Bindable
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
		notifyPropertyChanged(BR.phone);
	}
}

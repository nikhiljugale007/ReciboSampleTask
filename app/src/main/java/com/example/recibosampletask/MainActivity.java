package com.example.recibosampletask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.recibosampletask.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {

	ActivityMainBinding activityMainBinding;
	ViewModel viewModel;
	public User user = new User("","","");
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);


		activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
		viewModel = ViewModelProviders.of(this).get(ViewModel.class);



		viewModel.getAllUser(1,0).observe(this, new Observer<List<User>>() {
			@Override
			public void onChanged(List<User> users) {
				user = users.get(0);
//				Toast.makeText(MainActivity.this, "Size = "+users.size(), Toast.LENGTH_SHORT).show();
				activityMainBinding.setUser(user);
			}
		});

		viewModel.insertUser(user);

		activityMainBinding.firstname2.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {

			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				saveChanges(s.toString(),1);
			}

			@Override
			public void afterTextChanged(Editable s) {

			}
		});

		activityMainBinding.lastname2.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {

			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				saveChanges(s.toString(),2);
			}

			@Override
			public void afterTextChanged(Editable s) {

			}
		});

		activityMainBinding.phoneNumber2.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {

			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				saveChanges(s.toString(),3);
			}

			@Override
			public void afterTextChanged(Editable s) {

			}
		});
	}

	private void saveChanges(String s, int checker) {
		if(checker == 1){
			String firstname = activityMainBinding.firstname2.getText().toString();
			user.setFirstName(firstname);
		}
		else if(checker == 2){
			String lastname = activityMainBinding.lastname2.getText().toString();
			user.setLastName(lastname);
		}
		else{
			String phone = activityMainBinding.phoneNumber2.getText().toString();
			user.setPhone(phone);
		}
		viewModel.updateUser(user);
	}
}
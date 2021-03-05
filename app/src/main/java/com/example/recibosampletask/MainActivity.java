package com.example.recibosampletask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.recibosampletask.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

	ActivityMainBinding activityMainBinding;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		User user = new User("Shubham","Jugale","7620809434");
		activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
		activityMainBinding.setUser(user);
	}
}
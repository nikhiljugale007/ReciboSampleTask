package com.example.recibosampletask;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {
	@Insert(onConflict = OnConflictStrategy.REPLACE)
	void inserUser(User user);

	@Update
	void updateUser(User user);

	@Delete
	void deleteUser(User user);

	@Query("SELECT * FROM user_table LIMIT :limit OFFSET :offset")
	LiveData<List<User>> getUsers(int limit,int offset);

}

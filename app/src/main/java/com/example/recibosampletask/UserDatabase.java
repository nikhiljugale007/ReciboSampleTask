package com.example.recibosampletask;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

@Database(entities = {User.class} , version = 1)
public abstract class UserDatabase extends RoomDatabase {
	private static UserDatabase instance;

	public abstract UserDao userDao();

	public static synchronized UserDatabase getInstance(Context context){
		if(instance == null){
			instance = Room.databaseBuilder(context.getApplicationContext(),
					UserDatabase.class,"user_database")
					.fallbackToDestructiveMigration()
					.build();
		}
		return instance;
	}

	private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
		@Override
		public void onCreate(@NonNull SupportSQLiteDatabase db) {
			super.onCreate(db);
		}
	};


}

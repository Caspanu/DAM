package com.example.whatsapptema;

import android.content.Context;

import androidx.room.Room;

import java.util.List;

public class Database {

    private static Database database;
    private DatabaseUser databaseUser;

    private Database(Context context){
        databaseUser = Room.databaseBuilder(context, DatabaseUser.class, "user-database").build();
    }

    public static Database getInstance(Context context){
        if(database == null){
            database = new Database(context);
        }
        return database;
    }

    public DatabaseUser getDatabase() {
        return databaseUser;
    }
}

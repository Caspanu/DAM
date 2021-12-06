package com.example.whatsapptema;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class DatabaseUser extends RoomDatabase {
    public abstract UserDAO userDAO();
}

package com.example.whatsapptema;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(User... user);

    @Delete
    void delete(User user);

    @Query("SELECT * FROM user")
    public List<User> getUser();

    @Query("DELETE FROM user")
    void deleteAll();


}

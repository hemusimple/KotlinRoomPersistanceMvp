package test.com.kotlinpractice.db.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import test.com.kotlinpractice.db.room.entity.User

@Dao
interface UserDao{

    @Insert
    fun insertAll(vararg users: User)

    @Query("SELECT * FROM User")
    fun getAllUsers(): List<User>

}
package test.com.kotlinpractice.db.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import test.com.kotlinpractice.db.room.dao.UserDao
import test.com.kotlinpractice.db.room.entity.User

@Database(entities = arrayOf(User::class), version = 1)
abstract class TestDataBase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        private var INSTANCE: TestDataBase? = null

        fun getInstance(context: Context): TestDataBase? {
            if (INSTANCE == null) {
                synchronized(TestDataBase::class) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), TestDataBase::class.java, "user.db").build()
                }
            }
            return INSTANCE
        }

    }
}
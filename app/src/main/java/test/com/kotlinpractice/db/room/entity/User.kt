package test.com.kotlinpractice.db.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User (@PrimaryKey val uid:Long, @ColumnInfo(name="name")val name:String,@ColumnInfo(name="age") val age:Int)
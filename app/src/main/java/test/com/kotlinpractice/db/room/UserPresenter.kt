package test.com.kotlinpractice.db.room

import android.widget.LinearLayout

interface UserPresenter {
   fun  addUser(name:String,age:Int)
   fun getAllUsers(layout:LinearLayout)
}
package test.com.kotlinpractice.db.room

import android.app.Activity
import android.widget.LinearLayout
import android.widget.TextView
import test.com.kotlinpractice.db.room.entity.User
import java.util.concurrent.Executors

class UserPresenterImpl(context: Activity, dataBase: TestDataBase, userView: UserView) : UserPresenter {

    private var dataBase: TestDataBase? = dataBase
    private var userView: UserView? = userView
    private var context: Activity? = context


    /*
    * Add user.
    * */
    override fun addUser(name: String, age: Int) {
        val task = Executors.newSingleThreadExecutor()
        task.execute(object : Runnable {
            override fun run() {
                dataBase!!.userDao().insertAll(User(System.currentTimeMillis(), name, age))
                context!!.runOnUiThread(object : Runnable {
                    override fun run() {
                        userView!!.onUserAdded(name)
                    }
                })
            }
        })
    }


    /*
    * List all Users.
    * */
    override fun getAllUsers(layout: LinearLayout) {
        val task = Executors.newSingleThreadExecutor()
        task.execute(object : Runnable {
            override fun run() {
                val list = dataBase!!.userDao().getAllUsers()
                context!!.runOnUiThread(object : Runnable {
                    override fun run() {
                        for (user in list) {
                            var textview= TextView(context)
                            textview.setText(user.name)
                            layout.addView(textview)
                        }
                    }
                })
            }
        })
    }
}
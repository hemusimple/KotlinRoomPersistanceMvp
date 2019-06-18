package test.com.kotlinpractice

import android.os.Bundle

import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import test.com.kotlinpractice.db.room.TestDataBase
import test.com.kotlinpractice.db.room.UserPresenter
import test.com.kotlinpractice.db.room.UserPresenterImpl
import test.com.kotlinpractice.db.room.UserView


class MainActivity : AppCompatActivity(), UserView {

 private  var userPresenter: UserPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        userPresenter = UserPresenterImpl(this, TestDataBase.getInstance(this)!!,this)
        findViewById<Button>(R.id.add).setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                addUser()
            }
        })
    }

    /*
    * Add user.
    * */
    fun addUser() {
        userPresenter!!.addUser(
            findViewById<EditText>(R.id.username).text.toString(),
            findViewById<EditText>(R.id.age).text.toString().toInt()
        )
    }

    override fun onUserAdded(status: String) {
        Toast.makeText(this, "Added User-> ${status}", Toast.LENGTH_LONG).show()
        userPresenter!!.getAllUsers(findViewById<LinearLayout>(R.id.allusers))
    }
}
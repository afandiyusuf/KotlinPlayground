package id.kurniaeliazar.kotlinplayground.oo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import id.kurniaeliazar.kotlinplayground.R

class ObjectActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_object)

        val rv = findViewById<RecyclerView>(R.id.recyclerView1)
        rv.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        val users = ArrayList<User>()
        users.add(User("Edi Ermawan", "Mr"))
        users.add(User("Panji Yudhasetya W", "Mr"))
        users.add(User("Kurnia", "Mr"))

        var adapter = CustomAdapter(users)
        rv.adapter = adapter
    }
}

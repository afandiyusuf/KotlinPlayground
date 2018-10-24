package id.kurniaeliazar.kotlinplayground

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import id.kurniaeliazar.kotlinplayground.oo.ObjectActivity
import id.kurniaeliazar.kotlinplayground.basic.BasicActivity
import id.kurniaeliazar.kotlinplayground.functional.FunctionalActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonBasic.setOnClickListener{
            startActivity(Intent(this, BasicActivity::class.java) )
        }

        buttonFunctional.setOnClickListener{
            startActivity(Intent(this, FunctionalActivity::class.java) )
        }

        buttonOO.setOnClickListener{
            startActivity(Intent(this, ObjectActivity::class.java) )
        }
    }
}

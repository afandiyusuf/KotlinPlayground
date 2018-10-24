package id.kurniaeliazar.kotlinplayground.basic

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import id.kurniaeliazar.kotlinplayground.R
import kotlinx.android.synthetic.main.activity_basic.*

class BasicActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic)

        // Data types
        btnDataTypes.setOnClickListener{
            // val - imutable
            val someString = "Some String"
            val someInt : Int = 1_000_000
            val someDouble : Double = 1.5
            val someBoolean : Boolean = true

            // null value
            val someNull : String? = null

            // mutablle
            var someStringWithDataType  : String = "Some String with data type"

            // update the value for var
            someStringWithDataType = "Some String with data type (upddated)"

            outputBasic.text =
                    "$someString \n " +
                    "$someStringWithDataType \n " +
                    "$someInt \n " +
                    "$someDouble \n " +
                    "$someBoolean \n " +
                    "$someNull"
        }

        // Null safety
        btnNullSafety.setOnClickListener{

            var someString : String? = "This is a sample string"
            val someString2 : String? = "This is a second sample string"

            if (someString!!.isEmpty()) {
                someString.toLowerCase()
            }

            someString2?.let {
                if (someString2.isEmpty()) {
                    someString2.toLowerCase()
                }
            }

            var lengthOfSomeString = 0

            if (someString != null) {
                lengthOfSomeString =  someString.length
            }

            // update someString value to null
            someString = null

            val lengthOfSomeString2 : Int? = someString2?.length ?: 0

            outputBasic.text =
                    "someString: $someString \n " +
                    "lengthOfSomeString: $lengthOfSomeString \n" +
                    "lengthOfSomeString2: $lengthOfSomeString2"

        }

        // Conditional
        btnConditional.setOnClickListener{
            val someNumber = 25
            val result = if (someNumber % 2 == 0) "Even" else "Odd"

            var whenResult: String = when(someNumber) {
                in 1..10 -> "less than 10"
                in 11..25 -> "more than 10"
                else -> "unknown"
            }

            outputBasic.text = "$result \n $whenResult"
        }

        // Looping
        btnLooping.setOnClickListener {
            outputBasic.text = "Check the log cat for the result"

            for (i in 1..5) {
                Log.i("Sample Looping 1", "$i ")
            }

            for (i in 10 downTo 1) {
                Log.i("Sample Looping 2", "$i ")
            }

            for (s in "Text") {
                Log.i("Sample Looping 3", "$s ")
            }

            val languages = listOf("Kotlin", "Clojure", "Javascript")
            for (lang in languages) {
                Log.i("Sample Looping 4", lang)
            }
        }

        // Collection
        btnCollection.setOnClickListener{
            val arrayInt = arrayOf(1, 2, 3)
            val listWelcomeString = listOf("Hi", "Hello", "Hola")
            val mapDayName = mapOf(Pair(1, "Monday"), 2 to "Tuesday")

            val listofNumber = mutableListOf("One", "Two")
            listofNumber.add("three")

            outputBasic.text =
                    arrayInt.toList().joinToString() + "\n" +
                    listWelcomeString.joinToString() + "\n" +
                    mapDayName.toList().joinToString() + "\n" +
                    listofNumber.joinToString()
        }

        // function
        btnFunction.setOnClickListener{
            fun checkEvenNumber(vararg someNumbers: Int): Boolean {
                return someNumbers.any{ number -> number % 2 == 0 }
            }

            val result = checkEvenNumber(0, 2, 4)
            outputBasic.text = "$result "
        }

    }
}

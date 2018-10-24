package id.kurniaeliazar.kotlinplayground.functional

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import id.kurniaeliazar.kotlinplayground.R
import kotlinx.android.synthetic.main.activity_basic.*
import kotlinx.android.synthetic.main.activity_functional.*
import kotlin.system.measureTimeMillis

class FunctionalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_functional)

        btnHighOrderFunction.setOnClickListener{
            val timesThree = { x: Int -> x*3 }
            val add: (Int, Int) -> Int = { x: Int, y: Int -> x+y }

            fun isEven(i: Int) = i % 2 == 0
            fun Int.even() = this % 2 == 0

            val list = (1..100).toList()
            var filteredList = list.filter { element -> element % 2 == 0 }
            filteredList = list.filter { it % 2 == 0 }
            filteredList = list.filter (:: isEven)
            filteredList = list.filter { it.even() }

            outputFunctional.text = filteredList.joinToString()
        }

        btnMapFlatMap.setOnClickListener{
            val list = (1..10).toList()
            val doubled = list.map { it * 2 }

            val nestedList = listOf(
                    (1..10).toList(),
                    (11..20).toList(),
                    (21..30).toList()
            )

            val beforeFlatten = nestedList.map { it.sortedDescending() }
            val afterFlatten = nestedList.map { it.sortedDescending() }.flatten()

            outputFunctional.text =
                    "Map \n $doubled.joinToString() \n\n " +
                    "Flatten Map \n " +
                    "Before flatten: ${beforeFlatten.joinToString()} \n" +
                    "After flatten: ${afterFlatten.joinToString()} \n"

        }

         btnZip.setOnClickListener{
            val list  = generateSequence(0) { it + 10 }
            val first10 = list.take(10).toList()
            val first20 = list.take(20).toList()

            val secondList = (1..1000).toList()
            val removedFirst800 = secondList.drop(800)

            val zipList = listOf("Take", "Drop", "Zip")
            val zipContain = listOf(true, false, true)
            val zipped: List<Pair<String, Boolean>> = zipList.zip(zipContain)

            outputFunctional.text =
                    "take: ${first10.joinToString()} \n\n" +
                    "drop: ${removedFirst800.joinToString()} \n\n " +
                    "zipped: ${zipped.joinToString()}"
         }

        btnChainFunction.setOnClickListener{
            val data = listOf(
                mapOf("data 1" to listOf(3, -10, 8, 2, 9000)),
                mapOf("data 2" to listOf(1, 8, -8900))
            )

            val result = data.flatMap { it.values }
                    .flatten()
                    .filter { it in 1..10 }
                    .toIntArray()
                    .joinToString()

            outputFunctional.text = result
        }

        btnLazySequence.setOnClickListener{
            val longList = (1..999999L).toList()

            var sum = 0L
            var lazySum = 0L

            val msNonLazy = measureTimeMillis {
                sum = longList
                        .filter { it > 50 }
                        .map {it * 2}
                        .take(1000)
                        .sum()
            }

            val msLazy = measureTimeMillis {
                sum = longList
                        .asSequence()
                        .filter { it > 50 }
                        .map {it * 2}
                        .take(1000)
                        .sum()
            }

            outputFunctional.text =
                    "msNonLazy: $msNonLazy ms \n" +
                    "msLazy: $msLazy ms"
        }

        btnWith.setOnClickListener{
            val props = System.getProperties()

            with(props) {
                Log.i("Property Names", propertyNames().toList().joinToString())
                Log.i("Get Property", getProperty("http.agent"))
            }

            outputFunctional.text = "Check the logcat for the result"
        }
    }
}

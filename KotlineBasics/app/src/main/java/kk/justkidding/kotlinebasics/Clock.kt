package kk.justkidding.kotlinebasics
import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

@RequiresApi(Build.VERSION_CODES.O)
fun main(){

    var currentdate  = LocalDate.now()
    var currenttime = LocalTime.now()
    println("Current Date and Time is:\n $currentdate \n $currenttime")
}

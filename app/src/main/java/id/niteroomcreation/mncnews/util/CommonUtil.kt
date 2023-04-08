package id.niteroomcreation.mncnews.util

import java.text.SimpleDateFormat
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * Created by Septian Adi Wijaya on 08/04/2023.
 * please be sure to add credential if you use people's code
 */
object CommonUtil {

    fun String.dateFormatWithTime(): String {
        if (this.isBlank())
            return ""

        val instant = Instant.parse(this)
        val formatter = DateTimeFormatter.ofPattern("EEEE, d MMMM yyyy")
            .withZone(ZoneId.of(TimeZone.getDefault().id))
        return formatter.format(instant)
    }

    fun String.elapseTimeFromDate(): String {
        if (this.isBlank())
            return ""

        val formattedDate: Date = SimpleDateFormat(
            "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",
            Locale.getDefault()
        ).parse(this) as Date
        val now: Date = Date()
        val diffInMillis = now.time - formattedDate.time

        val diffInSeconds = TimeUnit.MILLISECONDS.toSeconds(diffInMillis)
        val diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(diffInMillis)
        val diffInHours = TimeUnit.MILLISECONDS.toHours(diffInMillis)
        val diffInDays = TimeUnit.MILLISECONDS.toDays(diffInMillis)
        val diffInWeeks = diffInDays / 7
        val diffInMonths = diffInDays / 30
        val diffInYear = diffInMonths / 12

        return when {
            diffInYear > 0 -> "$diffInYear tahun lalu"
            diffInMonths > 0 -> "$diffInMonths bulan lalu"
            diffInWeeks > 0 -> "$diffInWeeks minggu lalu"
            diffInDays > 0 -> "$diffInDays hari lalu"
            diffInHours > 0 -> "$diffInHours jam lalu"
            diffInMinutes > 0 -> "$diffInMinutes menit lalu"
            else -> "$diffInSeconds detik lalu"
        }
    }
}
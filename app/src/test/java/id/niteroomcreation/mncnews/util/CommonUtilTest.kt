package id.niteroomcreation.mncnews.util

import id.niteroomcreation.mncnews.util.CommonUtil.dateFormatWithTime
import id.niteroomcreation.mncnews.util.CommonUtil.elapseTimeFromDate
import org.junit.Assert
import org.junit.Assert.*

import org.junit.Test

/**
 * Created by Septian Adi Wijaya on 08/04/2023.
 * please be sure to add credential if you use people's code
 */
class CommonUtilTest {

    @Test
    fun dateFormatWithTime() {

        val actual = "2021-05-24T00:14:44.689Z"
        val expect = "Monday, 24 May 2021"
        val output = actual.dateFormatWithTime()

        Assert.assertEquals(expect, output)

    }

    @Test
    fun elapseTimeFromDate() {
        val actual = "2021-05-24T00:14:44.689Z"
        val expect = "1 tahun lalu"
        val output = actual.elapseTimeFromDate()

        Assert.assertEquals(expect, output)

    }
}
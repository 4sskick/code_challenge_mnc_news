package id.niteroomcreation.mncnews.util

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

/**
 * Created by Septian Adi Wijaya on 07/04/2023.
 * please be sure to add credential if you use people's code
 */
object NavUtil {

    fun moveToFragment(
        fragmentManager: FragmentManager,
        viewIdFrameLayout: Int,
        fragment: Fragment?,
        fragmentTag: String?,
    ) {
        try {
            fragmentManager.beginTransaction()
                .replace(viewIdFrameLayout, fragment!!, fragmentTag)
                .commit()
        } catch (e: Exception) {
            throw IllegalStateException(
                String.format(
                    "Seems like fragmentManager isn't " +
                            "initialized %s", e.message
                )
            )
        }
    }
}
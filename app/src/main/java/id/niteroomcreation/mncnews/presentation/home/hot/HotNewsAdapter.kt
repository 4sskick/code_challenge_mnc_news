package id.niteroomcreation.mncnews.presentation.home.hot

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import id.niteroomcreation.mncnews.domain.model.Article

/**
 * Created by Septian Adi Wijaya on 07/04/2023.
 * please be sure to add credential if you use people's code
 */
class HotNewsAdapter(
    fragment: Fragment,
    private val content: List<Article>,
) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return content.size
    }

    override fun createFragment(position: Int): Fragment {
        return HotNewsFragment()
    }
}
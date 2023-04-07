package id.niteroomcreation.mncnews.presentation.home.hot

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import id.niteroomcreation.mncnews.domain.model.Article
import id.niteroomcreation.mncnews.util.listener.GenericItemListener

/**
 * Created by Septian Adi Wijaya on 08/04/2023.
 * please be sure to add credential if you use people's code
 */
class HotNewsAdapter(
    fragment: Fragment,
    private val contents: List<Article>,
) : FragmentStateAdapter(fragment) {

    private var listener: GenericItemListener<Article, Nothing>? = null

    fun setListener(listener: GenericItemListener<Article, Nothing>) {
        this.listener = listener
    }

    override fun getItemCount(): Int = contents.size

    override fun createFragment(position: Int): Fragment {
        val fragment = HotNewsFragment()
        fragment.arguments = Bundle().apply {
            putParcelable(HotNewsFragment.ARTICLE_DATA, contents[position])
        }

        listener?.let { fragment.setListener(it) }
        return fragment
    }
}
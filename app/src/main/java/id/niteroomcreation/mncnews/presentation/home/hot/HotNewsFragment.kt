package id.niteroomcreation.mncnews.presentation.home.hot

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import id.niteroomcreation.mncnews.databinding.FHotNewsBinding
import id.niteroomcreation.mncnews.domain.model.Article
import id.niteroomcreation.mncnews.util.LogHelper
import id.niteroomcreation.mncnews.util.listener.GenericItemListener

/**
 * Created by Septian Adi Wijaya on 07/04/2023.
 * please be sure to add credential if you use people's code
 */
class HotNewsFragment : Fragment() {

    companion object {
        val TAG = HotNewsFragment::class.java.simpleName
        val ARTICLE_DATA = "article.data"
    }

    private lateinit var binding: FHotNewsBinding
    private var listener: GenericItemListener<Article, Nothing>? = null

    fun setListener(listener: GenericItemListener<Article, Nothing>) {
        this.listener = listener
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FHotNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = this.arguments
        if (bundle != null) {
            val item = bundle.getParcelable<Parcelable>(ARTICLE_DATA) as Article


            LogHelper.j(TAG, item)

            Glide.with(requireContext())
                .load(item.contentThumbnail)
                .into(binding.hotThumbnail)

            binding.hotTitle.text = item.title
            binding.hotDate.text = item.createdAt

            binding.root.setOnClickListener {
                listener?.onItemViewClicked(item)
            }
        }
    }


}
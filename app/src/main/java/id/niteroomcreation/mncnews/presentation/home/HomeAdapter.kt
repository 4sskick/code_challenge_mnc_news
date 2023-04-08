package id.niteroomcreation.mncnews.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.niteroomcreation.mncnews.databinding.INewsBinding
import id.niteroomcreation.mncnews.domain.model.Article
import id.niteroomcreation.mncnews.util.listener.GenericItemListener

/**
 * Created by Septian Adi Wijaya on 07/04/2023.
 * please be sure to add credential if you use people's code
 */
class HomeAdapter(private val listener: GenericItemListener<Article, Nothing>) :
    ListAdapter<Article, ViewHolder>(DIFF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = INewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binds(getItem(position))
    }


}

private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Article>() {
    override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem == newItem
    }

}

class ViewHolder(
    private val binding: INewsBinding,
    private val listener: GenericItemListener<Article, Nothing>
) : RecyclerView.ViewHolder(binding.root) {

    fun binds(item: Article) {
        Glide.with(itemView.context).load(item.contentThumbnail).into(binding.hotThumbnail)
        binding.hotTitle.text = item.title
        binding.hotDate.text = item.createdAt
        itemView.setOnClickListener {
            listener.onItemViewClicked(item)
        }
    }
}
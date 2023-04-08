package id.niteroomcreation.mncnews.presentation.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.niteroomcreation.mncnews.databinding.ISlideshowBinding
import id.niteroomcreation.mncnews.util.LogHelper

/**
 * Created by Septian Adi Wijaya on 08/04/2023.
 * please be sure to add credential if you use people's code
 */
class DetailSlideShowAdapter(var data: List<String>) : RecyclerView.Adapter<ViewHolder>() {

    companion object {
        val TAG = DetailSlideShowAdapter::class.simpleName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ISlideshowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    fun submit(data: List<String>) {
        LogHelper.j(TAG, data)

        this.data = data
    }

    private fun getItem(pos: Int): String {
        return data[pos]
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binds(getItem(position))
    }

    override fun getItemCount(): Int {
        return data.size
    }
}

class ViewHolder(private var binding: ISlideshowBinding) : RecyclerView.ViewHolder(binding.root) {

    fun binds(slideShow: String) {
        Glide.with(binding.detailSlideshow).load(slideShow).into(binding.detailSlideshow)
    }

}
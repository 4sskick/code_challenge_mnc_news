package id.niteroomcreation.mncnews.presentation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import id.niteroomcreation.mncnews.R
import id.niteroomcreation.mncnews.data.common.Resource
import id.niteroomcreation.mncnews.databinding.FDetailBinding
import id.niteroomcreation.mncnews.util.CommonUtil.dateFormatWithTime
import id.niteroomcreation.mncnews.util.EqualSpacingItemDecoration
import id.niteroomcreation.mncnews.util.LogHelper

/**
 * Created by Septian Adi Wijaya on 07/04/2023.
 * please be sure to add credential if you use people's code
 */

@AndroidEntryPoint
class DetailFragment : Fragment() {

    companion object {
        val TAG = DetailFragment::class.java.simpleName
    }

    private lateinit var binding: FDetailBinding;
    private lateinit var adapterSlideShow: DetailSlideShowAdapter
    private val viewModel: DetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.state.observe(viewLifecycleOwner, Observer() {

            LogHelper.e(TAG, it)

            when (it) {
                is Resource.Error -> {
                    Snackbar.make(
                        binding.root,
                        it.message ?: "Unknown Error occurred",
                        Snackbar.LENGTH_LONG
                    ).show()
                }
                is Resource.Loading -> {

                }
                is Resource.Success -> {
                    binding.detailContent.text = it.data.article?.content
                    binding.detailContributor.text = it.data.article?.contributorName
                    binding.detailTitle.text = it.data.article?.title
                    binding.detailDate.text = it.data.article?.createdAt?.dateFormatWithTime()

                    Glide.with(requireContext())
                        .load(it.data.article?.contentThumbnail)
                        .into(binding.detailThumbnail)


                    it.data.article?.slideshow?.let { dataSlideShow ->
                        LogHelper.j(TAG, dataSlideShow)

                        adapterSlideShow.submit(dataSlideShow)
                        adapterSlideShow.notifyDataSetChanged()

                    }
                }
            }
        })
        setupAdapter()
    }

    private fun setupAdapter() {
        adapterSlideShow = DetailSlideShowAdapter(emptyList())
        binding.rvList.adapter = adapterSlideShow
        binding.rvList.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.HORIZONTAL,
            false
        )
        val equalSpacingItemDecoration = EqualSpacingItemDecoration(
            resources.getDimensionPixelSize(R.dimen.spacing), 0
        )
        binding.rvList.addItemDecoration(equalSpacingItemDecoration)
    }
}
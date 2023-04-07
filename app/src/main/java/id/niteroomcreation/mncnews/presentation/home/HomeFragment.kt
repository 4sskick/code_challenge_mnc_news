package id.niteroomcreation.mncnews.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import id.niteroomcreation.mncnews.data.common.Resource
import id.niteroomcreation.mncnews.databinding.FHomeBinding
import id.niteroomcreation.mncnews.util.LogHelper

/**
 * Created by Septian Adi Wijaya on 07/04/2023.
 * please be sure to add credential if you use people's code
 */
@AndroidEntryPoint
class HomeFragment : Fragment() {

    companion object {
        val TAG = HomeFragment::class.java.simpleName
    }

    private lateinit var binding: FHomeBinding;

    //by viewModels() or ViewModelProvider(this).get(CharactersViewModel::class.java)
    //is same things -> lazy initialization
    private val mViewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.swipeRefreshLayout.setOnRefreshListener {
            mViewModel.doGetArticles()
        }

        mViewModel.state.observe(viewLifecycleOwner, Observer {

            LogHelper.j(TAG, it)

            when (it) {
                is Resource.Error -> {
                    binding.swipeRefreshLayout.isRefreshing = false
                }
                is Resource.Loading -> {
                    binding.swipeRefreshLayout.isRefreshing = true
                }
                is Resource.Success -> {
                    binding.nestedScrollLayout.isVisible = it.data?.isEmpty() == false
                    binding.swipeRefreshLayout.isRefreshing = false
                }
            }

        })

        setupHotNews();
        setupLatestNews();
    }

    private fun setupLatestNews() {


    }

    private fun setupHotNews() {


    }


}
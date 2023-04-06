package id.niteroomcreation.mncnews.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import id.niteroomcreation.mncnews.R
import id.niteroomcreation.mncnews.databinding.AMainBinding

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: AMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = AMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }
}
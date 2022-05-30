package wingeddev.example.kindnesschallenge.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import wingeddev.example.kindnesschallenge.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        viewModel
        setContentView(binding.root)
    }

}
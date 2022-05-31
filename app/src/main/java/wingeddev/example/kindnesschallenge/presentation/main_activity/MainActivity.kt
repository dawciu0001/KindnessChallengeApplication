package wingeddev.example.kindnesschallenge.presentation.main_activity

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

        /* a little bit of explanation fot he next 20 lines:
        -----------   1. init             -----------------
       | viewModel |  ---->               |  mainActivity |
       |           |        <---          |               |
       ------------       2. changeBTN    -----------------

       1. on viewModel initialization, a random deed with "nothing" as a tag/requirement is
       displayed
       2. when changeBTN is pressed the "SelectedTags" list is being passed to viewModel and
       a random deed is fetched from database
        */

        val selectedTags = mutableListOf("nothing")
        // nothing is a default value, not changeable, so the tag list always contains this tag

        viewModel.observableLiveData.observe(this) {
            binding.deedTV.text = it.deed
        }

        binding.changeBTN.setOnClickListener {
            viewModel.randomDeed(selectedTags)
        }

        binding.tagCourageBTN.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked) selectedTags.add("courage") else selectedTags.remove("courage")
        }

        binding.tagMoneyBTN.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked) selectedTags.add("money") else selectedTags.remove("money")
        }

        binding.changeBTN.setOnClickListener {
            viewModel.randomDeed(selectedTags) // this changes the observableLiveData and triggers
            // the observer on line 36. which changes the text
        }


        setContentView(binding.root)
    }



}
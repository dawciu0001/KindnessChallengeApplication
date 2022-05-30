package wingeddev.example.kindnesschallenge.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import wingeddev.example.kindnesschallenge.domain.use_case.get_required_deeds.GetRequiredDeedsUseCase
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    getRequiredDeedsUseCase: GetRequiredDeedsUseCase
): ViewModel() {
    init {
        viewModelScope.launch {
            getRequiredDeedsUseCase.getRequiredDeeds(listOf("money", "nothing")).first().forEach { deed ->
                Log.i("testing", deed.toString())
                // if somebody is reading this, it is literally the code
                // I've written in about 20 minutes, just to implement the basics of my idea
                // before I forget them 
            }
        }
    }
}
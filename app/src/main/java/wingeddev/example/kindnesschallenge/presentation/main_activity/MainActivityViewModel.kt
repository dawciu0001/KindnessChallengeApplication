package wingeddev.example.kindnesschallenge.presentation.main_activity

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import wingeddev.example.kindnesschallenge.data.local.model.DeedEntity
import wingeddev.example.kindnesschallenge.domain.use_case.get_required_deeds.GetRequiredDeedsUseCase
import javax.inject.Inject
import kotlin.random.Random


@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val getRequiredDeedsUseCase: GetRequiredDeedsUseCase
): ViewModel() {
    private val observableMutableLiveData = MutableLiveData<DeedEntity>()
    val observableLiveData: LiveData<DeedEntity> = observableMutableLiveData

    init {
        randomDeed()
    }

    fun randomDeed(tags: List<String> = listOf("nothing")) {
        viewModelScope.launch {
            viewModelScope.launch {
                // a bit of explanation:
                // 1. "nothing" is the default, not changeable tag, so on app start a deed with that TAG
                // is fetched.
                // 2. first(), cause the flow returns only one LIST
                val listOfDeeds = getRequiredDeedsUseCase.getRequiredDeeds(tags).first()
                val random = Random.nextInt(0, listOfDeeds.size-1)
                observableMutableLiveData.value = (listOfDeeds[random])
            }
        }
    }

}

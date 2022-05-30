package wingeddev.example.kindnesschallenge.domain.use_case.get_required_deeds

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import wingeddev.example.kindnesschallenge.data.local.model.DeedEntity
import wingeddev.example.kindnesschallenge.domain.repository.DeedRepository
import javax.inject.Inject

class GetRequiredDeedsUseCase @Inject constructor(
    private val repository: DeedRepository
) {
    fun getRequiredDeeds(tags: List<String>): Flow<List<DeedEntity>> = flow {
        emit(repository.getRequiredDeeds(tags))
    }
}
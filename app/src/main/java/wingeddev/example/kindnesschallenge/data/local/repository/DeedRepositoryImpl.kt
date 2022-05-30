package wingeddev.example.kindnesschallenge.data.local.repository

import wingeddev.example.kindnesschallenge.data.local.dao.DeedDao
import wingeddev.example.kindnesschallenge.data.local.model.DeedEntity
import wingeddev.example.kindnesschallenge.domain.repository.DeedRepository
import javax.inject.Inject

class DeedRepositoryImpl @Inject constructor(
    private val deedDao: DeedDao
): DeedRepository {
    override suspend fun getRequiredDeeds(selectedTags: List<String>): List<DeedEntity> {
        return deedDao.getRequiredDeeds(selectedTags)
    }
}
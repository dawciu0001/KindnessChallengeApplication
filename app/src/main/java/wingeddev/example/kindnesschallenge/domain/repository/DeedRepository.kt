package wingeddev.example.kindnesschallenge.domain.repository

import wingeddev.example.kindnesschallenge.data.local.model.DeedEntity

interface DeedRepository {
    suspend fun getRequiredDeeds(selectedTags: List<String>): List<DeedEntity>
}
package wingeddev.example.kindnesschallenge.data.local.dao

import androidx.room.Query
import wingeddev.example.kindnesschallenge.data.local.model.DeedEntity

@androidx.room.Dao
interface DeedDao {
    @Query("SELECT * FROM all_good_deeds WHERE requires IN (:selectedTags)")
    suspend fun getRequiredDeeds(selectedTags: List<String>): List<DeedEntity>
}
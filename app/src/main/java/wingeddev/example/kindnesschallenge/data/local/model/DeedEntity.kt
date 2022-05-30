package wingeddev.example.kindnesschallenge.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "all_good_deeds")
data class DeedEntity(
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "requires")
    val requires: String,
    @ColumnInfo(name= "deed")
    val deed: String
)
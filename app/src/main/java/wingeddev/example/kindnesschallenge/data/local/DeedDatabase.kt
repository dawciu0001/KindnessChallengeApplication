package wingeddev.example.kindnesschallenge.data.local

import android.content.Context
import androidx.room.RoomDatabase
import wingeddev.example.kindnesschallenge.data.local.dao.DeedDao
import wingeddev.example.kindnesschallenge.data.local.model.DeedEntity

@androidx.room.Database(entities = [DeedEntity::class], version = 1)
abstract class DeedDatabase: RoomDatabase() {
    abstract fun getDeedDao(): DeedDao
}
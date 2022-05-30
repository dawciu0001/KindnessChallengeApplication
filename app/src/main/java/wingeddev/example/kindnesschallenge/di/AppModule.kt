package wingeddev.example.kindnesschallenge.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import wingeddev.example.kindnesschallenge.data.local.DeedDatabase
import wingeddev.example.kindnesschallenge.data.local.dao.DeedDao
import wingeddev.example.kindnesschallenge.data.local.repository.DeedRepositoryImpl
import wingeddev.example.kindnesschallenge.domain.repository.DeedRepository
import wingeddev.example.kindnesschallenge.domain.use_case.get_required_deeds.GetRequiredDeedsUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext appContext: Context): DeedDatabase {
        return Room
            .databaseBuilder(appContext, DeedDatabase::class.java, "DeedDatabase.db")
            .createFromAsset("goodDeeds.db")
            .build()
    }

    @Singleton
    @Provides
    fun provideDao(db: DeedDatabase): DeedDao {
        return db.getDeedDao()
    }

    @Singleton
    @Provides
    fun provideRepository(dao: DeedDao): DeedRepository {
        return DeedRepositoryImpl(dao)
    }

    @Singleton
    @Provides
    fun provideRequiredDeedsUseCase(repository: DeedRepository): GetRequiredDeedsUseCase {
        return GetRequiredDeedsUseCase(repository)
    }

}
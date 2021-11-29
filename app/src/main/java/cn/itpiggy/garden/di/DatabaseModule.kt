package cn.itpiggy.garden.di

import android.content.Context
import cn.itpiggy.garden.data.AppDatabase
import cn.itpiggy.garden.data.GardenPlantingDao
import cn.itpiggy.garden.data.PlantDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase =
        AppDatabase.getInstance(context)

    @Provides
    fun providePlantDao(appDatabase: AppDatabase): PlantDao = appDatabase.plantDao()


    @Provides
    fun provideGardenPlantingDap(appDatabase: AppDatabase): GardenPlantingDao =
        appDatabase.gardenPlantingDao()
}
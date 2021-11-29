package cn.itpiggy.garden.data

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GardenPlantingRepository @Inject constructor(
    private val gardenPlantingDao: GardenPlantingDao
) {
    fun getPlantedGardens() = gardenPlantingDao.getPlantedGardens()
}
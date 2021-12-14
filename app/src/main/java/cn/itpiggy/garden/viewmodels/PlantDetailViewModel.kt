package cn.itpiggy.garden.viewmodels

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import cn.itpiggy.garden.data.GardenPlantingRepository
import cn.itpiggy.garden.data.PlantRepository
import kotlinx.coroutines.launch

class PlantDetailViewModel @ViewModelInject internal constructor(
    plantRepository: PlantRepository,
    @Assisted
    savedStateHandle: SavedStateHandle,
    private val gardenPlantingRepository: GardenPlantingRepository
) : ViewModel() {
    val plantId: String = savedStateHandle.get<String>(PLANT_ID_SAVED_STATE_KEY)!!



    val isPlanted = gardenPlantingRepository.isPlanted(plantId).asLiveData()

    val plant = plantRepository.getPlant(plantId).asLiveData()

    fun addPlantToGarden() {
        viewModelScope.launch {
            gardenPlantingRepository.createGardenPlanting(plantId)
        }
    }

//    fun hasValidUnsplashKey = BuildConfig.UNSPLASH_ACCESS_KEY != "null"

    companion object {
        private const val PLANT_ID_SAVED_STATE_KEY = "plantId"
    }
}
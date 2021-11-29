package cn.itpiggy.garden.viewmodels

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import cn.itpiggy.garden.data.GardenPlantingRepository
import cn.itpiggy.garden.data.PlantAndGardenPlantings


class GardenPlantingListViewModel @ViewModelInject internal constructor(
    gardenPlantingRepository: GardenPlantingRepository,
    @Assisted
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    val plantAndGardenPlantings: LiveData<List<PlantAndGardenPlantings>> =
        gardenPlantingRepository.getPlantedGardens().asLiveData()
}
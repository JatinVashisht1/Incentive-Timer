package com.example.incentivetimer.ui.presentation.reward_list_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.incentivetimer.data.Reward
import com.example.incentivetimer.data.RewardDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RewardListViewModel @Inject constructor(private val rewardDao: RewardDao) : ViewModel() {
    private val _rewardListViewModel = MutableStateFlow<List<Reward>>(listOf())
    val rewards = _rewardListViewModel.asLiveData()

    init {
        viewModelScope.launch {
            rewardDao.getAllRewards().collect { rewardList ->
                _rewardListViewModel.value = rewardList
            }
        }
    }
}
//
//        val dummyRewards = mutableListOf<Reward>()
//        repeat(100) { index ->
//            dummyRewards += Reward(iconKey = IconKeys.CAKE, title = "title", chancePercent = index)
//        }
//        _dummyRewardListViewModel.value = du

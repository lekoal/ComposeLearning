package com.private_projects.composelearning.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.private_projects.composelearning.domain.FeedPost
import com.private_projects.composelearning.domain.VkStatistics

class MainViewModel : ViewModel() {
    private val _isUserFollowed = MutableLiveData<Boolean>()
    val isUserFollowed: LiveData<Boolean> = _isUserFollowed

    private val _feedPost = MutableLiveData(FeedPost())
    val feedPost: LiveData<FeedPost> = _feedPost

    fun updateCount(item: VkStatistics) {
        val oldStatistics = feedPost.value?.statistics ?: throw IllegalStateException()
        val newStatistics = oldStatistics.toMutableList().apply {
            replaceAll { oldItem ->
                if (oldItem.iconId == item.iconId) {
                    oldItem.apply {
                        count + 1
                    }
                } else {
                    oldItem
                }
            }
        }
        _feedPost.postValue(feedPost.value?.copy(statistics = newStatistics))
    }

//    private val _views = MutableLiveData(100)
//    val views: LiveData<Int> = _views
//    private val _exchanges = MutableLiveData(10)
//    val exchanges: LiveData<Int> = _exchanges
//    private val _comments = MutableLiveData(20)
//    val comments: LiveData<Int> = _comments
//    private val _favorites = MutableLiveData(11)
//    val favorites: LiveData<Int> = _favorites


//    fun changeUserFollowStatus() {
//        _isUserFollowed.postValue(!(_isUserFollowed.value ?: false))
//    }
//
//    fun increaseCount(statusNumbers: VkStatistics) {
//        when (statusNumbers) {
//            is VkStatistics.Views -> {
//                _views.postValue((_views.value ?: 0) + 1)
//            }
//
//            is VkStatistics.Exchanges -> {
//                _exchanges.postValue((_exchanges.value ?: 0) + 1)
//            }
//
//            is VkStatistics.Comments -> {
//                _comments.postValue((_comments.value ?: 0) + 1)
//            }
//
//            is VkStatistics.Favorites -> {
//                _favorites.postValue((_favorites.value ?: 0) + 1)
//            }
//        }
//    }
}
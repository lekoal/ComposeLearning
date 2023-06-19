package com.private_projects.composelearning.domain

import com.private_projects.composelearning.R

data class FeedPost(
    val groupName: String = "Group name",
    val postTime: String = "10:00",
    val groupIcon: Int = R.drawable.post_comunity_thumbnail,
    val postText: String = "some random long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long text",
    val statistics: List<VkStatistics> = listOf(
        VkStatistics.Views,
        VkStatistics.Exchanges,
        VkStatistics.Comments,
        VkStatistics.Favorites
    )
)

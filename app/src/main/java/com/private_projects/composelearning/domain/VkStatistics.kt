package com.private_projects.composelearning.domain

import com.private_projects.composelearning.R

sealed class VkStatistics(
    val iconId: Int,
    var count: Int
) {
    object Views : VkStatistics(
        iconId = R.drawable.ic_views_count,
        count = 0
    )

    object Exchanges : VkStatistics(
        iconId = R.drawable.ic_share,
        count = 0
    )

    object Comments : VkStatistics(
        iconId = R.drawable.ic_comment,
        count = 0
    )

    object Favorites : VkStatistics(
        iconId = R.drawable.ic_like,
        count = 0
    )
}

package com.mynotes.core.navigation

import android.os.Bundle
import androidx.navigation.NavOptions

data class NavCommand(
    val target: DeepLink,
    val args: Bundle? = null,
    val navOptions: NavOptions? = null
)

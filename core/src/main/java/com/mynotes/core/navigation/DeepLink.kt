package com.mynotes.core.navigation

import android.net.Uri

data class DeepLink(
    val url: Uri,
    val isModal: Boolean,
    val isSingleTop: Boolean = false
)

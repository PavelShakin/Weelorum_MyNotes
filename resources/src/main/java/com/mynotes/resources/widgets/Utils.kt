package com.mynotes.resources.widgets

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.mynotes.resources.themes.ComposeDimens.WEIGHT_MAX

object Utils {

    @Composable
    fun SpacerVerticalView(value: Dp = 10.dp) {
        Spacer(modifier = Modifier.height(value))
    }

    @Composable
    fun ColumnScope.SpacerWeightView(value: Float = WEIGHT_MAX) {
        Spacer(modifier = Modifier.weight(value))
    }
}

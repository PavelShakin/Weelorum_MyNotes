package com.mynotes.resources.widgets

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mynotes.resources.themes.MyNotesTheme

object ButtonWidgets {

    @Composable
    fun ButtonWidget(
        onClick: () -> Unit,
        enabled: Boolean = false,
        text: String
    ) {
        Button(
            onClick = { onClick.invoke() },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            enabled = enabled,
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MyNotesTheme.colors.primaryColor
            )
        ) {
            Text(
                text = text,
                style = MyNotesTheme.typography.button
            )
        }
    }
}

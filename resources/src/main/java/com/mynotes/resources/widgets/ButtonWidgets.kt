package com.mynotes.resources.widgets

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.FloatingActionButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mynotes.resources.R
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
                backgroundColor = MyNotesTheme.colors.primaryColor,
                disabledBackgroundColor = MyNotesTheme.colors.disabledButtonColor,
            )
        ) {
            Text(
                text = text,
                style = MyNotesTheme.typography.button
            )
        }
    }

    @Composable
    fun ButtonAdd(
        onClick: () -> Unit
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            FloatingActionButton(
                onClick = {
                    onClick.invoke()
                },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(bottom = 20.dp, end = 20.dp),
                shape = RoundedCornerShape(10.dp),
                backgroundColor = MyNotesTheme.colors.primaryColor,
                elevation = FloatingActionButtonDefaults.elevation(0.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_add),
                    contentDescription = null,
                    tint = MyNotesTheme.colors.textColor
                )
            }
        }
    }
}

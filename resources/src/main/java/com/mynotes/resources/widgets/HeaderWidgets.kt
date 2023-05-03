package com.mynotes.resources.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mynotes.core.common.GlobalConstants.emptyString
import com.mynotes.resources.R
import com.mynotes.resources.extensions.clickableWithoutRipple
import com.mynotes.resources.themes.MyNotesTheme

object HeaderWidgets {

    @Composable
    fun DefaultTopHeader(
        title: String = emptyString,
        background: Color = MyNotesTheme.colors.primaryColor
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(background)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = title,
                    style = MyNotesTheme.typography.title
                )
            }
        }
    }

    @Composable
    fun TopHeaderWithDeleteButton(
        title: String = emptyString,
        background: Color = MyNotesTheme.colors.primaryColor,
        isDeleteButtonVisible: Boolean = false,
        onDeleteClick: () -> Unit
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(background)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    modifier = Modifier
                        .padding(start = 8.dp),
                    text = title,
                    style = MyNotesTheme.typography.title
                )
                if (isDeleteButtonVisible) {
                    Icon(
                        modifier = Modifier.clickableWithoutRipple {
                            onDeleteClick.invoke()
                        },
                        painter = painterResource(id = R.drawable.ic_delete),
                        contentDescription = null,
                        tint = MyNotesTheme.colors.textColor
                    )
                }
            }
        }
    }
}

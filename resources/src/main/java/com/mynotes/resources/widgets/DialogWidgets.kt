package com.mynotes.resources.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.mynotes.resources.extensions.clickableWithoutRipple
import com.mynotes.resources.themes.ComposeDimens.WEIGHT_MAX
import com.mynotes.resources.themes.MyNotesTheme
import com.mynotes.resources.widgets.Utils.SpacerVerticalView

object DialogWidgets {

    @Composable
    fun EmptyNoteAlertDialog(
        modifier: Modifier = Modifier
            .wrapContentSize()
            .padding(horizontal = 16.dp),
        title: String,
        subtitle: String,
        dismissText: String,
        confirmText: String,
        onDismissClick: () -> Unit,
        onConfirmClick: () -> Unit
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Dialog(
                onDismissRequest = { onDismissClick.invoke() }
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Surface(
                        modifier = modifier,
                        shape = RoundedCornerShape(14.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(horizontal = 24.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            SpacerVerticalView()
                            Text(
                                text = title,
                                style = MyNotesTheme.typography.alertTitle
                            )
                            SpacerVerticalView()
                            Text(
                                text = subtitle,
                                style = MyNotesTheme.typography.alertSubtitle,
                                textAlign = TextAlign.Center
                            )
                            SpacerVerticalView(16.dp)
                            Divider(
                                modifier = Modifier
                                    .padding(horizontal = 8.dp),
                                color = MyNotesTheme.colors.dividerColor,
                                thickness = 0.5.dp
                            )
                            SpacerVerticalView(16.dp)
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Column(
                                    modifier = Modifier
                                        .clickableWithoutRipple(
                                            onClick = { onDismissClick.invoke() }
                                        )
                                        .weight(WEIGHT_MAX),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    Text(
                                        text = dismissText,
                                        style = MyNotesTheme.typography.dismissButton
                                    )
                                }
                                Column(
                                    modifier = Modifier
                                        .clickableWithoutRipple(
                                            onClick = { onConfirmClick.invoke() }
                                        )
                                        .weight(WEIGHT_MAX),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    Text(
                                        text = confirmText,
                                        style = MyNotesTheme.typography.button
                                    )
                                }
                            }
                            SpacerVerticalView(16.dp)
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun DeleteNoteDialog(
        modifier: Modifier = Modifier
            .wrapContentSize()
            .padding(horizontal = 16.dp),
        title: String,
        subtitle: String,
        dismissText: String,
        confirmText: String,
        onDismissClick: () -> Unit,
        onConfirmClick: () -> Unit
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Dialog(
                onDismissRequest = { onDismissClick.invoke() }
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Surface(
                        modifier = modifier,
                        shape = RoundedCornerShape(14.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(horizontal = 24.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            SpacerVerticalView()
                            Text(
                                text = title,
                                style = MyNotesTheme.typography.alertTitle
                            )
                            SpacerVerticalView()
                            Text(
                                text = subtitle,
                                style = MyNotesTheme.typography.alertSubtitle,
                                textAlign = TextAlign.Center
                            )
                            SpacerVerticalView(16.dp)
                            Divider(
                                modifier = Modifier
                                    .padding(horizontal = 8.dp),
                                color = MyNotesTheme.colors.dividerColor,
                                thickness = 0.5.dp
                            )
                            SpacerVerticalView(16.dp)
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Column(
                                    modifier = Modifier
                                        .clickableWithoutRipple(
                                            onClick = { onDismissClick.invoke() }
                                        )
                                        .weight(WEIGHT_MAX),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    Text(
                                        text = dismissText,
                                        style = MyNotesTheme.typography.button
                                    )
                                }
                                Column(
                                    modifier = Modifier
                                        .clickableWithoutRipple(
                                            onClick = { onConfirmClick.invoke() }
                                        )
                                        .weight(WEIGHT_MAX),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    Text(
                                        text = confirmText,
                                        style = MyNotesTheme.typography.dismissButton
                                    )
                                }
                            }
                            SpacerVerticalView(16.dp)
                        }
                    }
                }
            }
        }
    }
}

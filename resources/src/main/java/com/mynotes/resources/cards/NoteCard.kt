package com.mynotes.resources.cards

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mynotes.core.models.view.NoteViewData
import com.mynotes.resources.themes.MyNotesTheme
import com.mynotes.resources.widgets.Utils.SpacerVerticalView

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NoteCard(
    note: NoteViewData,
    isSelected: Boolean = false,
    onNoteClick: (NoteViewData) -> Unit,
    onNoteLongClick: (NoteViewData) -> Unit
) {
    val background =
        if (isSelected) MyNotesTheme.colors.secondaryColor else MyNotesTheme.colors.backgroundColor
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .combinedClickable(
                onClick = { onNoteClick.invoke(note) },
                onLongClick = { onNoteLongClick.invoke(note) },
                indication = null,
                interactionSource = MutableInteractionSource()
            ),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(
            1.dp,
            MyNotesTheme.colors.borderStrokeColor
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(background)
        ) {
            Column(
                modifier = Modifier
                    .padding(20.dp)
            ) {
                Row(horizontalArrangement = Arrangement.Start) {
                    Text(
                        text = note.title,
                        style = MyNotesTheme.typography.title
                    )
                }
                SpacerVerticalView()
                Row(horizontalArrangement = Arrangement.Start) {
                    Text(
                        text = note.description,
                        style = MyNotesTheme.typography.description
                    )
                }
            }
        }
    }
}

package com.mynotes.resources.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mynotes.core.models.view.NoteViewData
import com.mynotes.resources.R
import com.mynotes.resources.cards.NoteCard
import com.mynotes.resources.themes.MyNotesTheme
import com.mynotes.resources.widgets.ButtonWidgets.ButtonAdd

@Composable
fun NotesListComponent(
    notes: List<NoteViewData> = emptyList(),
    onNoteClick: (NoteViewData) -> Unit,
    onCreateNoteClick: () -> Unit
) {
    val lazyListState = rememberLazyListState()
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        if (notes.isEmpty()) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(id = R.string.notes_empty_placeholder),
                    style = MyNotesTheme.typography.placeholder
                )
            }
        } else {
            LazyColumn(
                state = lazyListState,
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(items = notes) { item ->
                    NoteCard(
                        note = item,
                        onNoteClick = onNoteClick
                    )
                }
            }
        }
        ButtonAdd(onCreateNoteClick)
    }
}

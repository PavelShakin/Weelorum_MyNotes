package com.mynotes.core.navigation

import android.net.Uri

object NavRoutes {
    private const val pathUrl = "commynotes"

    private fun getPath(page: String): Uri {
        return Uri.parse("$pathUrl://$page")
    }

    fun getSplashPagePath(): Uri {
        return getPath(Page.splash)
    }

    fun getNotesPagePath(): Uri {
        return getPath(Page.notes)
    }

    fun getCreateNotePagePath(): Uri {
        return getPath(Page.createNote)
    }

    object Page {
        const val splash = "splash"
        const val notes = "notes"
        const val createNote = "createNote"
    }
}

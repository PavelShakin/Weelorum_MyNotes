package com.mynotes.core.navigation

interface NavigationProvider {
    fun launch(navCommand: NavCommand)
}
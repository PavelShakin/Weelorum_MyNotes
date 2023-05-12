package com.mynotes.android.screens.base

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import com.mynotes.core.navigation.NavCommand
import com.mynotes.core.navigation.NavigationProvider
import dagger.android.support.DaggerAppCompatActivity
import com.mynotes.android.R as mainR

class MainActivity : DaggerAppCompatActivity(), NavigationProvider {

    private val navController: NavController
        get() = findNavController(mainR.id.nav_host_fragment)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mainR.layout.activity_main)
    }

    override fun launch(navCommand: NavCommand) {
        val target = navCommand.target
        val navOptions = NavOptions.Builder()
            .setLaunchSingleTop(target.isSingleTop)
            .setPopUpTo(
                if (target.isSingleTop) mainR.id.application_nav_graph else DEFAULT_POP_UP_VALUE,
                inclusive = target.isSingleTop
            )
            .build()
        navController.navigate(target.url, navOptions)
    }

    companion object {
        private const val DEFAULT_POP_UP_VALUE = -1
    }
}

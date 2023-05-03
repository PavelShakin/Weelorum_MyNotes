package com.mynotes.android.screens.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mynotes.core.common.GlobalConstants.emptyString
import com.mynotes.core.navigation.NavRoutes
import com.mynotes.core.views.BaseFragment
import com.mynotes.core.views.utils.injectViewModel
import com.mynotes.resources.themes.AppTheme
import com.mynotes.resources.themes.MyNotesTheme

class SplashFragment : BaseFragment() {
    private val viewModel: SplashViewModel by lazy { injectViewModel(factory = providerFactory) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext())
            .apply {
                setViewCompositionStrategy(
                    ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed
                )
                setContent {
                    AppTheme {
                        Body()
                    }
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscriptions()
        viewModel.obtainEvent(SplashEvent.Load)
    }

    private fun subscriptions() {
        viewModel.viewActions().observe(viewLifecycleOwner) {
            when (it) {
                SplashAction.OnMyNotesScreen -> {
                    navigateToDeepLink(NavRoutes.getNotesPagePath(), isSingleTop = true)
                }
                SplashAction.OnCreateNoteScreen -> {
                    navigateToDeepLink(NavRoutes.getCreateNotePagePath(), isSingleTop = true)
                }
            }
        }
    }

    @Composable
    private fun Body() {
        Box(
            modifier = Modifier
                .background(MyNotesTheme.colors.primaryColor),
            contentAlignment = Alignment.BottomCenter
        ) {
            Column(
                Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.size(10.dp))
                SplashLogoImageView()
                Spacer(modifier = Modifier.size(10.dp))
            }
        }
    }

    @Composable
    private fun SplashLogoImageView() {
        Image(
            contentScale = ContentScale.FillWidth,
            painter = painterResource(com.mynotes.resources.R.drawable.ic_logo),
            contentDescription = emptyString
        )
    }
}

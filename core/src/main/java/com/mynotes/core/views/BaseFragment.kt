package com.mynotes.core.views

import android.content.Context
import android.net.Uri
import androidx.fragment.app.Fragment
import com.mynotes.core.contracts.dispatchers.ICoroutineDispatchers
import com.mynotes.core.navigation.DeepLink
import com.mynotes.core.navigation.NavCommand
import com.mynotes.core.navigation.navigate
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

/**
 * Base screen
 */
abstract class BaseFragment : Fragment() {

    @Inject
    lateinit var coroutineDispatcher: ICoroutineDispatchers

    @Inject
    lateinit var providerFactory: ViewModelFactory

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

    protected fun navigateToDeepLink(
        uri: Uri,
        isModal: Boolean = false,
        isSingleTop: Boolean = false
    ) {
        navigate(
            NavCommand(
                DeepLink(
                  url = uri,
                  isModal = isModal,
                  isSingleTop = isSingleTop
                )
            )
        )
    }
}
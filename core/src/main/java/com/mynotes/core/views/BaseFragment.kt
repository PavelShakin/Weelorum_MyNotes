package com.mynotes.core.views

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.fragment.app.Fragment
import com.mynotes.core.contracts.dispatchers.ICoroutineDispatchers
import dagger.android.support.AndroidSupportInjection
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

/**
 * Base screen
 */
abstract class BaseFragment : Fragment(), CoroutineScope {

    @Inject
    lateinit var coroutineDispatcher: ICoroutineDispatchers

    @Inject
    lateinit var providerFactory: ViewModelFactory
    private var job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + coroutineDispatcher.io
    protected val keyboardOptions = KeyboardOptions.Default.copy(
        capitalization = KeyboardCapitalization.Sentences,
        autoCorrect = false,
        keyboardType = KeyboardType.Text,
        imeAction = ImeAction.Next
    )

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setSoftInputMode()
    }

    private fun setSoftInputMode() {
        try {
            requireActivity().window.setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE
            )
        } catch (e: Exception) {
            Log.d("TAG", "setSoftInputMode:$e ")
        }
    }
}
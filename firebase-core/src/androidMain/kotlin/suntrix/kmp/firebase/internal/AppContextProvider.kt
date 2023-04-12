package suntrix.kmp.firebase.internal

import android.content.Context
import androidx.startup.Initializer

/**
 * Created by Sebastian Owodzin on 18/12/2020
 */

lateinit var _appContext: Context

internal class AppContextProvider : Initializer<Context> {
    override fun create(context: Context): Context = context.applicationContext.also { _appContext = it }
    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
package suntrix.kmp.firebase.core

import android.content.Context
import suntrix.kmp.firebase.core.internal._appContext

/**
 * Created by Sebastian Owodzin on 31/08/2020
 */
actual object Firebase {

    private var appContext: Context = _appContext
    internal fun appContextOverride(context: Context) {
        _appContext = context
    }

    actual val app: FirebaseApp?
        get() = try {
            FirebaseApp(com.google.firebase.FirebaseApp.getInstance())
        } catch (exception: IllegalStateException) {
            null
        }

    actual fun app(
        name: String
    ): FirebaseApp? = try {
        FirebaseApp(com.google.firebase.FirebaseApp.getInstance(name))
    } catch (exception: IllegalStateException) {
        null
    }

    actual val allApps: List<FirebaseApp>
        get() = com.google.firebase.FirebaseApp.getApps(appContext).map { FirebaseApp(it) }
}
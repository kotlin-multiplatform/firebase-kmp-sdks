package suntrix.kmp.firebase

import suntrix.kmp.firebase.internal._appContext

/**
 * Created by Sebastian Owodzin on 31/08/2020
 */
actual object Firebase {

    actual fun app(): FirebaseApp? = try {
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

    actual fun allApps(): List<FirebaseApp> =
        com.google.firebase.FirebaseApp.getApps(_appContext).map { FirebaseApp(it) }
}
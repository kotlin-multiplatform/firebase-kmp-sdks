package suntrix.kmp.firebase.core

/**
 * Created by Sebastian Owodzin on 31/08/2020
 */
actual object Firebase {

    actual fun app(): FirebaseApp? = FIRApp.defaultApp()?.run { FirebaseApp(this) }

    actual fun app(
        name: String
    ): FirebaseApp? = FIRApp.appNamed(name)?.run { FirebaseApp(this) }

    actual fun allApps(): List<FirebaseApp> =
        FIRApp.allApps.orEmpty().values.map { FirebaseApp(it as FIRApp) }
}
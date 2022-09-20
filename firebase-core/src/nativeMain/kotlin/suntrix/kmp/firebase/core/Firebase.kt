package suntrix.kmp.firebase.core

/**
 * Created by Sebastian Owodzin on 31/08/2020
 */
actual object Firebase {

    actual val app: FirebaseApp?
        get() = FIRApp.defaultApp()?.run { FirebaseApp(this) }

    actual fun app(
        name: String
    ): FirebaseApp? = FIRApp.appNamed(name)?.run { FirebaseApp(this) }

    actual val allApps: List<FirebaseApp>
        get() = FIRApp.allApps.orEmpty().values.map { FirebaseApp(it as FIRApp) }
}
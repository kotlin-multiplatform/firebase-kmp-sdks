package suntrix.kmp.firebase

/**
 * Created by Sebastian Owodzin on 31/08/2020
 */
actual class FirebaseApp internal constructor(val nativeSdk: FIRApp) {

    actual companion object {
        actual fun initialize(
            options: FirebaseOptions
        ): FirebaseApp = FIRApp.configureWithOptions(options.create()).run { Firebase.app()!! }

        actual fun initialize(
            name: String,
            options: FirebaseOptions
        ): FirebaseApp = FIRApp.configureWithName(name, options.create()).run { Firebase.app(name)!! }
    }

    actual val name: String
        get() = nativeSdk.name

    actual val options: FirebaseOptions
        get() = nativeSdk.options.run {
            FirebaseOptions(
                googleAppID,
                APIKey!!,
                GCMSenderID,
                databaseURL,
                trackingID,
                storageBucket,
                projectID
            )
        }

    actual fun delete() {
        nativeSdk.deleteApp {}
    }
}
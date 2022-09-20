package suntrix.kmp.firebase.core

import suntrix.kmp.firebase.core.internal._appContext

/**
 * Created by Sebastian Owodzin on 31/08/2020
 */
actual class FirebaseApp internal constructor(val nativeSdk: com.google.firebase.FirebaseApp) {

    actual companion object {
        actual fun initialize(
            options: FirebaseOptions
        ): FirebaseApp = com.google.firebase.FirebaseApp.initializeApp(_appContext, options.create())
            .run { FirebaseApp(this) }

        actual fun initialize(
            name: String,
            options: FirebaseOptions
        ): FirebaseApp =
            com.google.firebase.FirebaseApp.initializeApp(_appContext, options.create(), name)
                .run { FirebaseApp(this) }
    }

    actual val name: String
        get() = nativeSdk.name

    actual val options: FirebaseOptions
        get() = nativeSdk.options.run {
            FirebaseOptions(
                applicationId,
                apiKey,
                gcmSenderId!!,
                databaseUrl,
                gaTrackingId,
                storageBucket,
                projectId
            )
        }

    actual fun delete() {
        nativeSdk.delete()
    }
}
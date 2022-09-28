package suntrix.kmp.firebase.installations

import kotlinx.coroutines.tasks.await

/**
 * Created by Sebastian Owodzin on 25/09/2022
 */
actual class FirebaseInstallations internal constructor(val nativeSdk: com.google.firebase.installations.FirebaseInstallations) {

    actual suspend fun delete() {
        nativeSdk.delete().await()
    }

    actual suspend fun getId(): String = nativeSdk.id.await()

    actual suspend fun getToken(forceRefresh: Boolean): String =
        nativeSdk.getToken(forceRefresh).await().token
}
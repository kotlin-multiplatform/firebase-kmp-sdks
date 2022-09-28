package suntrix.kmp.firebase.installations

import kotlin.coroutines.await
import kotlin.coroutines.awaitResult

/**
 * Created by Sebastian Owodzin on 25/09/2022
 */
actual class FirebaseInstallations internal constructor(val nativeSdk: FIRInstallations) {

    actual suspend fun delete() {
        nativeSdk.await<FIRInstallations, FirebaseInstallationsException> { deleteWithCompletion(it) }
    }

    actual suspend fun getId(): String =
        nativeSdk.awaitResult<FIRInstallations, String, FirebaseInstallationsException> {
            installationIDWithCompletion(it)
        }

    actual suspend fun getToken(forceRefresh: Boolean): String =
        nativeSdk.awaitResult<FIRInstallations, FIRInstallationsAuthTokenResult, FirebaseInstallationsException> {
            authTokenForcingRefresh(
                forceRefresh,
                it
            )
        }.authToken
}
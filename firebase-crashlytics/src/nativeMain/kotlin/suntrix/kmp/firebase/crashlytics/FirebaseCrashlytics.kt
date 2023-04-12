package suntrix.kmp.firebase.crashlytics

import platform.Foundation.NSError
import platform.Foundation.NSLocalizedDescriptionKey
import platform.Foundation.NSUnderlyingErrorKey
import kotlin.coroutines.awaitResult

/**
 * Created by Sebastian Owodzin on 12/04/2023
 */
actual class FirebaseCrashlytics internal constructor(val nativeSdk: FIRCrashlytics) {

    actual suspend fun checkForUnsentReports(): Boolean? =
        nativeSdk.awaitResult<FIRCrashlytics, Boolean> { checkForUnsentReportsWithCompletion(it) }

    actual fun deleteUnsentReports() {
        nativeSdk.deleteUnsentReports()
    }

    actual fun didCrashOnPreviousExecution(): Boolean = nativeSdk.didCrashDuringPreviousExecution()

    actual fun log(message: String) {
        nativeSdk.log(message)
    }

    actual fun recordException(throwable: Throwable) {
        nativeSdk.recordError(
            NSError.errorWithDomain("suntrix.kmp.firebase.crashlytics.recordException", 0, mapOf(
                NSUnderlyingErrorKey to this,
                NSLocalizedDescriptionKey to throwable.message
            ))
        )
    }

    actual fun sendUnsentReports() {
        nativeSdk.sendUnsentReports()
    }

    actual fun setCrashlyticsCollectionEnabled(enabled: Boolean) {
        nativeSdk.setCrashlyticsCollectionEnabled(enabled)
    }

    actual fun setCustomKey(key: String, value: Any?) {
        when(value) {
            is Boolean -> nativeSdk.setCustomValue(value, key)
            is Double -> nativeSdk.setCustomValue(value, key)
            is Float -> nativeSdk.setCustomValue(value, key)
            is Int -> nativeSdk.setCustomValue(value, key)
            is Long -> nativeSdk.setCustomValue(value, key)
            is String -> nativeSdk.setCustomValue(value, key)
        }
    }

    actual fun setCustomKeys(keysAndValues: Map<String, Any?>) {
//        keysAndValues.forEach {
//            setCustomKey(it.key, it.value)
//        }
        nativeSdk.setCustomKeysAndValues(keysAndValues.toMap())
    }

    actual fun setUserId(identifier: String) {
        nativeSdk.setUserID(identifier)
    }
}
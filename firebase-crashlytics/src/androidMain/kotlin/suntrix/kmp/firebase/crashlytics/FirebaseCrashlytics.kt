package suntrix.kmp.firebase.crashlytics

import com.google.firebase.crashlytics.CustomKeysAndValues
import kotlinx.coroutines.tasks.await

/**
 * Created by Sebastian Owodzin on 12/04/2023
 */
actual class FirebaseCrashlytics internal constructor(val nativeSdk: com.google.firebase.crashlytics.FirebaseCrashlytics) {

    actual suspend fun checkForUnsentReports(): Boolean? = nativeSdk.checkForUnsentReports().await()

    actual fun deleteUnsentReports() {
        nativeSdk.deleteUnsentReports()
    }

    actual fun didCrashOnPreviousExecution(): Boolean = nativeSdk.didCrashOnPreviousExecution()

    actual fun log(message: String) {
        nativeSdk.log(message)
    }

    actual fun recordException(throwable: Throwable) {
        nativeSdk.recordException(throwable)
    }

    actual fun sendUnsentReports() {
        nativeSdk.sendUnsentReports()
    }

    actual fun setCrashlyticsCollectionEnabled(enabled: Boolean) {
        nativeSdk.setCrashlyticsCollectionEnabled(enabled)
    }

    actual fun setCustomKey(key: String, value: Any?) {
        when(value) {
            is Boolean -> nativeSdk.setCustomKey(key, value)
            is Double -> nativeSdk.setCustomKey(key, value)
            is Float -> nativeSdk.setCustomKey(key, value)
            is Int -> nativeSdk.setCustomKey(key, value)
            is Long -> nativeSdk.setCustomKey(key, value)
            is String -> nativeSdk.setCustomKey(key, value)
        }
    }

    actual fun setCustomKeys(keysAndValues: Map<String, Any?>) {
//        keysAndValues.forEach {
//            setCustomKey(it.key, it.value)
//        }
        nativeSdk.setCustomKeys(
            CustomKeysAndValues.Builder().apply {
                keysAndValues.forEach {
                    with(it) {
                        when(value) {
                            is Boolean -> putBoolean(key, value as Boolean)
                            is Double -> putDouble(key, value as Double)
                            is Float -> putFloat(key, value as Float)
                            is Int -> putInt(key, value as Int)
                            is Long -> putLong(key, value as Long)
                            is String -> putString(key, value as String)
                        }
                    }
                }
            }.build()
        )
    }

    actual fun setUserId(identifier: String) {
        nativeSdk.setUserId(identifier)
    }
}
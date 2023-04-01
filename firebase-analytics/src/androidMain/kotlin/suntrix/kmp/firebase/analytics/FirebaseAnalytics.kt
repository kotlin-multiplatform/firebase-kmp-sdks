package suntrix.kmp.firebase.analytics

import androidx.core.os.bundleOf
import kotlinx.coroutines.tasks.await
import kotlin.time.Duration

/**
 * Created by Sebastian Owodzin on 21/03/2023
 */
actual class FirebaseAnalytics internal constructor(val nativeSdk: com.google.firebase.analytics.FirebaseAnalytics) {

    actual suspend fun getAppInstanceId(): String? = nativeSdk.appInstanceId.await()

    actual fun logEvent(name: String, params: Map<String, Any>?) {
        nativeSdk.logEvent(name, params?.run { bundleOf(*toList().toTypedArray()) })
    }

    actual fun resetAnalyticsData() {
        nativeSdk.resetAnalyticsData()
    }

    actual fun setAnalyticsCollectionEnabled(enabled: Boolean) {
        nativeSdk.setAnalyticsCollectionEnabled(enabled)
    }

    actual fun setConsent(consentSettings: Map<ConsentType, ConsentStatus>) {
        nativeSdk.setConsent(consentSettings)
    }

    actual fun setDefaultEventParameters(params: Map<String, Any>?) {
        nativeSdk.setDefaultEventParameters(params?.run { bundleOf(*toList().toTypedArray()) })
    }

    actual fun setSessionTimeoutDuration(duration: Duration) {
        nativeSdk.setSessionTimeoutDuration(duration.inWholeMilliseconds)
    }

    actual fun setUserId(id: String?) {
        nativeSdk.setUserId(id)
    }

    actual fun setUserProperty(name: String, value: String?) {
        nativeSdk.setUserProperty(name, value)
    }
}
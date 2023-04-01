package suntrix.kmp.firebase.analytics

import kotlin.time.Duration

/**
 * Created by Sebastian Owodzin on 21/03/2023
 */
actual class FirebaseAnalytics internal constructor(val nativeSdk: FIRAnalytics) {

    actual suspend fun getAppInstanceId(): String? = FIRAnalytics.appInstanceID()

    actual fun logEvent(name: String, params: Map<String, Any>?) {
        FIRAnalytics.logEventWithName(name, params?.toMap())
    }

    actual fun resetAnalyticsData() {
        FIRAnalytics.resetAnalyticsData()
    }

    actual fun setAnalyticsCollectionEnabled(enabled: Boolean) {
        FIRAnalytics.setAnalyticsCollectionEnabled(enabled)
    }

    actual fun setConsent(consentSettings: Map<ConsentType, ConsentStatus>) {
        FIRAnalytics.setConsent(consentSettings.toMap())
    }

    actual fun setDefaultEventParameters(params: Map<String, Any>?) {
        FIRAnalytics.setDefaultEventParameters(params?.toMap())
    }

    actual fun setSessionTimeoutDuration(duration: Duration) {
        FIRAnalytics.setSessionTimeoutInterval(duration.inWholeSeconds.toDouble())
    }

    actual fun setUserId(id: String?) {
        FIRAnalytics.setUserID(id)
    }

    actual fun setUserProperty(name: String, value: String?) {
        FIRAnalytics.setUserPropertyString(value, name)
    }
}
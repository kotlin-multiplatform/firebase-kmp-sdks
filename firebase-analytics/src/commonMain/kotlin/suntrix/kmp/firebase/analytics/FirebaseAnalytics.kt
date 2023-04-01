package suntrix.kmp.firebase.analytics

import kotlin.time.Duration

/**
 * Created by Sebastian Owodzin on 21/03/2023
 */
expect class FirebaseAnalytics {
    suspend fun getAppInstanceId(): String?
    fun logEvent(name: String, params: Map<String, Any>?)
    fun resetAnalyticsData()
    fun setAnalyticsCollectionEnabled(enabled: Boolean)
    fun setConsent(consentSettings: Map<ConsentType, ConsentStatus>)
    fun setDefaultEventParameters(params: Map<String, Any>?)
    fun setSessionTimeoutDuration(duration: Duration)
    fun setUserId(id: String?)
    fun setUserProperty(name: String, value: String?)
}

fun FirebaseAnalytics.logEvent(event: Event) {
    logEvent(event.eventValue.nativeValue(), event.params())
}

fun FirebaseAnalytics.setUserProperty(userProperty: UserProperty) {
    setUserProperty(userProperty.userPropertyValue.nativeValue(), userProperty.value())
}
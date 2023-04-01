package suntrix.kmp.firebase.analytics

/**
 * Created by Sebastian Owodzin on 21/03/2023
 */
actual enum class ConsentType(val nativeValue: FIRConsentType) {
    AD_STORAGE(FIRConsentTypeAdStorage),
    ANALYTICS_STORAGE(FIRConsentTypeAnalyticsStorage)
}
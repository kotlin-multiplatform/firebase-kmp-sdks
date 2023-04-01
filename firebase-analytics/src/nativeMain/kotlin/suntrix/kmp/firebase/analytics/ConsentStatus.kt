package suntrix.kmp.firebase.analytics

/**
 * Created by Sebastian Owodzin on 21/03/2023
 */
actual enum class ConsentStatus(val nativeValue: FIRConsentStatus) {
    DENIED(FIRConsentStatusDenied),
    GRANTED(FIRConsentStatusGranted)
}
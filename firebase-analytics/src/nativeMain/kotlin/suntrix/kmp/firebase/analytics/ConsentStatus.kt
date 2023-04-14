package suntrix.kmp.firebase.analytics

import native.FirebaseAnalytics.FIRConsentStatus
import native.FirebaseAnalytics.FIRConsentStatusDenied
import native.FirebaseAnalytics.FIRConsentStatusGranted

/**
 * Created by Sebastian Owodzin on 21/03/2023
 */
actual enum class ConsentStatus(val nativeValue: FIRConsentStatus) {
    DENIED(FIRConsentStatusDenied),
    GRANTED(FIRConsentStatusGranted)
}
package suntrix.kmp.firebase.analytics.constants

import com.google.firebase.analytics.FirebaseAnalytics.UserProperty

/**
 * Created by Sebastian Owodzin on 21/03/2023
 */
actual enum class UserPropertyValue(private val nativeValue: String) {
    ALLOW_AD_PERSONALIZATION_SIGNALS(UserProperty.ALLOW_AD_PERSONALIZATION_SIGNALS),
    SIGN_UP_METHOD(UserProperty.SIGN_UP_METHOD);

    actual fun nativeValue() = nativeValue
}
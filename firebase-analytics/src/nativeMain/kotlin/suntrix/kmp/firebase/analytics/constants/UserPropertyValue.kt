package suntrix.kmp.firebase.analytics.constants

import suntrix.kmp.firebase.analytics.*

/**
 * Created by Sebastian Owodzin on 21/03/2023
 */
actual enum class UserPropertyValue(private val nativeValue: String) {
    ALLOW_AD_PERSONALIZATION_SIGNALS(kFIRUserPropertyAllowAdPersonalizationSignals!!),
    SIGN_UP_METHOD(kFIRUserPropertySignUpMethod!!);

    actual fun nativeValue() = nativeValue
}
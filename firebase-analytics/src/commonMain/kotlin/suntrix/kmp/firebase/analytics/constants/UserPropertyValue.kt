package suntrix.kmp.firebase.analytics.constants

/**
 * Created by Sebastian Owodzin on 21/03/2023
 */
expect enum class UserPropertyValue {
    ALLOW_AD_PERSONALIZATION_SIGNALS,
    SIGN_UP_METHOD;

    fun nativeValue(): String
}
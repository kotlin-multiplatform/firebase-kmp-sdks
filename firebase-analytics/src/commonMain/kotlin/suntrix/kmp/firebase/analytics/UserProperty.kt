package suntrix.kmp.firebase.analytics

import suntrix.kmp.firebase.analytics.constants.UserPropertyValue

/**
 * Created by Sebastian Owodzin on 21/03/2023
 */
sealed class UserProperty(val userPropertyValue: UserPropertyValue) {

    open fun value(): String? = null

    data class AllowAdPersonalizationSignals(
        val allow: Boolean
    ) : UserProperty(UserPropertyValue.ALLOW_AD_PERSONALIZATION_SIGNALS) {

        override fun value(): String = allow.toString()
    }

    data class SignUpMethod(
        val method: String
    ) : UserProperty(UserPropertyValue.SIGN_UP_METHOD) {

        override fun value(): String = method
    }
}
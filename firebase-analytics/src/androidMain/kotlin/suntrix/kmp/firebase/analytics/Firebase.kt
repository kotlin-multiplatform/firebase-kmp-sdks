package suntrix.kmp.firebase.analytics

import suntrix.kmp.firebase.Firebase
import suntrix.kmp.firebase.internal._appContext

/**
 * Created by Sebastian Owodzin on 21/03/2023
 */
actual val Firebase.analytics
    get() = FirebaseAnalytics(com.google.firebase.analytics.FirebaseAnalytics.getInstance(
        _appContext))
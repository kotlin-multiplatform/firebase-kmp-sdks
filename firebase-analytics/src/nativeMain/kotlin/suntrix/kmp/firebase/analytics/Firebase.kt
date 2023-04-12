package suntrix.kmp.firebase.analytics

import suntrix.kmp.firebase.Firebase

/**
 * Created by Sebastian Owodzin on 21/03/2023
 */
actual val Firebase.analytics: FirebaseAnalytics
    get() = FirebaseAnalytics(FIRAnalytics())
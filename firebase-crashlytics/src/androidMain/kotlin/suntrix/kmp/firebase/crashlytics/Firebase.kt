package suntrix.kmp.firebase.crashlytics

import suntrix.kmp.firebase.Firebase

/**
 * Created by Sebastian Owodzin on 12/04/2023
 */
actual val Firebase.crashlytics: FirebaseCrashlytics
    get() = FirebaseCrashlytics(com.google.firebase.crashlytics.FirebaseCrashlytics.getInstance())
package suntrix.kmp.firebase.crashlytics

import suntrix.kmp.firebase.FirebaseException

/**
 * Created by Sebastian Owodzin on 13/04/2023
 */
actual class FirebaseCrashlyticsException(message: String): FirebaseException(message)
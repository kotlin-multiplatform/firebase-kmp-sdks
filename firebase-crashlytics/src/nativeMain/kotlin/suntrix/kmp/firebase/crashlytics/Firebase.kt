package suntrix.kmp.firebase.crashlytics

import native.FirebaseCrashlytics.FIRCrashlytics
import suntrix.kmp.firebase.Firebase

/**
 * Created by Sebastian Owodzin on 12/04/2023
 */
actual val Firebase.crashlytics: FirebaseCrashlytics
    get() = FirebaseCrashlytics(FIRCrashlytics.crashlytics())
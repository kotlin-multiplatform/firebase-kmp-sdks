package suntrix.kmp.firebase.crashlytics

import suntrix.kmp.firebase.Firebase
import suntrix.kmp.firebase.FirebaseApp

/**
 * Created by Sebastian Owodzin on 12/04/2023
 */
expect val Firebase.crashlytics: FirebaseCrashlytics
//expect fun Firebase.crashlytics(app: FirebaseApp): FirebaseCrashlytics
package suntrix.kmp.firebase.appcheck

import native.FirebaseAppCheck.FIRAppCheck
import suntrix.kmp.firebase.Firebase

/**
 * Created by Sebastian Owodzin on 14/04/2023
 */
actual val Firebase.appCheck: FirebaseAppCheck
    get() = FirebaseAppCheck(FIRAppCheck.appCheck())
package suntrix.kmp.firebase.appcheck

import suntrix.kmp.firebase.Firebase

/**
 * Created by Sebastian Owodzin on 14/04/2023
 */
actual val Firebase.appCheck: FirebaseAppCheck
    get() = FirebaseAppCheck(com.google.firebase.appcheck.FirebaseAppCheck.getInstance())
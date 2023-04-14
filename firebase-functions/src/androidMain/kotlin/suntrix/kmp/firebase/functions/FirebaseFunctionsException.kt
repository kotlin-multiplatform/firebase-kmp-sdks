package suntrix.kmp.firebase.functions

import suntrix.kmp.firebase.FirebaseException

/**
 * Created by Sebastian Owodzin on 14/04/2023
 */
actual class FirebaseFunctionsException(message: String): FirebaseException(message)
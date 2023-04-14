package suntrix.kmp.firebase.messaging

import native.FirebaseMessaging.FIRMessaging
import suntrix.kmp.firebase.Firebase

/**
 * Created by Sebastian Owodzin on 14/04/2023
 */
actual val Firebase.messaging: FirebaseMessaging
    get() = FirebaseMessaging(FIRMessaging.messaging())
package suntrix.kmp.firebase.messaging

import suntrix.kmp.firebase.Firebase

/**
 * Created by Sebastian Owodzin on 14/04/2023
 */
actual val Firebase.messaging: FirebaseMessaging
    get() = FirebaseMessaging(com.google.firebase.messaging.FirebaseMessaging.getInstance())
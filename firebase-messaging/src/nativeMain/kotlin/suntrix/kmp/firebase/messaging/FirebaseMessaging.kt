package suntrix.kmp.firebase.messaging

import native.FirebaseMessaging.FIRMessaging

/**
 * Created by Sebastian Owodzin on 14/04/2023
 */
actual class FirebaseMessaging internal constructor(val nativeSdk: FIRMessaging) {

}
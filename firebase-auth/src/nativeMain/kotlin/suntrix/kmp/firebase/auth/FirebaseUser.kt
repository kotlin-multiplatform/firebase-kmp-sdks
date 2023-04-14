package suntrix.kmp.firebase.auth

import native.FirebaseAuth.FIRUser

/**
 * Created by Sebastian Owodzin on 02/10/2022
 */
actual class FirebaseUser internal constructor(val nativeSdk: FIRUser) {
    actual val uid: String
        get() = nativeSdk.uid
}
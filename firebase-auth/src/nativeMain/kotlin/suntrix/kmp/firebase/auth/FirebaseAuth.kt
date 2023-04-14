package suntrix.kmp.firebase.auth

import native.FirebaseAuth.FIRAuth

/**
 * Created by Sebastian Owodzin on 02/10/2022
 */
actual class FirebaseAuth internal constructor(val nativeSdk: FIRAuth) {
    actual val currentUser: FirebaseUser?
        get() = nativeSdk.currentUser?.run { FirebaseUser(this) }
}
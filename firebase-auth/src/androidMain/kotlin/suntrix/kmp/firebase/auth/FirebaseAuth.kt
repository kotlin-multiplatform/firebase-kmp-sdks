package suntrix.kmp.firebase.auth

/**
 * Created by Sebastian Owodzin on 02/10/2022
 */
actual class FirebaseAuth internal constructor(val nativeSdk: com.google.firebase.auth.FirebaseAuth) {
    actual val currentUser: FirebaseUser?
        get() = nativeSdk.currentUser?.run { FirebaseUser(this) }
}
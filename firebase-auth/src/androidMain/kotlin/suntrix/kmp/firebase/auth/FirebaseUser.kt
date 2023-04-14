package suntrix.kmp.firebase.auth

/**
 * Created by Sebastian Owodzin on 02/10/2022
 */
actual class FirebaseUser internal constructor(val nativeSdk: com.google.firebase.auth.FirebaseUser) {
    actual val uid: String
        get() = nativeSdk.uid
}
package suntrix.kmp.firebase.auth

import suntrix.kmp.firebase.Firebase
import suntrix.kmp.firebase.FirebaseApp

/**
 * Created by Sebastian Owodzin on 02/10/2022
 */
actual val Firebase.auth: FirebaseAuth
    get() = FirebaseAuth(com.google.firebase.auth.FirebaseAuth.getInstance())

actual fun Firebase.auth(app: FirebaseApp): FirebaseAuth =
    FirebaseAuth(com.google.firebase.auth.FirebaseAuth.getInstance(app.nativeSdk))
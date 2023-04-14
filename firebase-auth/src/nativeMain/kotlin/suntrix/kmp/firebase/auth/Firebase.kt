package suntrix.kmp.firebase.auth

import native.FirebaseAuth.FIRAuth
import suntrix.kmp.firebase.Firebase
import suntrix.kmp.firebase.FirebaseApp

/**
 * Created by Sebastian Owodzin on 02/10/2022
 */
actual val Firebase.auth: FirebaseAuth
    get() = FirebaseAuth(FIRAuth.auth())

actual fun Firebase.auth(app: FirebaseApp): FirebaseAuth
    = FirebaseAuth(FIRAuth.authWithApp(app.nativeSdk))
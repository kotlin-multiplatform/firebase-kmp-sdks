package suntrix.kmp.firebase.installations

import suntrix.kmp.firebase.Firebase
import suntrix.kmp.firebase.FirebaseApp

/**
 * Created by Sebastian Owodzin on 28/09/2022
 */
actual val Firebase.installations: FirebaseInstallations
    get() = FirebaseInstallations(com.google.firebase.installations.FirebaseInstallations.getInstance())

//actual fun Firebase.installations(app: FirebaseApp): FirebaseInstallations =
//    FirebaseInstallations(com.google.firebase.installations.FirebaseInstallations.getInstance(app.nativeSdk))
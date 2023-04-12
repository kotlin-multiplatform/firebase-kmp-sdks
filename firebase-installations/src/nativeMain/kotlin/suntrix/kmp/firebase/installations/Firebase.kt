package suntrix.kmp.firebase.installations

import suntrix.kmp.firebase.Firebase
import suntrix.kmp.firebase.FirebaseApp

/**
 * Created by Sebastian Owodzin on 28/09/2022
 */
actual val Firebase.installations
    get() = FirebaseInstallations(FIRInstallations.installations())

actual fun Firebase.installations(app: FirebaseApp) =
    FirebaseInstallations(FIRInstallations.installationsWithApp(app.nativeSdk))
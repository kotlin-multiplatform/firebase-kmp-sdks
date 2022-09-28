package suntrix.kmp.firebase.installations

import suntrix.kmp.firebase.core.Firebase
import suntrix.kmp.firebase.core.FirebaseApp

/**
 * Created by Sebastian Owodzin on 25/09/2022
 */
expect val Firebase.installations: FirebaseInstallations
expect fun Firebase.installations(app: FirebaseApp): FirebaseInstallations
package suntrix.kmp.firebase.auth

import suntrix.kmp.firebase.Firebase
import suntrix.kmp.firebase.FirebaseApp

/**
 * Created by Sebastian Owodzin on 02/10/2022
 */
expect val Firebase.auth: FirebaseAuth
expect fun Firebase.auth(app: FirebaseApp): FirebaseAuth
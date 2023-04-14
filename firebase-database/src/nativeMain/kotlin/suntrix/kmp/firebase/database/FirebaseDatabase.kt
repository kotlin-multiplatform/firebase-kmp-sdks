package suntrix.kmp.firebase.database

import native.FirebaseDatabase.FIRDatabase

/**
 * Created by Sebastian Owodzin on 14/04/2023
 */
actual class FirebaseDatabase internal constructor(val nativeSdk: FIRDatabase) {

}
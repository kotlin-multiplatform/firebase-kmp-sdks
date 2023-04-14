package suntrix.kmp.firebase.storage

import native.FirebaseStorage.FIRStorage

/**
 * Created by Sebastian Owodzin on 14/04/2023
 */
actual class FirebaseStorage internal constructor(val nativeSdk: FIRStorage) {

}
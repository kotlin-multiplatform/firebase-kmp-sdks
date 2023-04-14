package suntrix.kmp.firebase.storage

import suntrix.kmp.firebase.Firebase

/**
 * Created by Sebastian Owodzin on 14/04/2023
 */
actual val Firebase.storage: FirebaseStorage
    get() = FirebaseStorage(com.google.firebase.storage.FirebaseStorage.getInstance())
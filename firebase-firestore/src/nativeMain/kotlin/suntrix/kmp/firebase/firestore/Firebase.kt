package suntrix.kmp.firebase.firestore

import native.FirebaseFirestore.FIRFirestore
import suntrix.kmp.firebase.Firebase

/**
 * Created by Sebastian Owodzin on 14/04/2023
 */
actual val Firebase.firestore: FirebaseFirestore
    get() = FirebaseFirestore(FIRFirestore.firestore())
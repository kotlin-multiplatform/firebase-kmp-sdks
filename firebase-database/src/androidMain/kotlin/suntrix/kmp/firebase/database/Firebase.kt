package suntrix.kmp.firebase.database

import suntrix.kmp.firebase.Firebase

/**
 * Created by Sebastian Owodzin on 14/04/2023
 */
actual val Firebase.database: FirebaseDatabase
    get() = FirebaseDatabase(com.google.firebase.database.FirebaseDatabase.getInstance())
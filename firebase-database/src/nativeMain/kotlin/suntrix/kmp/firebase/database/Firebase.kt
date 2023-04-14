package suntrix.kmp.firebase.database

import native.FirebaseDatabase.FIRDatabase
import suntrix.kmp.firebase.Firebase

/**
 * Created by Sebastian Owodzin on 12/04/2023
 */
actual val Firebase.database: FirebaseDatabase
    get() = FirebaseDatabase(FIRDatabase.database())
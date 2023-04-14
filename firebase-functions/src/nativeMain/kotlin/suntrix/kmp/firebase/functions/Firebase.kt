package suntrix.kmp.firebase.functions

import native.FirebaseFunctions.FIRFunctions
import suntrix.kmp.firebase.Firebase

/**
 * Created by Sebastian Owodzin on 14/04/2023
 */
actual val Firebase.functions: FirebaseFunctions
    get() = FirebaseFunctions(FIRFunctions.functions())
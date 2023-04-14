package suntrix.kmp.firebase.performance

import native.FirebasePerformance.FIRPerformance
import suntrix.kmp.firebase.Firebase

/**
 * Created by Sebastian Owodzin on 14/04/2023
 */
actual val Firebase.performance: FirebasePerformance
    get() = FirebasePerformance(FIRPerformance.sharedInstance())
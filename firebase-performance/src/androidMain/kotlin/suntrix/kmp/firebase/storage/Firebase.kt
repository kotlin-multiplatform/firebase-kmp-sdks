package suntrix.kmp.firebase.performance

import suntrix.kmp.firebase.Firebase

/**
 * Created by Sebastian Owodzin on 14/04/2023
 */
actual val Firebase.performance: FirebasePerformance
    get() = FirebasePerformance(com.google.firebase.perf.FirebasePerformance.getInstance())
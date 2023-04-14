package suntrix.kmp.firebase.appdistribution

import suntrix.kmp.firebase.Firebase

/**
 * Created by Sebastian Owodzin on 14/04/2023
 */
actual val Firebase.appDistribution: FirebaseAppDistribution
    get() = FirebaseAppDistribution(com.google.firebase.appdistribution.FirebaseAppDistribution.getInstance())
package suntrix.kmp.firebase

/**
 * Created by Sebastian Owodzin on 31/08/2020
 */
data class FirebaseOptions(
    val applicationId: String,
    val apiKey: String,
    val gcmSenderId: String,
    val databaseUrl: String? = null,
    val gaTrackingId: String? = null,
    val storageBucket: String? = null,
    val projectId: String? = null
)
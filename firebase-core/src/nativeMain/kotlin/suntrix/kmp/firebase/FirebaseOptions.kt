package suntrix.kmp.firebase

/**
 * Created by Sebastian Owodzin on 31/08/2020
 */
internal fun FirebaseOptions.create(): FIROptions = FIROptions(applicationId, gcmSenderId).apply {
    APIKey = apiKey
    databaseURL = databaseUrl
    trackingID = gaTrackingId
    storageBucket = this@create.storageBucket
    projectID = projectId
}
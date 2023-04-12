package suntrix.kmp.firebase

import com.google.firebase.FirebaseOptions.Builder

/**
 * Created by Sebastian Owodzin on 31/08/2020
 */
internal fun FirebaseOptions.create(): com.google.firebase.FirebaseOptions = Builder()
    .setApplicationId(applicationId)
    .setApiKey(apiKey)
    .setDatabaseUrl(databaseUrl)
    .setGaTrackingId(gaTrackingId)
    .setGcmSenderId(gcmSenderId)
    .setStorageBucket(storageBucket)
    .setProjectId(projectId)
    .build()
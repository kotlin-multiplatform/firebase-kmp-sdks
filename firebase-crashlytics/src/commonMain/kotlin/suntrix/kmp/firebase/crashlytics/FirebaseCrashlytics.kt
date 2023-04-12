package suntrix.kmp.firebase.crashlytics

/**
 * Created by Sebastian Owodzin on 12/04/2023
 */
expect class FirebaseCrashlytics {
    suspend fun checkForUnsentReports(): Boolean?
    fun deleteUnsentReports()
    fun didCrashOnPreviousExecution(): Boolean
    fun log(message: String)
    fun recordException(throwable: Throwable)
    fun sendUnsentReports()
    fun setCrashlyticsCollectionEnabled(enabled: Boolean)
    fun setCustomKey(key: String, value: Any?)
    fun setCustomKeys(keysAndValues: Map<String, Any?>)
    fun setUserId(identifier: String)
}
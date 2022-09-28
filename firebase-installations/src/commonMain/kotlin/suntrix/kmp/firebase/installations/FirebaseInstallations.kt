package suntrix.kmp.firebase.installations

/**
 * Created by Sebastian Owodzin on 25/09/2022
 */
expect class FirebaseInstallations {
    suspend fun delete()
    suspend fun getId(): String
    suspend fun getToken(forceRefresh: Boolean): String
}
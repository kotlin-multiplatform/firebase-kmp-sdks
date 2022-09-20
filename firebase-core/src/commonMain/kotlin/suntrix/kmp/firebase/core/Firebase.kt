package suntrix.kmp.firebase.core

/**
 * Created by Sebastian Owodzin on 31/08/2020
 */
expect object Firebase {
    val app: FirebaseApp?
    fun app(name: String): FirebaseApp?
    val allApps: List<FirebaseApp>
}
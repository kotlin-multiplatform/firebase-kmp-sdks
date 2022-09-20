package suntrix.kmp.firebase.core

/**
 * Created by Sebastian Owodzin on 31/08/2020
 */
expect class FirebaseApp {

    companion object {
        fun initialize(options: FirebaseOptions): FirebaseApp
        fun initialize(name: String, options: FirebaseOptions): FirebaseApp
    }

    val name: String
    val options: FirebaseOptions
    fun delete()
}
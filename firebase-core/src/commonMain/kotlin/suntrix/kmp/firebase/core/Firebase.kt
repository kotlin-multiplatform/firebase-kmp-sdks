package suntrix.kmp.firebase.core

/**
 * Created by Sebastian Owodzin on 31/08/2020
 */
expect object Firebase {

    @Throws(IllegalStateException::class)
    fun app(): FirebaseApp?

    @Throws(IllegalStateException::class)
    fun app(name: String): FirebaseApp?

    fun allApps(): List<FirebaseApp>
}

fun Firebase.initialize(options: FirebaseOptions): FirebaseApp = FirebaseApp.initialize(options)

@Throws(IllegalStateException::class)
fun Firebase.initialize(name: String, options: FirebaseOptions): FirebaseApp =
    FirebaseApp.initialize(name, options)
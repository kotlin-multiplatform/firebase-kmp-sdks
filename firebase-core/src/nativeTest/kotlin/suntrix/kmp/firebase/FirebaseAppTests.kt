package suntrix.kmp.firebase

import kotlin.test.*

/**
 * Created by Sebastian Owodzin on 24/09/2022
 */
class FirebaseAppTests {

    val firebaseOptions: FirebaseOptions = FirebaseOptions(
        applicationId = "1:1075952258191:ios:1c6b1e33716d94a38774fa",
        apiKey = "AIzaSyA8DyHw9t3tExWHbv_BHsIMvQSjLLR2Fz4",
        gcmSenderId = "1075952258191",
        databaseUrl = null,
        gaTrackingId = null,
        storageBucket = "suntrix-firebase-multiplatform.appspot.com",
        projectId = "suntrix-firebase-multiplatform"
    )

    @Test
    fun initializeDefaultAppWithOptions() {
        assertNull(Firebase.app())

        val app = FirebaseApp.initialize(options = firebaseOptions)

        assertTrue(Firebase.allApps().isNotEmpty())
        assertNotNull(Firebase.app())

        assertEquals("__FIRAPP_DEFAULT", app.name)
        assertEquals(firebaseOptions, app.options)
    }

    @Test
    fun initializeCustomAppWithOptions() {
        assertNull(Firebase.app(name = "custom"))

        val app = FirebaseApp.initialize(name = "custom", options = firebaseOptions)

        assertTrue(Firebase.allApps().isNotEmpty())
        assertNotNull(Firebase.app(name = "custom"))

        assertEquals("custom", app.name)
        assertEquals(firebaseOptions, app.options)
    }
}
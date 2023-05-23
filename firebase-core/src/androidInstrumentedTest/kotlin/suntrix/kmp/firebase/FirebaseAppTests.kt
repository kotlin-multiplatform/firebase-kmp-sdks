package suntrix.kmp.firebase

import kotlin.test.*

/**
 * Created by Sebastian Owodzin on 24/09/2022
 */
class FirebaseAppTests {

    val firebaseOptions: FirebaseOptions = FirebaseOptions(
        applicationId = "1:1075952258191:android:36bcba02e112ff918774fa",
        apiKey = "AIzaSyDRzb7izP4s3UFs7HJ8CDqSG3oPTNm_j08",
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

        assertEquals("[DEFAULT]", app.name)
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
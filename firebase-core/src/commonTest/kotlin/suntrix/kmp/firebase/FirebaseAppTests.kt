package suntrix.kmp.firebase

import kotlin.test.*

/**
 * Created by Sebastian Owodzin on 17/09/2022
 */
//expect val firebaseOptions: FirebaseOptions
//expect val defaultAppName: String
//
//class FirebaseAppTests {
//
//    @Test
//    fun initializeDefaultAppWithOptions() {
//        assertNull(Firebase.app())
//
//        val app = FirebaseApp.initialize(options = firebaseOptions)
//
//        assertTrue(Firebase.allApps().isNotEmpty())
//        assertNotNull(Firebase.app())
//
//        assertEquals(defaultAppName, app.name)
//        assertEquals(firebaseOptions, app.options)
//    }
//
//    @Test
//    fun initializeCustomAppWithOptions() {
//        assertNull(Firebase.app(name = "custom"))
//
//        val app = FirebaseApp.initialize(name = "custom", options = firebaseOptions)
//
//        assertTrue(Firebase.allApps().isNotEmpty())
//        assertNotNull(Firebase.app(name = "custom"))
//
//        assertEquals("custom", app.name)
//        assertEquals(firebaseOptions, app.options)
//    }
//}
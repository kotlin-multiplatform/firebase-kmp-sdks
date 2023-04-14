package suntrix.kmp.firebase.remoteconfig

import native.FirebaseRemoteConfig.FIRRemoteConfig
import suntrix.kmp.firebase.Firebase

/**
 * Created by Sebastian Owodzin on 14/04/2023
 */
actual val Firebase.remoteConfig: FirebaseRemoteConfig
    get() = FirebaseRemoteConfig(FIRRemoteConfig.remoteConfig())
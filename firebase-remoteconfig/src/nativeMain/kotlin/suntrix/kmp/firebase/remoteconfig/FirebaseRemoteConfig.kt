package suntrix.kmp.firebase.remoteconfig

import native.FirebaseRemoteConfig.FIRRemoteConfig

/**
 * Created by Sebastian Owodzin on 14/04/2023
 */
actual class FirebaseRemoteConfig internal constructor(val nativeSdk: FIRRemoteConfig) {

}
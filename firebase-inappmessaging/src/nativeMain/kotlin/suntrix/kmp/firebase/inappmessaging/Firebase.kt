package suntrix.kmp.firebase.inappmessaging

import native.FirebaseInAppMessaging.FIRInAppMessaging
import suntrix.kmp.firebase.Firebase

/**
 * Created by Sebastian Owodzin on 14/04/2023
 */
actual val Firebase.inAppMessaging: FirebaseInAppMessaging
    get() = FirebaseInAppMessaging(FIRInAppMessaging.inAppMessaging())
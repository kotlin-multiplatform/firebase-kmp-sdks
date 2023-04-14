package suntrix.kmp.firebase.inappmessaging

import suntrix.kmp.firebase.Firebase

/**
 * Created by Sebastian Owodzin on 14/04/2023
 */
actual val Firebase.inAppMessaging: FirebaseInAppMessaging
    get() = FirebaseInAppMessaging(com.google.firebase.inappmessaging.FirebaseInAppMessaging.getInstance())
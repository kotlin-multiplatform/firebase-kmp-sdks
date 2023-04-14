package suntrix.kmp.firebase.dynamiclinks

import suntrix.kmp.firebase.Firebase

/**
 * Created by Sebastian Owodzin on 14/04/2023
 */
actual val Firebase.dynamicLinks: FirebaseDynamicLinks
    get() = FirebaseDynamicLinks(com.google.firebase.dynamiclinks.FirebaseDynamicLinks.getInstance())
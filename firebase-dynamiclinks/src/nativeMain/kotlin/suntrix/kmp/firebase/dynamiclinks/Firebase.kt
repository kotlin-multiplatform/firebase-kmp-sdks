package suntrix.kmp.firebase.dynamiclinks

import native.FirebaseDynamicLinks.FIRDynamicLinks
import suntrix.kmp.firebase.Firebase

/**
 * Created by Sebastian Owodzin on 12/04/2023
 */
actual val Firebase.dynamicLinks: FirebaseDynamicLinks
    get() = FirebaseDynamicLinks(FIRDynamicLinks.dynamicLinks())
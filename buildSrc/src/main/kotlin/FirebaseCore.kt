/**
 * Created by Sebastian Owodzin on 02/04/2023
 */
fun firebaseCoreFrameworks(): List<String> {
    val firebaseCoreFrameworks = listOf(
        "FirebaseCore",
        "GoogleUtilities"
    )

    val firebaseCoreDiagnosticsFrameworks = listOf(
        "FirebaseCoreDiagnostics",
        "GoogleDataTransport",
        "GoogleUtilities",
        "nanopb"
    )

    return firebaseCoreFrameworks.plus(firebaseCoreDiagnosticsFrameworks)

//    return listOf(
//        "FirebaseAnalytics",
//        "FirebaseCore",
//        "FirebaseCoreDiagnostics",
//        "FirebaseInstallations",
//        "GoogleAppMeasurement",
//        "GoogleAppMeasurementIdentitySupport",
//        "GoogleDataTransport",
//        "GoogleUtilities",
//        "nanopb",
//        "PromisesObjC"
//    )
}
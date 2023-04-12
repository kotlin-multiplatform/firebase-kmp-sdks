package kotlin.coroutines

import platform.Foundation.NSError

/**
 * Created by Sebastian Owodzin on 28/09/2022
 */
@Suppress("UNCHECKED_CAST")
suspend inline fun <T, E : Throwable> T.await(crossinline function: T.(callback: (NSError?) -> Unit) -> Unit) =
    suspendCoroutine { continuation ->
        function { error ->
            if (error == null) {
                continuation.resume(Unit)
            } else {
                continuation.resumeWithException(Exception(error.toString()) as E)
            }
        }
    }

@Suppress("UNCHECKED_CAST")
suspend inline fun <T, reified R> T.awaitResult(crossinline function: T.(callback: (R?) -> Unit) -> Unit): R =
    suspendCoroutine { continuation ->
        function { result ->
            continuation.resume(result as R)
        }
    }

@Suppress("UNCHECKED_CAST")
suspend inline fun <T, reified R, E : Throwable> T.awaitResult(crossinline function: T.(callback: (R?, NSError?) -> Unit) -> Unit): R =
    suspendCoroutine { continuation ->
        function { result, error ->
            if (error == null) {
                continuation.resume(result as R)
            } else {
                continuation.resumeWithException(Exception(error.toString()) as E)
            }
        }
    }
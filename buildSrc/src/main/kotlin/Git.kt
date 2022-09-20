import org.ajoberstar.grgit.Grgit
import org.ajoberstar.grgit.operation.DescribeOp
import org.ajoberstar.grgit.operation.LogOp
import java.io.File

/**
 * Created by Sebastian Owodzin on 23/06/2020
 */
class Git(
    dir: File,
    private val branchName: String = "origin/master"
) {

    private val git = Grgit.open {
        setDir(dir)
    }

    private val logOp by lazy {
        LogOp(git.repository).apply { includes = listOf(branchName) }.call()
    }

    fun versionCode(adjustment: Int? = null): Int {
        var result = adjustment ?: 1

        try {
            result += logOp.size
        } catch (ex: RuntimeException) {
            println("GIT::versionCode - error: $ex")
        }

        println("GIT::versionCode: $result")

        return result
    }

    val versionName: String
        get() {
            var result = "0.1.0"

            try {
                result = DescribeOp(git.repository).apply { tags = true }.call()
            } catch (ex: RuntimeException) {
                result += try {
                    with(logOp) { "-${size}-${first().abbreviatedId}" }
                } catch (ex: RuntimeException) {
                    println("GIT::versionName - error: $ex")

                    "-snapshot"
                }
            }

            println("GIT::versionName: $result")

            return result
        }
}
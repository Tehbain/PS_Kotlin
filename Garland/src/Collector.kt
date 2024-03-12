import java.io.File
import java.net.URI

class Collector () {
    private class fileRef (val uri: URI) {
        constructor (path: String) : this(uri = URI.create(path))
    }

    private val _files: MutableList<File> = mutableListOf()
    val files: List<File>
        get() = _files
        fun addFile() {

        }


        fun removeFile(file: File) = _files.remove(file)


}
import spock.lang.Specification
import task.files.FileLoader

class FileLoaderTest extends Specification
{
    void "test loading file from resources folder"()
    {
        given:
        FileLoader fileLoader = new FileLoader()

        when:
        fileLoader.loadFileFromResourcePath("fileTest.txt")

        then:
        fileLoader != null
    }
}

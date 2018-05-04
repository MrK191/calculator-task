package task.files;

import java.io.File;

public class FileLoader
{
    public File loadFileFromResourcePath(String fileName){
        ClassLoader classLoader = FileLoader.class.getClassLoader();
        return new File(classLoader.getResource(fileName).getFile());
    }
}

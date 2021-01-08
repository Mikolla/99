package algs;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Рекурсивный обход дерева в глубину, поиск файлов в папке (и вложенных папках)
 */

public class SearchFilesOnDisk
{
    public void searchFiles(File rootFile, List<File> fileList)
    {
        if (rootFile.isDirectory())
        {
            File[] files = rootFile.listFiles();
            for (File file : files)
            {
                if (file.isDirectory())
                {
                    searchFiles(file, fileList);
                }
                else
                {
                    fileList.add(file);
                }
            }
        }
    }
    //home/nbondarenko
    public static void main(String[] args)
    {
        File file = new File("/home/nbondarenko/testFolder");
        boolean exists = file.exists();
        boolean directory = file.isDirectory();
        SearchFilesOnDisk searchFilesOnDisk = new SearchFilesOnDisk();
        List<File> list = new ArrayList<>();
        searchFilesOnDisk.searchFiles(file, list);
        System.out.println();
    }
}

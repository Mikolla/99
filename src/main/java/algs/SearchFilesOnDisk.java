package algs;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Рекурсивный обход дерева в глубину, получение списка файлов в папке (и вложенных папках), подсчет размера папки
 * вместе с вложенными фалами и папками
 */

public class SearchFilesOnDisk
{
    /**
     * Получение спска вложенных файлов в папку
     * @param rootFile папка, в которой могут находиться вложенные файлы
     * @return список вложенных файло в папку
     */
    public List<File> searchFiles(File rootFile)
    {
        List<File> fileList = new ArrayList<>();
        if (rootFile.isDirectory())
        {
            File[] files = rootFile.listFiles();
            for (File file : files)
            {
                if (file.isDirectory())
                {
                    fileList.addAll(searchFiles(file));
                }
                else
                {
                    fileList.add(file);
                }
            }
        }
        return fileList;
    }

    /**
     * Получение списка вложенных файлов в папке
     * @param rootFile папка, где могут быть вложенные файлы
     * @param fileList список файлов
     */
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

    /**
     * Посчет размера папки с вложенными файлами и папками
     * @param rootFile папка, в которой могут находиться вложенные файлы и папки
     * @return суммарный размер файлов в папке
     */
    public Long getFolderSize(File rootFile){
        long size = 0L;
        if (rootFile.isDirectory())
        {
            File[] files = rootFile.listFiles();
            for (File file : files)
            {
                if (file.isDirectory())
                {
                    long l = getFolderSize(file);
                    size = size + l;
                }
                else
                {
                    size = size + file.length();
                }
            }
        }
        return size;
    }

    public static void main(String[] args)
    {
        File file = new File("/home/nbondarenko/testFolder");
        boolean exists = file.exists();
        boolean directory = file.isDirectory();
        SearchFilesOnDisk searchFilesOnDisk = new SearchFilesOnDisk();

        List<File> list = searchFilesOnDisk.searchFiles(file);
        Optional<String> resultStr = list.stream().map(f -> f.toString()).reduce((x, y) -> x + " \r\n" + y);
        System.out.println("------searchFiles(file)------");
        System.out.println(resultStr.orElse("empty"));

        List<File> list1 = new ArrayList<>();
        searchFilesOnDisk.searchFiles(file, list1);
        System.out.println("------searchFiles(file, list1)------");
        Optional<String> resultStr1 = list1.stream().map(f -> f.toString()).reduce((x, y) -> x + " \r\n" + y);
        System.out.println(resultStr1.orElse("empty"));

        System.out.println("files takes memory bytes = " + list.stream().mapToLong(x -> x.length()).sum());
        System.out.println(searchFilesOnDisk.getFolderSize(file));
    }
}

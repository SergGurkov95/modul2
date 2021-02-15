import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Searcher {


    public static List<String> searchByName(List<File> list, String key) {
        List<String> searchResult = new ArrayList<>();

        for (File file : list) {
            if (file.isDirectory()) {
                List<File> nestList = Arrays.asList(file.listFiles());
                searchResult.addAll(searchByName(nestList, key));
            } else if (file.getName().equals(key)) {
                searchResult.add(file.getAbsolutePath());
            }
        }
        return searchResult;
    }

    public static List<String> searchByDirectory(List<File> list, String key) {
        List<String> searchResult = new ArrayList<>();
        for (File file : list) {
            if (file.isDirectory()) {
                if (file.getName().equals(key)) {
                    searchResult.add(file.getAbsolutePath());
                }
                List<File> nestList = Arrays.asList(file.listFiles());
                searchResult.addAll(searchByDirectory(nestList, key));
            }
        }
        return searchResult;
    }

    public static List<String> searchBySize(List<File> list, String keyMax, String keyMin) {
        List<String> searchResult = new ArrayList<>();

        for (File file : list) {
            if (file.isDirectory()) {
                List<File> nestList = Arrays.asList(file.listFiles());
                searchResult.addAll(searchBySize(nestList, keyMax, keyMin));
            } else if ((file.length() <= Integer.parseInt(keyMax)) && (file.length() >= Integer.parseInt(keyMin))) {
                searchResult.add(file.getAbsolutePath());
            }
        }
        return searchResult;
    }

    public static List<String> searchByText(List<File> list, String key) {
        List<String> searchResult = new ArrayList<>();

        for (File file : list) {
            if (file.isDirectory()) {
                List<File> nestList = Arrays.asList(file.listFiles());
                searchResult.addAll(searchByText(nestList, key));
            } else if (getFileExtension(file).equals("txt")) {
                try {
                    List<String> strList = Files.readAllLines(Paths.get(file.getAbsolutePath()));
                    for(String str : strList){
                        if(str.contains(key)){
                            searchResult.add(file.getAbsolutePath());
                            break;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return searchResult;
    }

    private static String getFileExtension(File file) {
        String fileName = file.getName();
        if ((fileName.lastIndexOf(".") != -1) && (fileName.lastIndexOf(".") != 0)) {
            return fileName.substring(fileName.lastIndexOf("." + 1));
        } else return "";
    }
}

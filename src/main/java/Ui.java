import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ui implements FieldOfSearching {
    private File dir = setDirectory();
    private List<File> list = Arrays.asList(dir.listFiles());
    private String key;
    private String keySizeMin;
    // private List<String> = typeOfSearch();

    List<String> search() {
        for (; ; ) {
            System.out.println("Введите тип поиска(name/regEx/dir/size/text): ");
            Scanner scanner = new Scanner(System.in);
            String type = scanner.nextLine();
            if (type.equals("name")) {
                key = setName();
                return Searcher.searchByName(list, key);
            } else if (type.equals("regEx")) {

                System.out.println("этого ункционала еще нет");;
            } else if (type.equals("dir")) {
                key = setDir();
                return Searcher.searchByDirectory(list, key);
            } else if (type.equals("size")) {

                String[] str = setSize();
                key = str[0];
                keySizeMin = str[1];
                return Searcher.searchBySize(list, key, keySizeMin);
            } else if (type.equals("text")) {
                System.out.println("этот функциона забагован");

                key = setText();
                return Searcher.searchByText(list, key);
            } else {
                System.out.println("Некорректный ввод!");
            }
        }

    }


    @Override
    public String setName() {
        System.out.println("Введите имя и расширене искомого файла: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        return name;
    }

    @Override
    public String setDir() {
        System.out.println("Введите имя папки: ");
        Scanner scanner = new Scanner(System.in);
        String dir = scanner.nextLine();
        return dir;
    }

    @Override
    public String[] setSize() {
        System.out.println("Введите максимальный раземр файла: ");
        Scanner scanner = new Scanner(System.in);
        String[] size = new String[2];
        size[0] = scanner.nextLine();
        System.out.println("Введите минималное раземер файла: ");
        size[1] = scanner.nextLine();
        return size;
    }

    @Override
    public String setText() {
        System.out.println("Введите строку: ");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        return text;
    }

    public File getDir() {
        return dir;
    }

    public String getName() {
        return key;
    }



}

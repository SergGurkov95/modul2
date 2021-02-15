
import java.util.List;


public class Main {
    public static void main(String[] args) {


        Ui ui = new Ui();

        List<String> result = ui.search();


        if (result.size() == 0) {
            System.out.println("Файлы не найдены!");
        } else {
            for (String file : result) {
                System.out.println(file);
            }
        }
    }
}

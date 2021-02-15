import java.io.File;
import java.util.Scanner;

public interface FieldOfSearching {

   default File setDirectory(){
        System.out.println("Введите путь к месту поиска: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if(input.equals("")){
            input = System.getProperty("user.dir");
        }
        return new File(input);
    }

    String setName();

    String setDir();

    String[] setSize();

    String setText();




}

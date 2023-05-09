import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Reader {
    private File file;
    private int gameNumber = 0;
    private String path = "";
    Reader(String path) {
        this.path = path;
        try {
            this.file = new File("Result.txt");
            if (file.createNewFile())
                System.out.println("Файл создан!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int findNumb() {
        try {
            FileReader reader = new FileReader(path);
            Scanner scan = new Scanner(reader);
            while (scan.hasNextLine()) {
                if (scan.nextLine().contains("№"))
                    gameNumber++;
            }
            reader.close();
            return gameNumber;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Reader {
    private int gameNumber;
    private String path = "";
    private FileReader reader;
    Reader(String path) {
        this.path = path;
    }

    public int findNumb() {
        try {
            reader = new FileReader(path);
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

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Writer implements ISpellCheck {
    private int count = 0;
    private String path = "";
    private FileWriter writer;
    Writer(String path) {
        this.path = path;
    }
    public void writeStart(int gameNumb, Line comp) {
        try {
            writer = new FileWriter(path, true);
            Date curDate = new Date();
            SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy HH:mm");
            System.out.print("Game №" + gameNumb + " " + formatForDateNow.format(curDate));
            System.out.println(" Загаданная строка " + comp);
            writer.write("Game №" + gameNumb + " " + formatForDateNow.format(curDate));
            writer.write(" Загаданная строка " + comp + "\n");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void writeGameStep(Line player, Game game) {
        try {
            FileWriter writer = new FileWriter("Result.txt", true);
            count++;
            System.out.print("  Запрос: " + player + " Ответ: " + game);
            writer.write("  Запрос: " + player + " Ответ: " + game);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void writeResult() {
        try {
            FileWriter writer = new FileWriter("Result.txt", true);
            System.out.print("  Строка была угадана за " + count + " " + checkSpells("попыток.\n"));
            writer.write("  Строка была угадана за " + count + " " + checkSpells("попыток.\n"));
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String checkSpells(String str) {
        if (count % 10 == 1 && count % 100 != 11)
            str = "попытку.\n";
        else if (count % 10 >= 2 && count % 10 <= 4
                && (count % 100 < 12 || count % 100 > 14))
            str = "попытки.\n";
        return str;
    }
}
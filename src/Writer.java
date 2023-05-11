import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Writer implements ISpellCheck {
    private int count = 0;
    private String path = "";
    private String result = "";
    private File file;
    Writer(String path) {
        this.path = path;
        try {
            file = new File("Result.txt");
            if (file.createNewFile())
                System.out.println("Файл создан!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void writeStart(int gameNumb, Line comp) {
        Date curDate = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        System.out.print("Game №" + gameNumb + " " + formatForDateNow.format(curDate));
        System.out.println(" Загаданная строка " + comp);
        result += "Game №" + gameNumb + " " + formatForDateNow.format(curDate);
        result += " Загаданная строка " + comp + "\n";
    }
    public void writeGameStep(Line player, Game game) {
        count++;
        System.out.print("  Запрос: " + player + " Ответ: " + game);
        result += "  Запрос: " + player + " Ответ: " + game;
    }
    public void writeResult() {
        try {
            FileWriter writer = new FileWriter("Result.txt", true);
            System.out.print("  Строка была угадана за " + count + " " + checkSpells("попыток.\n"));
            writer.write(result);
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
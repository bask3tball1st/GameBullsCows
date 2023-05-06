import org.jetbrains.annotations.NotNull;

import java.io.FileWriter;
import java.io.IOException;

public class Game implements ISpellCheck, IWrite {
    int cows = 0, bulls = 0;
    Game() { }
    public void compareStr(@NotNull Line comp, @NotNull Line player) {
        this.cows = 0;
        this.bulls = 0;
        comp.setStr(comp.word);
        player.setStr(player.word);
        for (int i = 0; i < 4; i++) {
            if (comp.str[i] == player.str[i]) {
                this.bulls++;
                comp.str[i] = -1;
                player.str[i] = -1;
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i != j && comp.str[i] == player.str[j] && comp.str[i] != -1) {
                    this.cows++;
                    comp.str[i] = -1;
                    player.str[j] = -1;
                }
            }
        }
    }
    //доделать
    public String checkSpells() {
        String bull = "быка";
        String cow = "коровы";
        if (cows == 1)
            return "корова";
        else if (cows == 0)
            return "коров";
        else if (bulls == 1)
            return "бык";
        else if (bulls == 0)
            return "быков";
        return null;
    }
    public void write(Line player) {
        try {
            FileWriter writer = new FileWriter("Result.txt", true);
            writer.write("Запрос: " + player + " Ответ: " + this);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return cows + " " + checkSpells() + " " +
                bulls + " " + checkSpells() + "\n";
    }
}

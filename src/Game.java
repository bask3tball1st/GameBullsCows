public class Game implements ISpellCheck {
    private int cows = 0, bulls = 0;
    Game() { }
    public void compareStr(Line comp, Line player) {
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
    public boolean checkRes() {
        return this.bulls == 4 ? true : false;
    }
    public String checkSpells(String str) {
        //TODO со строками никогда не используй == , используй equals
        if (str == "коровы") {
            if (cows == 1)
                str = "корова";
            else if (cows == 0)
                str = "коров";
        }
        else if (str == "быка") {
            if (bulls == 1)
                str = "бык";
            else if (bulls == 0)
                str = "быков";
        }
        return str;
    }
    @Override
    public String toString() {
        return cows + " " + checkSpells("коровы") + " " +
                bulls + " " + checkSpells("быка") + "\n";
    }
}

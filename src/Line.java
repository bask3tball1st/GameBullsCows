import org.jetbrains.annotations.NotNull;

public class Line implements IRandom {
    String word = "";
    int [] str = new int[4];
    public Line() {

    };

    public void setStr(@NotNull String str) {
        String []temp = str.split("");
        for (int i = 0 ; i < 4; i++)
            this.str[i] = Integer.parseInt(temp[i]);
    }

    public String getWord() {
        return word;
    }

    @Override
    public String toString() {
        return this.word;
    }

    public void setWord(String word, int i) {
        this.word = word;
    }

    public Line(String word) {
        this.word = word;
    }

    public void rand() {
        for (int i = 0; i < 4; i++) {
            int a = (int) (0 + Math.random() * 9);
            word += Integer.toString(a);
        }
    }
}


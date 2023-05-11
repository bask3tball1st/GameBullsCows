public class Line {
    String word = "";
    int [] str = new int[4];
    public Line() { };

    public void setStr(String str) {
        String []temp = str.split("");
        for (int i = 0 ; i < 4; i++)
            this.str[i] = Integer.parseInt(temp[i]);
    }
    @Override
    public String toString() {
        return this.word;
    }

    public Line(String word) {
        this.word = word;
    }
    public boolean correctInput() {
        if (this.word.length() != 4) {
            System.out.println("Ошибка! Введите строку из 4-х символов!");
            return false;
        }
        else return true;
    }

    //TODO в загаданной строке не должно быть дублирующих символов +(исправил)
    //TODO у тебя 9 никогда не попадет в загаданную строку. Подумай почему +(понял почему! исправил)
    public void rand() {
        while (word.length() != 4) {
            int a = (int) (Math.random() * 10);
            String [] str = word.split("");
            boolean flag = false;
            for (int i = 0; i < word.length(); i++) {
                int temp = Integer.parseInt(str[i]);
                if (temp == a) {
                    flag = true;
                    break;
                }
            }
            if (!flag)
                word += Integer.toString(a);
        }
    }
}


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Вы запустили игру!");
        boolean flag = false;
        while (!flag) {
            printMenu();
            Scanner scan = new Scanner(System.in);
            int choice = scan.nextInt();
            //TODO со свитч прикольно придумал
            // :))
            switch (choice) {
                case 1:
                    Reader FileRd = new Reader("Result.txt");
                    int gameNumber = FileRd.findNumb() + 1;
                    Writer fileWr = new Writer("Result.txt");
                    Line comp = new Line();
                    Line player;
                    comp.rand();
                    fileWr.writeStart(gameNumber, comp);
                    Scanner in = new Scanner(System.in);
                    Game game;
                    do {
                        game = new Game();
                        do {
                            player = new Line(in.next());
                        } while (!player.correctInput());
                        game.compareStr(comp, player);
                        fileWr.writeGameStep(player, game);
                    } while (!game.checkRes());
                    fileWr.writeResult();
                    break;
                case 2:
                    flag = true;
                    System.out.println("Завершение программы!");
                    break;
                default:
                    System.out.println("Ошибка ввода команды! Повторите попытку!");
                    break;
            }
        }
    }
    public static void printMenu() {
        System.out.println("Выберите действие: ");
        System.out.println("1. Играть");
        System.out.println("2. Завершить программу");
    }
}
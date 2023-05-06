import java.sql.SQLOutput;

public interface IWrite {
    void write(Line player);
    default void write() {
        System.out.println("Строка была угадана за попыток.");
    }
}

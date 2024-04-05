import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("============= ДЗ 2 =============");
        System.out.println("Введите путь к файлу или папке: ");
        String path = new Scanner(System.in).nextLine();
        printSize(path);

//        System.out.println("============= ДЗ 3 =============");
//        setSale();
    }

    private static void printSize(String path) {
        //todo Дописать код расчета размера и корректного отображения
        double sum = 0;
        try {
            sum = Files.walk(Path.of(path))
                    .map(Path::toFile)
                    .filter(File::isFile)
                    .mapToDouble(File::length).sum();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.print(sum + " байт " + Math.round((sum / 1024) * 1000.0) / 1000.0 + " килобайт");

    }

    private static void setSale() {
        //todo Тут написать код для ДЗ #3
    }
}

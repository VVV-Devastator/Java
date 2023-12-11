import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class UserDataApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите данные в следующем формате: Фамилия Имя Отчество датарождения номертелефона пол");
        String input = scanner.nextLine();

        String[] data = input.split(" ");

        if (data.length != 6) {
            System.out.println("Ошибка: неверное количество данных.");
            return;
        }

        String lastName = data[0];
        String firstName = data[1];
        String middleName = data[2];
        String birthDateStr = data[3];
        String phoneNumberStr = data[4];
        String genderStr = data[5];

        try {
            LocalDate birthDate = parseBirthDate(birthDateStr);
            long phoneNumber = parsePhoneNumber(phoneNumberStr);
            Gender gender = parseGender(genderStr);

            String fileName = lastName + ".txt";
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(lastName + " " + firstName + " " + middleName + " " + birthDate + " " + phoneNumber + " " + gender + "\n");
            writer.close();

            System.out.println("Данные успешно записаны в файл " + fileName);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл:");
            e.printStackTrace();
        }
    }

    private static LocalDate parseBirthDate(String birthDateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return LocalDate.parse(birthDateStr, formatter);
    }

    private static long parsePhoneNumber(String phoneNumberStr) {
        try {
            return Long.parseLong(phoneNumberStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Неверный формат номера телефона.", e);
        }
    }

    private static Gender parseGender(String genderStr) {
        if (genderStr.equalsIgnoreCase("m")) {
            return Gender.MALE;
        } else if (genderStr.equalsIgnoreCase("f")) {
            return Gender.FEMALE;
        } else {
            throw new IllegalArgumentException("Неверное значение пола. Допустимые значения: 'm' или 'f'.");
        }
    }

    private enum Gender {
        MALE, FEMALE
    }
}
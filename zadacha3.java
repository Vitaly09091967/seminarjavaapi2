/**3) Дана строка в файле(читать из файла)
[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":
"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов",
"оценка":"5","предмет":"Физика"}]
Написать метод(ы), который распарсит строчку и, используя StringBuilder,
 создаст строки вида: Студент [фамилия] получил [оценка] по предмету
  [предмет].
Пример вывода:
Студент Иванов получил 5 по предмету Математика.
Студент Петрова получил 4 по предмету Информатика.
Студент Краснов получил 5 по предмету Физика.*/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class zadacha3 {
    public static void main(String[] args) {
        String filePath = "path/to/your/file.json";

        try {
            List<String> lines = Files.readAllLines(Path.of(filePath));
            StringBuilder resultBuilder = new StringBuilder();

            for (String line : lines) {
                resultBuilder.append(parseStudentInfo(line));
                resultBuilder.append("\n");
            }

            System.out.println(resultBuilder.toString());
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }

    private static String parseStudentInfo(String jsonString) {
        StringBuilder studentInfo = new StringBuilder();

        jsonString = jsonString.substring(1, jsonString.length() - 1);
        String[] studentData = jsonString.split("\\},\\{");

        for (String data : studentData) {
            String[] keyValuePairs = data.split(",");
            StringBuilder studentBuilder = new StringBuilder("Студент ");

            for (String pair : keyValuePairs) {
                String[] keyValue = pair.split(":");
                String key = keyValue[0].replaceAll("\"", "").trim();
                String value = keyValue[1].replaceAll("\"", "").trim();
                studentBuilder.append(key).append(" ").append(value).append(" ");
            }

            studentInfo.append(studentBuilder.toString().trim());
            studentInfo.append(".\n");
        }

        return studentInfo.toString();
    }
}
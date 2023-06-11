/**1) Дана строка sql-запроса "select * from students WHERE ". Сформируйте 
часть WHERE этого запроса, используя StringBuilder. Данные для фильтрации 
приведены ниже в виде json-строки.
Если значение null, то параметр не должен попадать в запрос.
Пример данной строки {"name":"Ivanov", "country":"Russia", "city":"Moscow",
 "age":"null"}
Вывод: select * from students WHERE name=Ivanov AND country=Russia AND 
city=Moscow */

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class zadacha1 {
    public static void main(String[] args) {
        String jsonString = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
        Map<String, String> jsonMap = parseJsonString(jsonString);

        StringBuilder whereClause = new StringBuilder("select * from students WHERE ");
        StringJoiner conditionJoiner = new StringJoiner(" AND ");

        for (Map.Entry<String, String> entry : jsonMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (!value.equals("null")) {
                conditionJoiner.add(key + "=" + value);
            }
        }

        whereClause.append(conditionJoiner.toString());

        String sqlQuery = whereClause.toString();
        System.out.println(sqlQuery);
    }

    private static Map<String, String> parseJsonString(String jsonString) {
        Map<String, String> jsonMap = new HashMap<>();

        jsonString = jsonString.substring(1, jsonString.length() - 1);
        String[] keyValuePairs = jsonString.split(", ");

        for (String pair : keyValuePairs) {
            String[] keyValue = pair.split(":");
            String key = keyValue[0].replaceAll("\"", "");
            String value = keyValue[1].replaceAll("\"", "");
            jsonMap.put(key, value);
        }

        return jsonMap;
    }
}


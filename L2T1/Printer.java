class Answer {  
    public static StringBuilder answer(String QUERY, String PARAMS){
        // Напишите свое решение ниже
        StringBuilder whereClause = new StringBuilder();

        // Разбираем JSON-строку с параметрами
        String[] params = PARAMS.split(", ");

        // Проверяем и добавляем каждый параметр в WHERE запроса
        for (String param : params) {
            String[] keyValue = param.split(":");
            String key = keyValue[0].replace("\"", "");
            String value = keyValue[1].replace("\"", "");

            if (!value.equals("null")) {
                whereClause.append(key).append(" = '").append(value).append("' AND ");
            }
        }
        System.out.println(whereClause);
        // Удаляем последний "AND" из WHERE-запроса
        if (whereClause.length() > 0) {
            whereClause.setLength(whereClause.length() - 5);
        }

        return whereClause;
    }
}


// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Printer{ 
	public static void main(String[] args) { 
      String QUERY = "";
      String PARAMS = "";
      
      if (args.length == 0) {
        // При отправке кода на Выполнение, вы можете варьировать эти параметры
        QUERY = "select * from students where ";
	    PARAMS = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"} ";
      }
      else{
        QUERY = args[0];
        PARAMS = args[1];
      }     
      
      Answer ans = new Answer();      
      System.out.println(ans.answer(QUERY, PARAMS));
	}
}
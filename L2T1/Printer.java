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

class Answer {  
    public static StringBuilder answer(String QUERY, String PARAMS){
        // Напишите свое решение ниже
        StringBuilder whereClause = new StringBuilder();
        whereClause.append(QUERY);
        // Разбираем JSON-строку с параметрами
        String[] params = PARAMS.split(", ");
        int nl = 0;
        // Проверяем и добавляем каждый параметр в WHERE запроса
        for (String param : params) {
            String[] keyValue = param.split(":");
            String key = keyValue[0].replace("\"", "").replaceAll("[{}]", "");
            String value = keyValue[1].replace("\"", "").replaceAll("[{}]", "").replaceAll("[ ]", "");
            if (!value.equals("null") && nl==0 )  {
                whereClause.append(key).append("='").append(value).append("'");
                nl = nl + 1;
            } else if (!value.equals("null") && nl>0) {
                whereClause.append(" and ").append(key).append("='").append(value).append("'");           
            }
        }
        return whereClause;
    }
}



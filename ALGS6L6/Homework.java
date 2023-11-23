import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class Homework {

  static class ReportService {
    private Map<String, Function<Document, byte[]>> reportGenerators;

    public ReportService() {
      reportGenerators = new HashMap<>();
      reportGenerators.put("pdf-1", this::generatePdfReport);
      reportGenerators.put("json", this::generateJsonReport);
      reportGenerators.put("xml", this::generateXmlReport);
    }

    public byte[] createReport(Document document, String reportType) {
      Function<Document, byte[]> reportGenerator = reportGenerators.get(reportType);
      if (reportGenerator != null) {
        return reportGenerator.apply(document);
      } else {
        throw new IllegalArgumentException("Неподдерживаемый тип отчета: " + reportType);
      }
    }

    private byte[] generatePdfReport(Document document) {
      // Логика генерации PDF-отчета на основе документа
      // Возвращается массив байтов с содержимым PDF-файла
      // Пример:
      String reportContent = "Содержимое PDF-отчета для документа " + document.getId();
      return reportContent.getBytes();
    }

    private byte[] generateJsonReport(Document document) {
      // Логика генерации JSON-отчета на основе документа
      // Возвращается массив байтов с содержимым JSON-файла
      // Пример:
      String reportContent = "{\"documentId\": " + document.getId() + "}";
      return reportContent.getBytes();
    }

    private byte[] generateXmlReport(Document document) {
      // Логика генерации XML-отчета на основе документа
      // Возвращается массив байтов с содержимым XML-файла
      // Пример:
      String reportContent = "<document><id>" + document.getId() + "</id></document>";
      return reportContent.getBytes();
    }
  }

  static class Document {
    private long id;
    private String number;
    // ...

    public long getId() {
      return id;
    }

    public void setId(long id) {
      this.id = id;
    }

    // Методы доступа к полям документа
  }

  public static void main(String[] args) {
    // Пример использования ReportService для создания отчета
    Document document = new Document();
    document.setId(12345);
    String reportType = "pdf-1";

    ReportService reportService = new ReportService();
    byte[] report = reportService.createReport(document, reportType);

    
     //сохранение в файл:
     //Path outputPath = Path.of("report." + reportType);
     //Files.write(outputPath, report);
     //System.out.println("Отчет сохранен в: " + outputPath);



    //  1. Насколько сложно добавить поддержку нового типа отчета?
    //  Сложность добавления поддержки нового типа отчета зависит от сложности формата отчета и требований системы.
    //  Если новый тип отчета имеет аналогичную структуру с существующими, это может потребовать реализации нового метода
    //  или расширения существующей логики для обработки нового типа.
    //  Если новый тип отчета требует значительных изменений или отличного подхода,
    //  это может потребовать большего усилия по проектированию и реализации.

    // 2. Как будет выглядеть проект, если в нем будет 1000+ типов отчетов?
    // Если система должна поддерживать 1000+ типов отчетов, она может стать сложной и трудной для управления.
    // Объем кодовой базы значительно увеличится с множеством реализаций и логики, специфичной для каждого типа отчета.
    // Обслуживание и расширение такой системы могут стать сложными задачами.
    // В таком случае рекомендуется рассмотреть более модульный и масштабируемый подход, например, использование механизма плагинов или расширений,
    // где каждый тип отчета может быть реализован в виде отдельного модуля или плагина.
    // Это поможет организовать и управлять кодовой базой более эффективно и облегчит добавление и поддержку новых типов отчетов.
  }
}
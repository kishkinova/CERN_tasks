package secondTask;

public class DashSpreadsheetExporter implements SpreadsheetExporter {
    private final SpreadsheetImpl sheet;

    public DashSpreadsheetExporter(SpreadsheetImpl sheet) {
        this.sheet = sheet;
    }

    @Override
    public String export() {
       return null;
    }
}
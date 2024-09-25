package secondTask;

public class StarSpreadsheetExporter implements SpreadsheetExporter {

    private final SpreadsheetImpl sheet;

    public StarSpreadsheetExporter(SpreadsheetImpl sheet) {
        this.sheet = sheet;
    }

    @Override
    public String export() {
        return null;
    }
}

package secondTask;

public class StarSpreadsheetExporter implements SpreadsheetExporter {

    private final SpreadsheetImpl sheet;

    public StarSpreadsheetExporter(SpreadsheetImpl sheet) {
        this.sheet = sheet;
    }

    @Override
    public String export() {
        StringBuilder sb = new StringBuilder();
        sb.append(sheet.rows).append(",").append(sheet.columns).append("#");

        for (int row = 0; row < sheet.rows; row++) {
            for (int col = 0; col < sheet.columns; col++) {
                String cellValue = sheet.get(row, col);
                sb.append(cellValue.isEmpty() ? '*' : cellValue + '*');
            }
        }

        return sb.toString();
    }
}

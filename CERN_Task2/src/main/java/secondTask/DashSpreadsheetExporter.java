package secondTask;

/**
 * SpreadsheetExporter interface implementation to export the spreadsheet with dashes ('-'). */

public class DashSpreadsheetExporter implements SpreadsheetExporter {
    private final SpreadsheetImpl sheet;

    /**
     * Constructor for DashSpreadsheetExporter.
     *
     * @param sheet the SpreadsheetImpl object to export.
     */
    public DashSpreadsheetExporter(SpreadsheetImpl sheet) {
        this.sheet = sheet;
    }

    /**
     Exports the spreadsheet by replacing each empty cell with a dash ('-').
     * Each cell value is followed by a dash ('-').
     *
     * @return a String representing the exported spreadsheet.
     */
    @Override
    public String export() {
        StringBuilder sb = new StringBuilder();
        sb.append(sheet.rows).append(",").append(sheet.columns).append("#");

        for (int row = 0; row < sheet.rows; row++) {
            for (int col = 0; col < sheet.columns; col++) {
                String cellValue = sheet.get(row, col);
                sb.append(cellValue.isEmpty() ? '-' : cellValue + '-');
            }
        }

        return sb.toString();
    }
}
package secondTask;

/**
 * SpreadsheetExporter interface implementation to export the spreadsheet with stars ('*').
 */
public class StarSpreadsheetExporter implements SpreadsheetExporter {

    private final SpreadsheetImpl sheet;

    /**
     * Constructor for StarSpreadsheetExporter.
     *
     * @param sheet the SpreadsheetImpl object to export.
     */
    public StarSpreadsheetExporter(SpreadsheetImpl sheet) {
        this.sheet = sheet;
    }

    /**
     * Exports the spreadsheet by replacing each empty cell with a star ('*').
     * Each cell value is followed by a star ('*').
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
                sb.append(cellValue.isEmpty() ? '*' : cellValue + '*');
            }
        }

        return sb.toString();
    }
}

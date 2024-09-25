package secondTask;

/**
 * A utility class that provides a method to create a new spreadsheet instances.
 */
public class Office {

    /**
     * Creates a new instance of SpreadsheetImpl.
     *
     * @param rows the number of rows in the spreadsheet.
     * @param columns the number of columns in the spreadsheet.
     * @return a new SpreadsheetImpl instance.
     */
    public static SpreadsheetImpl newSpreadsheet(int rows, int columns) {
        return new SpreadsheetImpl(rows, columns);
    }
}

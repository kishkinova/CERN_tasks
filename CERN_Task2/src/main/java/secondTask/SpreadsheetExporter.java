package secondTask;

/**
 * An interface for representing a spreadsheet exporter.
 * Provides a method to export the spreadsheet in a specific format.
 */
public interface SpreadsheetExporter {

    /**
     * Exports the spreadsheet in a specific format.
     *
     * @return a String representation of the exported spreadsheet.
     */
    String export();
}

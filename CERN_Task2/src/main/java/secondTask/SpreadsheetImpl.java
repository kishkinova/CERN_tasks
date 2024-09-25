package secondTask;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * A class for representing a spreadsheet.
 */
public class SpreadsheetImpl {
    final int rows;
    final int columns;
    private final List<List<String>> spreadsheet;

    /**
     * Constructor for SpreadsheetImpl.
     *
     * @param rows the number of rows in the spreadsheet.
     * @param columns the number of columns in the spreadsheet.
     */
    public SpreadsheetImpl(int rows, int columns) {
        if (rows <= 0 || columns <= 0) {
            throw new IllegalArgumentException("Rows and columns must be positive.");
        }
        this.rows = rows;
        this.columns = columns;
        this.spreadsheet = Stream.generate(() -> new ArrayList<>(Collections.nCopies(columns, "")))
                .limit(rows)
                .collect(Collectors.toList());
    }

    /**
     * Retrieves the value of a cell at the specified row and column.
     *
     * @param row the row index of the cell.
     * @param column the column index of the cell.
     * @return the value of the cell as a String.
     * @throws IndexOutOfBoundsException if the row or column index is out of bounds.
     */
    public String get(int row, int column){
        checkIndexBounds(row, column);
        return spreadsheet.get(row).get(column);
    }

    /**
     * Stores a value of the cell at the specified row and column.
     * Recognizes integer, string, and formula values and trims integer values.
     *
     * @param row the row index of the cell.
     * @param column the column index of the cell.
     * @param value the value to store in the cell.
     * @throws IndexOutOfBoundsException if the row or column index is out of bounds.
     */
    public void put(int row, int column, String value) {
        if (value == null) {
            throw new IllegalArgumentException("Cell value cannot be null.");
        }
        checkIndexBounds(row, column);
        switch (getValueType(value)) {
            case STRING, FORMULA ->
                    spreadsheet.get(row).set(column, value);
            case INTEGER ->
                    spreadsheet.get(row).set(column, String.valueOf(Integer.parseInt(value.trim())));
        }
    }

    /**
     * Checks bounds of the specified row and column indexes.
     *
     * @param row the row index.
     * @param column the column index.
     * @throws IndexOutOfBoundsException if the row or column index is out of bounds.
     */
    public void checkIndexBounds(int row, int column){
        if (row >= this.rows || column >= this.columns || row < 0 || column < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Returns the value type of the cell at the specified row and column.
     *
     * @param row the row index of the cell.
     * @param column the column index of the cell.
     * @return the value type of the cell (STRING, INTEGER, FORMULA).
     */
    public ValueType getValueType(int row, int column) {
        return getValueType(get(row, column));
    }

    /**
     * Returns the value type of the given string.
     *
     * @param value the string to check.
     * @return the value type of the string (STRING, INTEGER, FORMULA).
     */
    public ValueType getValueType(String value){
        if (value.startsWith("=")) {
            return ValueType.FORMULA;
        } else if (value.trim().matches("\\d+")) {
            return ValueType.INTEGER;
        } else {
            return ValueType.STRING;
        }
    }

}


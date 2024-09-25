package secondTask;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SpreadsheetImpl {
    final int rows;
    final int columns;
    private final List<List<String>> spreadsheet;

    public SpreadsheetImpl(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.spreadsheet = Stream.generate(() -> new ArrayList<>(Collections.nCopies(columns, "")))
                .limit(rows)
                .collect(Collectors.toList());
    }

    public String get(int row, int column){
        checkIndexBounds(row, column);
        return spreadsheet.get(row).get(column);
    }

    public void put(int row, int column, String value) {
        checkIndexBounds(row, column);
        spreadsheet.get(row).set(column, value);
    }

    public void checkIndexBounds(int row, int column){
        if (row >= this.rows || column >= this.columns || row < 0 || column < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

}


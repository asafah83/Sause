package utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {
    private Workbook workbook;

    public ExcelUtils(String filePath) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(fis);
    }

    public String getCellData(String sheetName, int rowNum, int colNum) {
        Sheet sheet = workbook.getSheet(sheetName);
        Row row = sheet.getRow(rowNum);
        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(row.getCell(colNum));
    }

    public int getRowCount(String sheetName) {
        Sheet sheet = workbook.getSheet(sheetName);
        return sheet.getLastRowNum() + 1; // Adding 1 since rows are zero-indexed
    }

    public int getColumnCount(String sheetName) {
        Sheet sheet = workbook.getSheet(sheetName);
        Row row = sheet.getRow(0); // Assuming first row contains headers
        return row.getLastCellNum();
    }

    public void close() throws IOException {
        workbook.close();
    }
}

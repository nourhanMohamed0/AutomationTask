package Utils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestData {
    @DataProvider(name = "invalidMail")
    public Object[][] getInvalidMailFormat() {
        String filePath = "InvalidMailFormatSignup.xlsx";

        List<String> invalidMailFormat = new ArrayList<>();
        List<String> errorMsgList = new ArrayList<>();

        // Try-with-resources to ensure the file is closed properly
        try (FileInputStream file = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(file)) {

            Sheet sheet = workbook.getSheetAt(0);

            // Loop through the rows (skip the header)
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row != null) {
                    // Check for null cells to avoid NullPointerException
                    String email = (row.getCell(0) != null) ? row.getCell(0).getStringCellValue() : "";
                    String errorMessage = (row.getCell(1) != null) ? row.getCell(1).getStringCellValue() : "";

                    invalidMailFormat.add(email);
                    errorMsgList.add(errorMessage);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        // Convert lists to Object[][] array
        Object[][] data = new Object[invalidMailFormat.size()][2];
        for (int i = 0; i < invalidMailFormat.size(); i++) {
            data[i][0] = invalidMailFormat.get(i);  // Invalid email format
            data[i][1] = errorMsgList.get(i);       // Expected error message
        }

        return data;
    }

}


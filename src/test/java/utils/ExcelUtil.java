package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

public class ExcelUtil {

    public static String getData(String sheetName,
                                 int rowNum,
                                 int cellNum) throws Exception {

        String path = "src/test/resources/TestData.xlsx";

        FileInputStream fis = new FileInputStream(path);

        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        XSSFSheet sheet = workbook.getSheet(sheetName);

        DataFormatter formatter = new DataFormatter();

        String value = formatter.formatCellValue(
                sheet.getRow(rowNum).getCell(cellNum));

        workbook.close();
        fis.close();

        return value;
    }
    public static void writeData(List<String> data)
    {
        try
        {
            Workbook wb = new XSSFWorkbook();

            Sheet sheet = wb.createSheet("Health Insurance");

            for(int i=0;i<data.size();i++)
            {
                Row row = sheet.createRow(i);

                Cell cell = row.createCell(0);

                cell.setCellValue(data.get(i));
            }

            FileOutputStream fos =
                    new FileOutputStream("HealthInsurance.xlsx");

            wb.write(fos);

            wb.close();
            fos.close();

            System.out.println("Excel Created");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
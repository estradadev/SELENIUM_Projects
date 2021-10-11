import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class DataDriven {

    //Identify Testcases coloumn by scanning the entire 1st row
    //once  coloumn is identified then scan entire testcase coloumn to identify purchase testcase row
    //after you grap purchase testcase row = pull all the data of that row and feed into test

    public static void main(String[] args) throws IOException {

        DataDriven demo = new DataDriven();
        demo.getData("Purchase");

    }

    public ArrayList<String> getData(String testCaseName) throws IOException {
        //fileInputStream argument
        ArrayList<String> a = new ArrayList<String>();

        //fileInputStream argument
        FileInputStream fis = new FileInputStream(
                "C:\\Users\\eadri\\Documents\\SELENIUM_Projects\\Excel\\Libro1.xlsx"
        );

        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        int sheets = workbook.getNumberOfSheets();
        int k=0;
        int coloumn=0;
        for (int i=0; i<sheets; i++){
            if (workbook.getSheetName(i).equalsIgnoreCase("testdata")){
                XSSFSheet sheet = workbook.getSheetAt(i);

                Iterator<Row> rows = sheet.iterator();//sheet is collection of rows
                Row firstRow = rows.next();
                Iterator<Cell> cell = firstRow.cellIterator();//row is collection of cells

                while (cell.hasNext()){

                    Cell firstCell = cell.next();
                    if (firstCell.getStringCellValue().equalsIgnoreCase("TestCases")){
                        coloumn = k;
                    }
                    k++;
                }

                //System.out.println(coloumn);

                while (rows.hasNext()){

                    Row r = rows.next();
                    if(r.getCell(coloumn).getStringCellValue().equalsIgnoreCase(testCaseName)){

                        Iterator<Cell> cv = r.cellIterator();
                        while (cv.hasNext()){

                            Cell c = cv.next();
                            //c.getCellTypeEnum()
                            if(c.getCellTypeEnum() == CellType.STRING){
                                a.add(c.getStringCellValue());
                                //a.add(cv.next().getStringCellValue());
                            }
                            else{
                                a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
                            }

                            a.add(cv.next().getStringCellValue());

                        }

                    }

                }

            }

        }
        return a;
    }

}

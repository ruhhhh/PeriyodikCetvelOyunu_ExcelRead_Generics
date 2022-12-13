import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
public class ShowName {
    public static final String path = "./PeriyodikCetvel.xlsx";
    public void showName() throws IOException, InvalidFormatException {

        RandomNumberCreate randomNumberCreate = new RandomNumberCreate();
        PointControl pointControl = new PointControl();
        BasePoint basePoint = new BasePoint();
        int point = basePoint.basePoint();
        int health =0;
        Workbook workbook = WorkbookFactory.create(new File(path));
        Sheet sheet = workbook.getSheetAt(0);
        HashMap<Integer, String> data = new HashMap<>();
        HashMap<Integer, String> data1 = new HashMap<>(data);
        int rowNumber =0;

        for(Row rowNum: sheet)
        {
            Row row = sheet.getRow(rowNumber);
            Cell cell = row.getCell(0);
            Cell cell1 = row.getCell(1);
            data.put(rowNumber, String.valueOf(cell));
            data1.put(rowNumber,String.valueOf(cell1));
            rowNumber++;
        }
        System.out.println("Başlangıç puanınız: 50 Puan");
        while(health<5)
        {
            int number = randomNumberCreate.randomNumberCreate();
            System.out.print(number + " ");
            System.out.println(data1.get(number));
            Scanner read = new Scanner(System.in);
            System.out.print("Cevabınız: ");
            String answer = read.nextLine();
            if (data.get(number).equalsIgnoreCase(answer)) {
                System.out.println("İşte bu doğru cevap. Güncel Puanınız: " + pointControl.pointPlusControl(point) + " Puan");
                point = pointControl.pointPlusControl(point);
            } else {
                System.out.println("Maalesef yanlış cevap verdiniz. Güncel Puanınız: " + pointControl.pointMinusControl(point) + " Puan");
                point = pointControl.pointMinusControl(point);
            }
            health++;
        }
        System.out.println("Maalesef oyun bitmiştir.");
    }
}

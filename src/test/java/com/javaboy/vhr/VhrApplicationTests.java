package com.javaboy.vhr;

import com.javaboy.vhr.entity.Employee;
import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class VhrApplicationTests {

    @Test
    void contextLoads() {

    }


    @Test
    void xslUtil() throws Exception {


        List<Map> list = new ArrayList();

        // 1.创建一个Excel文档
        HSSFWorkbook workbook = new HSSFWorkbook();


        File file =new File("D:\\run\\testfile\\仪器仪表设备台账定额分析_20211109给word用.xls");
        InputStream inputStream = new FileInputStream(file);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(inputStream);
        int numberOfSheets = hssfWorkbook.getNumberOfSheets();
        for (int i = 0; i < numberOfSheets; i++) {
            HSSFSheet sheetAt = hssfWorkbook.getSheetAt(i);
            int lastRowNum = sheetAt.getLastRowNum();
            HSSFRow tital = sheetAt.getRow(2);
            for (int j = 3; j <= lastRowNum; j++) {
                HSSFRow row = sheetAt.getRow(j);
                short lastCellNum = row.getLastCellNum();
                for (int k = 6; k < lastCellNum; k++) {
                    HSSFCell cell = row.getCell(k);
                    if (cell!=null){
                        CellType cellType = row.getCell(k).getCellType();
                        if (cellType.equals(CellType.STRING)){
                            String stringCellValue = cell.getStringCellValue();
                            if (stringCellValue.equals("需")){
                                Map map = new HashMap();
                                map.put("备注",row.getCell(1).getStringCellValue().trim());
                                map.put("所属地市",sheetAt.getSheetName().trim()+"供电公司");
                                map.put("设备类型",row.getCell(2).getStringCellValue().trim());
                                double numericCellValue = row.getCell(5).getNumericCellValue();
                                map.put("定额数量",this.getNumberTwo(numericCellValue));
                                map.put("保管单位",tital.getCell(k).getStringCellValue().trim());
                                list.add(map);
                            }
                        }
                    }
                }
            }
            HSSFSheet sheet = workbook.createSheet(sheetAt.getSheetName());
            HSSFRow row = sheet.createRow(0);
            HSSFCell cell0 = row.createCell(0);
            cell0.setCellValue("序号");
            HSSFCell cell1 = row.createCell(1);
            cell1.setCellValue("所属地市");
            HSSFCell cell2 = row.createCell(2);
            cell2.setCellValue("保管单位");
            HSSFCell cell3 = row.createCell(3);
            cell3.setCellValue("设备类型");
            HSSFCell cell4 = row.createCell(4);
            cell4.setCellValue("定额数量");
            HSSFCell cell5 = row.createCell(5);
            cell5.setCellValue("现有存量");
            HSSFCell cell6 = row.createCell(6);
            cell6.setCellValue("计量单位");
            HSSFCell cell7 = row.createCell(7);
            cell7.setCellValue("备注");

            for (int i1 = 0; i1 < list.size(); i1++) {
                Map map = list.get(i1);
                HSSFRow rowContent = sheet.createRow(i1+1);
                HSSFCell hssfCell1 = rowContent.createCell(0);
                hssfCell1.setCellValue(i1+1);
                HSSFCell hssfCell2 = rowContent.createCell(1);
                hssfCell2.setCellValue(map.get("所属地市").toString());

                HSSFCell hssfCell3 = rowContent.createCell(2);
                hssfCell3.setCellValue(map.get("保管单位").toString());

                HSSFCell hssfCell4 = rowContent.createCell(3);
                hssfCell4.setCellValue(map.get("设备类型").toString());

                HSSFCell hssfCell5 = rowContent.createCell(4);
                hssfCell5.setCellValue(map.get("定额数量").toString());

                HSSFCell hssfCell6 = rowContent.createCell(5);
                hssfCell6.setCellValue("");

                HSSFCell hssfCell7 = rowContent.createCell(6);
                hssfCell7.setCellValue("");

                HSSFCell hssfCell8 = rowContent.createCell(7);
                hssfCell8.setCellValue(map.get("备注").toString());
            }
            for (Map map : list) {
                System.out.println(map.get("所属地市") + "---" + map.get("保管单位") + "---" + map.get("设备类型") + "---" + map.get("定额数量") + "---" + map.get("备注"));
            }
            list = new ArrayList<>();
        }
        File file1 = new File("D:\\run\\testfile\\1.xls");
        file1.delete();
        file1.createNewFile();
        workbook.write(file1);
    }




    /**保留两位小数并四舍五入*/
    public  Double getNumberTwo(Double value) {
        BigDecimal bigDecimal = new BigDecimal(value);
        // 保留两位小数
        DecimalFormat formater = new DecimalFormat("0.##");
        // 四舍五入
        formater.setRoundingMode(RoundingMode.HALF_UP);

        // 格式化完成之后得出结果
        String rs = formater.format(bigDecimal);
        return Double.valueOf(rs == null ?"0.0":rs );
    }

}

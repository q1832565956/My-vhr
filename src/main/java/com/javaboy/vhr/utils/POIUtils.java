package com.javaboy.vhr.utils;

import com.javaboy.vhr.entity.*;
import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class POIUtils {

    public static ResponseEntity<Byte[]> employee2Execl(List<Employee> employees) {
        // 1.创建一个Excel文档
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 2.创建文档摘要
        workbook.createInformationProperties();
        // 3.获取并配置文档摘要信息
        DocumentSummaryInformation documentSummaryInformation = workbook.getDocumentSummaryInformation();
        // 文档类别
        documentSummaryInformation.setCategory("员工信息");
        // 文档管理元
        documentSummaryInformation.setManager("qiyue");
        // 设置公司信息
        documentSummaryInformation.setCompany("张氏集团");
        // 4.获取文档摘要信息
        SummaryInformation summaryInformation = workbook.getSummaryInformation();
        // 文档作者
        summaryInformation.setAuthor("张三");
        // 文档标题
        summaryInformation.setTitle("员工信息表");
        // 文档备注
        summaryInformation.setComments("本文档有张三提供");
        //创建标题行样式
        CellStyle headStyle = workbook.createCellStyle();
        headStyle.setFillForegroundColor(IndexedColors.GREEN.index);
        headStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        //创建标题行样式
        CellStyle dateStyle = workbook.createCellStyle();
        dateStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));

        HSSFSheet sheet = workbook.createSheet("员工信息数据");
        // 设置宽度
        sheet.setColumnWidth(0,5*256);
        sheet.setColumnWidth(1,12*256);
        sheet.setColumnWidth(2,10*256);
        sheet.setColumnWidth(3,5*256);
        sheet.setColumnWidth(4,12*256);
        sheet.setColumnWidth(5,20*256);
        sheet.setColumnWidth(6,10*256);
        sheet.setColumnWidth(7,10*256);
        sheet.setColumnWidth(8,12*256);
        sheet.setColumnWidth(9,12*256);
        sheet.setColumnWidth(10,15*256);
        sheet.setColumnWidth(11,25*256);
        sheet.setColumnWidth(12,20*256);
        sheet.setColumnWidth(13,20*256);
        sheet.setColumnWidth(14,15*256);
        sheet.setColumnWidth(15,15*256);
        sheet.setColumnWidth(16,10*256);
        sheet.setColumnWidth(17,15*256);
        sheet.setColumnWidth(18,20*256);
        sheet.setColumnWidth(19,12*256);
        sheet.setColumnWidth(20,5*256);
        sheet.setColumnWidth(21,20*256);
        sheet.setColumnWidth(22,5*256);
        sheet.setColumnWidth(23,12*256);
        sheet.setColumnWidth(24,12*256);
        // 创建标题行
        HSSFRow row = sheet.createRow(0);

        HSSFCell c0 =row.createCell(0);
        c0.setCellValue("编号");
        c0.setCellStyle(headStyle);
        HSSFCell c1 =row.createCell(1);
        c1.setCellValue("姓名");
        c1.setCellStyle(headStyle);
        HSSFCell c2 =row.createCell(2);
        c2.setCellValue("工号");
        c2.setCellStyle(headStyle);
        HSSFCell c3 =row.createCell(3);
        c3.setCellValue("性别");
        c3.setCellStyle(headStyle);
        HSSFCell c4 =row.createCell(4);
        c4.setCellValue("出生日期");
        c4.setCellStyle(headStyle);
        HSSFCell c5 =row.createCell(5);
        c5.setCellValue("身份证号码");
        c5.setCellStyle(headStyle);
        HSSFCell c6 =row.createCell(6);
        c6.setCellValue("婚姻状况");
        c6.setCellStyle(headStyle);
        HSSFCell c7 =row.createCell(7);
        c7.setCellValue("民族");
        c7.setCellStyle(headStyle);
        HSSFCell c8 =row.createCell(8);
        c8.setCellValue("籍贯");
        c8.setCellStyle(headStyle);
        HSSFCell c9 =row.createCell(9);
        c9.setCellValue("政治面貌");
        c9.setCellStyle(headStyle);
        HSSFCell c10 =row.createCell(10);
        c10.setCellValue("电话号码");
        c10.setCellStyle(headStyle);
        HSSFCell c11 =row.createCell(11);
        c11.setCellValue("联系地址");
        c11.setCellStyle(headStyle);
        HSSFCell c12 =row.createCell(12);
        c12.setCellValue("所属部门");
        c12.setCellStyle(headStyle);
        HSSFCell c13 =row.createCell(13);
        c13.setCellValue("职称");
        c13.setCellStyle(headStyle);
        HSSFCell c14 =row.createCell(14);
        c14.setCellValue("职位");
        c14.setCellStyle(headStyle);
        HSSFCell c15 =row.createCell(15);
        c15.setCellValue("聘用形式");
        c15.setCellStyle(headStyle);
        HSSFCell c16 =row.createCell(16);
        c16.setCellValue("最高学历");
        c16.setCellStyle(headStyle);
        HSSFCell c17 =row.createCell(17);
        c17.setCellValue("专业");
        c17.setCellStyle(headStyle);
        HSSFCell c18 =row.createCell(18);
        c18.setCellValue("毕业院校");
        c18.setCellStyle(headStyle);
        HSSFCell c19 =row.createCell(19);
        c19.setCellValue("入职日期");
        c19.setCellStyle(headStyle);
        HSSFCell c20 =row.createCell(20);
        c20.setCellValue("在职状态");
        c20.setCellStyle(headStyle);
        HSSFCell c21 =row.createCell(21);
        c21.setCellValue("邮箱");
        c21.setCellStyle(headStyle);
        HSSFCell c22 =row.createCell(22);
        c22.setCellValue("合同年限（年）");
        c22.setCellStyle(headStyle);
        HSSFCell c23 =row.createCell(23);
        c23.setCellValue("合同起始日期");
        c23.setCellStyle(headStyle);
        HSSFCell c24 =row.createCell(24);
        c24.setCellValue("合同终止日期");
        c24.setCellStyle(headStyle);

        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            HSSFRow rowBody = sheet.createRow(i+1);
            HSSFCell cell0=rowBody.createCell(0);
            cell0.setCellValue(employee.getId());

            HSSFCell cell1=rowBody.createCell(1);
            cell1.setCellValue(employee.getName());

            HSSFCell cell2=rowBody.createCell(2);
            cell2.setCellValue(employee.getWorkid());

            HSSFCell cell3=rowBody.createCell(3);
            cell3.setCellValue(employee.getGender());

            HSSFCell cell4=rowBody.createCell(4);
            cell4.setCellStyle(dateStyle);
            cell4.setCellValue(employee.getBirthday());

            HSSFCell cell5=rowBody.createCell(5);
            cell5.setCellValue(employee.getIdcard());

            HSSFCell cell6=rowBody.createCell(6);
            cell6.setCellValue(employee.getWedlock().toString());

            HSSFCell cell7=rowBody.createCell(7);
            cell7.setCellValue(employee.getNation().getName());


            HSSFCell cell8=rowBody.createCell(8);
            cell8.setCellValue(employee.getNativeplace());

            HSSFCell cell9=rowBody.createCell(9);
            cell9.setCellValue(employee.getPoliticsstatus().getName());


            HSSFCell cell10=rowBody.createCell(10);
            cell10.setCellValue(employee.getPhone());


            HSSFCell cell11=rowBody.createCell(11);
            cell11.setCellValue(employee.getAddress());

            HSSFCell cell12=rowBody.createCell(12);
            cell12.setCellValue(employee.getDepartment().getName());

            HSSFCell cell13=rowBody.createCell(13);
            cell13.setCellValue(employee.getJoblevel().getName());


            HSSFCell cell14=rowBody.createCell(14);
            cell14.setCellValue(employee.getPosition().getName());


            HSSFCell cell15=rowBody.createCell(15);
            cell15.setCellValue(employee.getEngageform());

            HSSFCell cell16=rowBody.createCell(16);
            cell16.setCellValue(employee.getTiptopdegree().toString());

            HSSFCell cell17=rowBody.createCell(17);
            cell17.setCellValue(employee.getSpecialty());

            HSSFCell cell18=rowBody.createCell(18);
            cell18.setCellValue(employee.getSchool());

            HSSFCell cell19=rowBody.createCell(19);
            cell19.setCellStyle(dateStyle);
            cell19.setCellValue(employee.getBegindate());

            HSSFCell cell20=rowBody.createCell(20);
            cell20.setCellValue(employee.getWorkstate().toString());

            HSSFCell cell21=rowBody.createCell(21);
            cell21.setCellValue(employee.getEmail());

            HSSFCell cell22=rowBody.createCell(22);
            cell22.setCellValue(employee.getContractterm().toString());

            HSSFCell cell23=rowBody.createCell(23);
            cell23.setCellStyle(dateStyle);
            cell23.setCellValue(employee.getBegincontract());

            HSSFCell cell24=rowBody.createCell(24);
            cell24.setCellStyle(dateStyle);
            cell24.setCellValue(employee.getEndcontract());

        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        HttpHeaders headers = new HttpHeaders();
        try {
            headers.setContentDispositionFormData("attachment",new String("员工表.xls".getBytes(),"ISO-8859-1"));
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

            workbook.write(byteArrayOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity(byteArrayOutputStream.toByteArray(),headers, HttpStatus.CREATED);
    }

    public static List employee2UploadExecl(MultipartFile file, List<Joblevel> joblevels, List<Position> positions, List<Nation> nations, List<Department> departments, List<Politicsstatus> politicsStatus) {
        List returnList = new ArrayList();

        try {
            HSSFWorkbook workbook = new HSSFWorkbook(file.getInputStream());
            HSSFSheet sheetAt = workbook.getSheetAt(0);
            for (int i = 1; i <= sheetAt.getLastRowNum(); i++) {
                HSSFRow row = sheetAt.getRow(i);
                Employee employee = new Employee();
                for (int j = 1; j < row.getLastCellNum(); j++) {
                    HSSFCell cell = row.getCell(j);
                    CellType cellType = cell.getCellType();
                    switch (cellType){
                        case STRING:
                            switch (j){
                                case 1:
                                    employee.setName(cell.getStringCellValue().trim());
                                    break;
                                case 2:
                                    employee.setWorkid(cell.getStringCellValue().trim());
                                    break;
                                case 3:
                                    employee.setGender(cell.getStringCellValue().trim());
                                    break;
                                case 5:
                                    employee.setIdcard(cell.getStringCellValue().trim());
                                    break;
                                case 6:
                                    employee.setWedlock(cell.getStringCellValue().trim());
                                    break;
                                case 7:
                                    int nIndex = nations.indexOf(new Nation(cell.getStringCellValue().trim()));
                                    Nation nation = nations.get(nIndex);
                                    employee.setNation(nation);
                                    employee.setNationid(nation.getId());
                                    break;
                                case 8:
                                    employee.setNativeplace(cell.getStringCellValue().trim());
                                    break;
                                case 9:
                                    int psIndex = politicsStatus.indexOf(new Politicsstatus(cell.getStringCellValue().trim()));
                                    Politicsstatus politicsstatus = politicsStatus.get(psIndex);
                                    employee.setPoliticsstatus(politicsstatus);
                                    employee.setPoliticid(politicsstatus.getId());
                                    break;
                                case 10:
                                    employee.setPhone(cell.getStringCellValue().trim());
                                    break;
                                case 11:
                                    employee.setAddress(cell.getStringCellValue().trim());
                                    break;
                                case 12:
                                    int deptIndex = departments.indexOf(new Department(cell.getStringCellValue().trim()));
                                    Department department = departments.get(deptIndex);
                                    employee.setDepartment(department);
                                    employee.setDepartmentid(department.getId());
                                    break;
                                case 13:
                                    int jobIndex = joblevels.indexOf(new Joblevel(cell.getStringCellValue().trim()));
                                    Joblevel joblevel = joblevels.get(jobIndex);
                                    employee.setJoblevel(joblevel);
                                    employee.setJoblevelid(joblevel.getId());
                                    break;
                                case 14:
                                    int posIndex = positions.indexOf(new Position(cell.getStringCellValue().trim()));
                                    Position position = positions.get(posIndex);
                                    employee.setPosition(position);
                                    employee.setPosid(position.getId());
                                    break;
                                case 15:
                                    employee.setEngageform(cell.getStringCellValue().trim());
                                    break;
                                case 16:
                                    employee.setTiptopdegree(cell.getStringCellValue().trim());
                                    break;
                                case 17:
                                    employee.setSpecialty(cell.getStringCellValue().trim());
                                    break;
                                case 18:
                                    employee.setSchool(cell.getStringCellValue().trim());
                                    break;
                                case 20:
                                    employee.setWorkstate(cell.getStringCellValue().trim());
                                    break;
                                case 21:
                                    employee.setEmail(cell.getStringCellValue().trim());
                                    break;
                                case 22:
                                    employee.setContractterm(cell.getStringCellValue().trim());
                                    break;
                                default:
                                    throw new IllegalStateException("String类型未找到数据，行【"+ i+"】列【"+ j+"】" );
                            }
                            break;
                        default:
                            switch (j){
                                case 4:
                                    Date birthday = cell.getDateCellValue();
                                    employee.setBirthday(birthday);
                                    break;
                                case 19:
                                    Date begindate = cell.getDateCellValue();
                                    employee.setBegindate(begindate);
                                    break;
                                case 23:
                                    Date beginContract = cell.getDateCellValue();
                                    employee.setBegincontract(beginContract);
                                    break;
                                case 24:
                                    Date endContract = cell.getDateCellValue();
                                    employee.setEndcontract(endContract);
                                    break;
                            }
                            break;
                    }
                }
                returnList.add(employee);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return returnList;
    }
}

package com.example.demo.util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhangP
 * @Description
 * @since 2019-01-25 13:25
 */
public class ExcelUtil {

    /**
     * 根据excel存放的绝对路径返回读取的数据
     *
     * @param sourceFilePath excel存放的绝对路径
     * @param rowIndex       要读取excel第几列（从0开始）
     * @return
     */
    public static List<List<String>> readExcel(String sourceFilePath, Integer rowIndex) {
        Workbook workbook = null;

        try {
            workbook = getReadWorkBookType(sourceFilePath);
            List<List<String>> excelContents = new ArrayList<>();
            //获取第一个sheet
            Sheet sheet = workbook.getSheetAt(0);
            //第0行是表名，忽略，从第二行开始读取
            for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
                Row row = sheet.getRow(rowNum);
                List<String> rowContents = new ArrayList<>();
                for (int cellNum = 0; cellNum < row.getLastCellNum(); cellNum++){
                    Cell cell = row.getCell(cellNum);
                    rowContents.add(getCellStringVal(cell).trim());
                }
                excelContents.add(rowContents);
            }
            return excelContents;
        } finally {
            IOUtils.closeQuietly(workbook);
        }
    }

    private static Workbook getReadWorkBookType(String filePath) {
        /**
         * xls-2003, xlsx-2007
         * 根据不同excel格式进行处理
         */
        FileInputStream is = null;

        try {
            is = new FileInputStream(filePath);
            if (filePath.toLowerCase().endsWith("xlsx")) {
                return new XSSFWorkbook(is);
            } else if (filePath.toLowerCase().endsWith("xls")) {
                return new HSSFWorkbook(is);
            } else {
                //  抛出自定义的业务异常
                System.out.println("excel格式文件错误");
                return null;
            }
        } catch (IOException e) {
            //  抛出自定义的业务异常
            System.out.println("excel格式文件错误");
            return null;
        } finally {
            IOUtils.closeQuietly(is);
        }
    }


    private static String getCellStringVal(Cell cell) {
        /**
         * 将所有的类型转为String类型处理
         */
        CellType cellType = cell.getCellTypeEnum();
        switch (cellType) {
            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue());
            case STRING:
                return cell.getStringCellValue();
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            case BLANK:
                return "";
            case ERROR:
                return String.valueOf(cell.getErrorCellValue());
            default:
                return "";
        }
    }
}

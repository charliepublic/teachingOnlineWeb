package com.aneon.utils;

import com.aneon.po.Student;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellReference;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadExcel {
    public static List<Student> inputStudent(File file) {
        List<Student> result = new ArrayList<>();
        Workbook workbook = null;
        try {
            workbook = WorkbookFactory.create(file);
        } catch (IOException | InvalidFormatException e) {
            e.printStackTrace();
        }
        if(workbook != null) {
            Sheet sheet = workbook.getSheetAt(0);
            DataFormatter formatter = new DataFormatter();
            for (Row row: sheet) {
                String Snumber = null, Sname = null;
                for (Cell cell: row) {
                    String cellRef = (new CellReference(row.getRowNum(), cell.getColumnIndex())).formatAsString();
                    if(cellRef.equals("学号"))
                        Snumber = formatter.formatCellValue(cell);
                    else if (cellRef.equals("姓名"))
                        Sname = formatter.formatCellValue(cell);
                }
                if(Snumber != null && Sname != null) {
                    if(Snumber.length() == 14)
                        result.add(new Student(Snumber, Sname, Snumber.substring(8)));
                }
            }
        }
        return result;
    }
}

package com.example.demo;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadFileExcel {
    public static void main(String[] args) throws FileNotFoundException {
        String filePath = "excel/Book1.xlsx";
        try {
            List<Employee> employees = readFile(filePath);
            System.out.println(employees);

            //Hiển thị kết quả
            for (Employee employee : employees) {
                System.out.println("Employee: " + employee.getName());
                System.out.println("Working days:");
                for (AttendanceDay attendanceDay : employee.getAttendanceDays()) {
                    System.out.println("Date: " + attendanceDay.getDate());
                    System.out.println("Total hours: " + attendanceDay.getHours());
                    System.out.println("Shifts: " + attendanceDay.getShifts());
                    System.out.println("day amount: "+attendanceDay.getAmount());
                }
                System.out.println("Total amount: " + employee.getTotalAmount());
                System.out.println("Compare amount: " + employee.getCompareAmount());
                System.out.println("Total compared to column Q: " + compareDouble(employee.getCompareAmount(),employee.getTotalAmount(),0.01)  );
                System.out.println("------------------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static List<Employee> readFile(String file) throws IOException {
        List<Employee> listEmployee = new ArrayList<>();

//        Tạo hàm đọc file
        FileInputStream fis = new FileInputStream(new File(file));
        Workbook workbook = new XSSFWorkbook(fis);
//      trang tính đầu tiên trong file excel
        Sheet sheet = workbook.getSheetAt(0);
//        lưu ngày,index cột
        Map<Integer, Integer> map1 = new HashMap<>();
//        lưu index cột,tên ca
        Map<Integer, String> map2 = new HashMap<>();
//        lưu tên ca,cột chỉ giá tiền
        Map<String, Integer> map3 = new HashMap<>();

        boolean isFirstDate = true;
        int index = 0; // đánh dấu số thứ tự chỉ cột đầu tiên trong tháng.
        int indexQ = 0; // đánh dấu số thứ tự chỉ cột tổng lương

//  loop1:    ánh xa  ngày,index cột
        Row row3 = sheet.getRow(3);
        int day = 0;
        //        trích xuất các giá trị số ngày

        for (int i = 0; i <= row3.getLastCellNum(); i++) {
            Cell cell = row3.getCell(i);
//            kiểm tra xem giá trị này có phải cell là null hay không và loại ô của nó có phải là số hay không
            if (cell != null && cell.getCellTypeEnum() == CellType.NUMERIC) {
                day = (int) cell.getNumericCellValue();
                if (isFirstDate == true) {
                    index = i;
                    indexQ = index - 1;
                    isFirstDate = false;
                }
            }
            map1.put(i, day);
        }
        int firstDay = map1.get(index);
        String idShift = "";
        //    loop2 : ánh xạ indễx tên cột,tên ca
        Row row5 = sheet.getRow(5);
        //        trich xuất các giá trị tên ca

        for (int i = 0; i < row5.getLastCellNum(); i++) {
            Cell cell = row5.getCell(i);
            if (cell != null && cell.getCellTypeEnum() == CellType.STRING) {
                idShift = cell.getStringCellValue();
            }
            map2.put(i, idShift);
        }
//        xác định loại  ca
        List<String> shifts = new ArrayList<>();

        for (int i = 0; i < index; i++) {
            Cell cell = row5.getCell(i);

            if (cell != null && cell.getCellTypeEnum() == CellType.STRING) {
                String shift = cell.getStringCellValue();

                if (shift.equals("$")) {
                    for (String shiftName : shifts) {
                        map3.put(shiftName, i);
                    }
                    shifts.clear();
                } else {
                    shifts.add(shift);
                }
            }
        }
//        duyệt nhân viên
        for (int i = 6; i <= 9; i++) {
            // Lấy thông tin tháng và năm từ hàng 0
            Row row6 = sheet.getRow(0);
            int month = (int) row6.getCell(0).getNumericCellValue();
            int year = (int) row6.getCell(1).getNumericCellValue();

            // Lấy thông tin của nhân viên từ hàng hiện tại (i)
            Row row = sheet.getRow(i);
            String name = row.getCell(2).getStringCellValue();
            double compareAmount = row.getCell(indexQ).getNumericCellValue();

            // Khởi tạo đối tượng Employee và cập nhật thông tin
            Employee employee = new Employee();
            employee.setName(name);
            employee.setCompareAmount(compareAmount);

            // Khởi tạo biến và danh sách để lưu trữ thông tin ngày làm việc
            AttendanceDay attendanceDay = null;
            int currentDate = -1; // Ngày hiện tại, khởi tạo không hợp lệ
            double hour = 0.0;
            double amount = 0.0;
            List<String> dayShifts = new ArrayList<>();
            boolean hasEncounteredFirstDay = false;

            // Xử lý thông tin từ cột index đến cuối cùng
            for (int j = index; j <= row.getLastCellNum(); j++) {
                int indexDay = map1.get(j);

                // Kiểm tra ngày đầu tiên của tháng và cập nhật tháng/năm
                if (firstDay != 1) {
                    if (indexDay == 1 && !hasEncounteredFirstDay) {
                        if (month == 12) {
                            month = 1;
                            year++;
                        } else {
                            month++;
                        }
                        hasEncounteredFirstDay = true;
                    }
                }

                // Lấy thông tin từng ô trong hàng hiện tại
                Cell cell = row.getCell(j);

                // Xử lý nếu ô chứa số (giờ làm việc)
                if (cell != null && cell.getCellTypeEnum() == CellType.NUMERIC && cell.getNumericCellValue() > 0.0) {
                    int date = map1.get(j); // Lấy ngày từ map1

                    // Xử lý khi gặp ngày mới
                    if (date != currentDate) {
                        if (attendanceDay != null) {
                            employee.addAttendanceDay(attendanceDay);
                        }
                        hour = 0.0;
                        amount = 0.0;
                        dayShifts = new ArrayList<>();
                        attendanceDay = new AttendanceDay();
                    }

                    // Cập nhật giờ làm việc
                    double hourCell = cell.getNumericCellValue();
                    hour += hourCell;

                    // Lấy ca làm việc từ map2
                    String shift = map2.get(j);
                    dayShifts.add(shift);

                    // Cập nhật số tiền (amount) dựa trên ca làm việc và giờ làm việc
                    if (map3.containsKey(shift)) {
                        int indexMoney = map3.get(shift);
                        double money = row.getCell(indexMoney).getNumericCellValue();
                        amount += hourCell * money;
                    }

                    // Cập nhật thông tin ngày làm việc
                    attendanceDay.setDate(date + "/" + month + "/" + year);
                    attendanceDay.setHours(hour);
                    attendanceDay.setAmount(amount);
                    attendanceDay.setShifts(dayShifts);

                    // Cập nhật ngày hiện tại
                    currentDate = date;
                }
            }

            // Thêm attendanceDay cuối cùng vào danh sách ngày làm việc của nhân viên
            if (attendanceDay != null) {
                employee.addAttendanceDay(attendanceDay);
            }

            // Thêm thông tin nhân viên vào danh sách
            listEmployee.add(employee);
        }


        return listEmployee;
    }
    public static boolean compareDouble (double num1, double num2, double epsilon){
        return Math.abs(num1-num2) < epsilon;
    }

}

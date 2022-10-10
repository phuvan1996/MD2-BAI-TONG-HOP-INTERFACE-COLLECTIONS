package ra;

import java.util.Scanner;

public class StudentClass implements IStudentManagement {
    private String ClassId;
    private String ClassName;
    private String Descriptions;
    private int ClassStatus;

    public StudentClass() {
    }

    public StudentClass(String classId, String className, String descriptions, int classStatus) {
        ClassId = classId;
        ClassName = className;
        Descriptions = descriptions;
        ClassStatus = classStatus;
    }

    public String getClassId() {
        return ClassId;
    }

    public void setClassId(String classId) {
        ClassId = classId;
    }

    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String className) {
        ClassName = className;
    }

    public String getDescriptions() {
        return Descriptions;
    }

    public void setDescriptions(String descriptions) {
        Descriptions = descriptions;
    }

    public int getClassStatus() {
        return ClassStatus;
    }

    public void setClassStatus(int classStatus) {
        ClassStatus = classStatus;
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.println("nhap vao ma lop");
        do {
            this.ClassId = scanner.nextLine();
            if (this.ClassId.trim().length()<=5){
            }else {
                System.err.println("vui lòng nhập lại gồm 5 kí tự");
            }if (this.ClassId.charAt(0)=='j'){
                break;
            }else {
                System.err.println("vui lòng nhập kí tự bắt đầu bằng 'j");
            }
        }while (true);
        System.out.println("nhập vào tên lớp");
        do {
            this.ClassName=scanner.nextLine();
            if (this.ClassName.trim().length()<=10){
                break;
            }else {
                System.err.println("vui lòng nhập tên lớp tối đa 10 kí tự");
            }
        }while (true);
        System.out.println(" nhập vào mô tả lớp");
        this.Descriptions = scanner.nextLine();
        System.out.println("nhập vào trạng thái lớp ");
        this.ClassStatus = Integer.parseInt(scanner.nextLine());
    }

    @Override
    public void displayData() {
        System.out.printf("ClassID: %s - ClassName: %s - Descriptions: %s - ClassStatus: %d\n",this.ClassId,this.ClassName,this.Descriptions,this.ClassStatus);
    }
}

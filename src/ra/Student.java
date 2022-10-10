package ra;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student implements IStudentManagement {
    private String studentID;
    private String studentName;
    private int age;
    private boolean sex;
    private StudentClass studentClass;
    private List<Float> listMarkJavaScrip = new ArrayList<>();
    private List<Float> listMarkJavaCore = new ArrayList<>();
    private List<Float> listMarkJavaWeb = new ArrayList<>();
    private float avgMark;
    private String gpa;
    private boolean studentStatus;

    public Student() {
    }

    public Student(String studentID, String studentName, int age, boolean sex, StudentClass studentClass, List<Float> listMarkJavaScrip, List<Float> listMarkJavaCore, List<Float> listMarkJavaWeb, float avgMark, String gpa, boolean studentStatus) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.age = age;
        this.sex = sex;
        this.studentClass = studentClass;
        this.listMarkJavaScrip = listMarkJavaScrip;
        this.listMarkJavaCore = listMarkJavaCore;
        this.listMarkJavaWeb = listMarkJavaWeb;
        this.avgMark = avgMark;
        this.gpa = gpa;
        this.studentStatus = studentStatus;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public StudentClass getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(StudentClass studentClass) {
        this.studentClass = studentClass;
    }

    public List<Float> getListMarkJavaScrip() {
        return listMarkJavaScrip;
    }

    public void setListMarkJavaScrip(List<Float> listMarkJavaScrip) {
        this.listMarkJavaScrip = listMarkJavaScrip;
    }

    public List<Float> getListMarkJavaCore() {
        return listMarkJavaCore;
    }

    public void setListMarkJavaCore(List<Float> listMarkJavaCore) {
        this.listMarkJavaCore = listMarkJavaCore;
    }

    public List<Float> getListMarkJavaWeb() {
        return listMarkJavaWeb;
    }

    public void setListMarkJavaWeb(List<Float> listMarkJavaWeb) {
        this.listMarkJavaWeb = listMarkJavaWeb;
    }

    public float getAvgMark() {
        return avgMark;
    }

    public void setAvgMark(float avgMark) {
        this.avgMark = avgMark;
    }

    public String getGpa() {
        return gpa;
    }

    public void setGpa(String gpa) {
        this.gpa = gpa;
    }

    public boolean isStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(boolean studentStatus) {
        this.studentStatus = studentStatus;
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.println("nhập vào mã sinh viên");
        do {
            this.studentID = scanner.nextLine();
            if (this.studentID.trim().length()<= 6) {
                if (this.studentID.trim().charAt(0) == 's') {
                    break;
                } else {
                    System.err.println("vui lòng nhập mã sinh viên bắt đầu bằng kí tự 's");
                }
            } else {
                System.err.println("vui lòng nhập mã gồm 6 kí tự");
            }
        } while (true);
        System.out.println("nhập vào tên sinh viên");
        do {
            this.studentName = scanner.nextLine();
            if (this.studentName.trim().length() <= 20 && this.studentName.trim().length() <= 50) {
                break;
            } else {
                System.out.println("vui lòng nhập tên sinh viên tối đa 50 kí tự");
            }
        } while (true);
        System.out.println("nhập vào tuổi sinh viên");
        do {
            this.age = Integer.parseInt(scanner.nextLine());
            if (this.age >= 18) {
                break;
            } else {
                System.err.println("vui lòng nhập tuổi > hoặc = 18");
            }
        } while (true);
        System.out.println("nhập vào giới tính sinh viên");
        this.sex = Boolean.parseBoolean(scanner.nextLine());
        int cnt = 1;
        System.out.println("nhập các điểm thi javascrip");
        inputMark(listMarkJavaScrip, scanner );
        System.out.println("nhập các điểm thi javaCore");
        inputMark(listMarkJavaCore, scanner);
        System.out.println("nhập các điểm thi javaWeb");
        inputMark(listMarkJavaWeb, scanner);
        System.out.println("nhập vào trạng thái sinh viên");
        this.studentStatus = Boolean.parseBoolean(scanner.nextLine());
    }

    public static void inputMark(List<Float> listMark, Scanner scanner) {
        int cnt = listMark.size()+1;
        do {
            System.out.printf("nhập điểm thi lần %d: \n", cnt);
            listMark.add(Float.parseFloat(scanner.nextLine()));
            cnt++;
            System.out.printf("bạn có muốn nhập điểm thi lần %d không:\n", cnt);
            System.out.println("1.yes");
            System.out.println("2.No");
            System.out.println("lựa chọn của bạn");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice != 1) {
                break;
            }
        } while (true);
    }

    @Override
    public void displayData() {
        System.out.printf("studentId: %s - studentName: %s - Age: %d - sex: %b - class: %s\n", this.studentID, this.studentName, this.age, this.sex, this.studentClass.getClassName());
        System.out.println("điểm JavaScrips: ");
        for (Float js_Mark : listMarkJavaScrip) {
            System.out.printf("%f\t", js_Mark);
        }
        System.out.printf("\n");
        System.out.println("điểm JavaCore: ");
        for (Float jv_Mark : listMarkJavaCore) {
            System.out.printf("%f\t", jv_Mark);
        }
        System.out.printf("\n");
        System.out.println("điểm JavaWeb: ");
        for (Float web_Mark : listMarkJavaWeb) {
            System.out.printf("%f\t", web_Mark);
            System.out.printf("\n");
            System.out.printf("điểm TB: %f - xếp loại: %s - trạng thái: %b\n",this.avgMark,this.gpa,this.studentStatus);
        }
    }
    public void  callAvgMark(){
        this.avgMark= (listMarkJavaScrip.get(listMarkJavaScrip.size()-1)+listMarkJavaCore.get(listMarkJavaCore.size()-1)+listMarkJavaWeb.get(listMarkJavaWeb.size()-1))/3;
    }
    public void getGPA(){
        if (this.avgMark<5){
            this.gpa="yếu";
        } else if (this.avgMark<7) {
            this.gpa="trung binh";
        } else if (this.avgMark<9) {
            this.gpa="kha";
        }else {
            this.gpa="gioi";
        }
    }
}
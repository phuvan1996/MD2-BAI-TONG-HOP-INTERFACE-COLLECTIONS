package ra.run;

import ra.Student;
import ra.StudentClass;

import java.util.*;

public class  StudentManagement {
    static List<StudentClass> listClass = new ArrayList<>();
    static List<Student> listStudent = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("------QUẢN LÝ HỌC VIỆN-----");
            System.out.println("1.quản lý lớp học");
            System.out.println("2.quản lý sinh viên");
            System.out.println("3.thoát");
            System.out.println("sự lựa chọn của bạn");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    StudentManagement.getClassManagement(scanner);
                    break;
                case 2:
                    StudentManagement.getStudentManagement(scanner);
                    break;
                case 3:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("vui lòng chọn từ 1-3");
                    break;
            }
        } while (true);
    }

    public static void getClassManagement(Scanner scanner) {
        boolean classExit = true;
        do {
            System.out.println("-------QUẢN LÝ LỚP HỌC-----");
            System.out.println("1.thêm mới lớp học");
            System.out.println("2.cập nhật thông tin lớp học");
            System.out.println("3.hiển thị thông tin lớp học");
            System.out.println("4.thống kê các lớp học đang hoạt động");
            System.out.println("5.tìm kiếm lớp học theo tên lớp học");
            System.out.println("6.thoát");
            System.out.println("sự lựa chọn của bạn");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    StudentManagement.inputClass(scanner);
                    break;
                case 2:
                    StudentManagement.updateClass(scanner);
                    break;
                case 3:
                    StudentManagement.displayClass();
                    break;
                case 4:
                    StudentManagement.statisticalClass();
                    break;
                case 5:
                    StudentManagement.searchClass(scanner);
                    break;
                case 6:
                    classExit = false;
                default:
                    System.out.println("vui lòng chọn từ 1-6");
                    break;
            }
        } while (classExit);
    }
    public static void inputClass(Scanner scanner){
        System.out.println("nhập vào số lớp cần thêm");
        int cnt = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < cnt; i++) {
            StudentClass studentClass = new StudentClass();
            studentClass.inputData(scanner);
            listClass.add(studentClass);
        }
    }
    public static void displayClass(){
        for (int i = 0; i < listClass.size(); i++) {
            listClass.get(i).displayData();
        }
    }
    public static void searchClass(Scanner scanner){
        System.out.println("nhập vào tên lớp cần tìm kiếm");
        String nameClass = scanner.nextLine();
        for (int i = 0; i < listClass.size(); i++) {
            if (nameClass.toLowerCase().equals(listClass.get(i).getClassName())){
                listClass.get(i).displayData();
                break;
            }else {
                System.out.println("tên không có trong danh sách");
            }
        }
    }
    //cap nhat thong tin lop hoc
    public static void updateClass(Scanner scanner){
        System.out.println("nhap vao ma lop can cap nhat thong tin");
        String classId = scanner.nextLine();
        boolean exitClass = false;
        for (StudentClass studentClass:listClass) {
            if (studentClass.getClassId().equals(classId)){
                System.out.println("nhap vao ten lop can cap nhat");
                String className = scanner.nextLine();
                if (className!=""&&className.length()!=0){
                    //cap nhat lop
                    studentClass.setClassName(className);
                }
                System.out.println("nha vao mo ta lop can cap nhat");
                String description = scanner.nextLine();
                if (description!=""&&description.length()!=0){
                    studentClass.setDescriptions(description);
                }
                studentClass.setDescriptions(description);
            }
            System.out.println("nhap vao trang thai lop can cap nhat");
            String classStatus = scanner.nextLine();
            if (classStatus!=""&&classStatus.length()!=0){
                studentClass.setClassStatus(Integer.parseInt(scanner.nextLine()));
            }
            exitClass = true;
            break;
        }
    }
//thong ke lop hoc dang hoat dong.
    public  static void statisticalClass(){
        System.out.println("danh sach cac lop hoc dang hoat dong");
        int countstatis= 0;
        for (StudentClass studentClass:listClass) {
            if (studentClass.getClassStatus()==0){
                studentClass.displayData();
                countstatis++;
            }
        }
        System.out.printf("co %d lop dang hoat dong\n",countstatis);
    }
    public static void getStudentManagement(Scanner scanner) {
        boolean StudentExit = true;
        do {
            System.out.println("-------QUẢN LÝ SINH VIÊN-----");
            System.out.println("1.thêm mới sinh viên");
            System.out.println("2.cập nhật thông tin sinh viên");
            System.out.println("3.hiển thị thông tin sinh viên");
            System.out.println("4.Tính điểm trung bình");
            System.out.println("5.xếp loại sinh viên");
            System.out.println("6.sắp xếp sinh viên theo điểm trung bình tăng dần");
            System.out.println("7.tìm kiếm sinh viên theo tên sinh viên");
            System.out.println("8.thống kê số sinh viên đạt loại giỏi,khá,trung bình và yếu");
            System.out.println("9.thống kê các sinh viên pass qua các môn học");
            System.out.println("10.thoát");
            System.out.println("sự lựa chọn của bạn");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    StudentManagement.inputStudent(scanner);
                    break;
                case 2:
                    StudentManagement.updateStudent(scanner);
                    break;
                case 3:
                    StudentManagement.displayStudent();
                    break;
                case 4:
                    StudentManagement.avgScore();
                    break;
                case 5:
                    StudentManagement.classificationStudent();
                    break;
                case 6:
                    StudentManagement.sortstudentsbygradepointaverage();
                    break;
                case 7:
                    StudentManagement.searchStudent(scanner);
                    break;
                case 8:
                    StudentManagement.statisticsByPerformance();
                    break;
                case 9:
                    StudentManagement.statisticPassStudent();
                    break;
                case 10:
                    StudentExit = false;
                default:
                    System.out.println("vui lòng chọn từ 1-6");
            }
        } while (StudentExit);
    }
    public static void inputStudent(Scanner scanner){
        System.out.println("nhập số sinh viên cần nhập thông tin");
        int cnt = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < cnt; i++) {
            Student studentNew = new Student();
            studentNew.inputData(scanner);
            System.out.println("chon lop hoc cho sinh vien");
           int index = 1;
            for (StudentClass studentClass:listClass) {
                System.out.printf("%d.%s\n",index,studentClass.getClassName());
                index++;
            }
            System.out.print("sự lựa chọn của bạn");
            int choice = Integer.parseInt(scanner.nextLine());
            studentNew.setStudentClass(listClass.get(choice-1));
            listStudent.add(studentNew);
        }
    }
    public static void displayStudent(){
        System.out.println("thong tin snh vien");
        for (Student student:listStudent) {
            student.displayData();
        }
    }
    public static void avgScore(){
        for (int i = 0; i < listStudent.size(); i++) {
            listStudent.get(i).callAvgMark();
        }
        System.out.println("điểm trung bình đã được cập nhật!");
    }
    public static void classificationStudent(){
        for (int i = 0; i < listStudent.size(); i++) {
            listStudent.get(i).getGPA();
        }
        System.out.println("xếp loại thành công");
    }
   public static void sortstudentsbygradepointaverage(){
        Collections.sort(listStudent, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return (int) (o1.getAvgMark()- o2.getAvgMark());
            }
        });
   }
    public static void searchStudent(Scanner scanner){
        System.out.println("nhập tên sinh viên cần tìm");
        String nameStudent = scanner.nextLine();
        for (int i = 0; i <listStudent.size(); i++) {
            if (nameStudent.toLowerCase().equals(listStudent.get(i).getStudentName())){
                listStudent.get(i).displayData();
                break;
            }else {
                System.out.println("tên sinh viên không tồn tại");
            }
        }
    }
    //cap nhat thong tin sinh vien
    public static void updateStudent(Scanner scanner){
        System.out.println("nhap thong tin sinh vien can cap nhat");
       String studentIdupdate = scanner.nextLine();
        for (Student student:listStudent) {
            if (student.getStudentID().equals(studentIdupdate)){
                System.out.println("nhap vao ten sinh vien can cap nhat");
                String studentName = " ";
                do {
                    studentName = scanner.nextLine();
                    if (studentName!=""&&studentName.length()!=0){
                        if (studentName.length()<=6&&studentName.length()<50){
                            student.setStudentName(studentName);
                            break;
                        }else {
                            System.err.println("vui long nhap ten sinh vien tu 6- 50 ki tu");
                        }
                    }
                }while (true);
                System.out.println("nhap vao tuoi sinh vien can cap nhat");
                String age = "";
                do {
                    age = scanner.nextLine();
                    if (age!=""&&age.length()!=0){
                        if (Integer.parseInt(age)>=18){
                            student.setAge(Integer.parseInt(age));
                            break;
                        }else {
                            System.out.println("vui long nhap tuoi sinh vien lon hon 18");
                        }
                    }

                }while (true);
                System.out.println("nhap vao gioi tinh can cap nhat");
                String sex = scanner.nextLine();
                if (sex!=""&&sex.length()!=0){
                    student.setSex(Boolean.parseBoolean(sex));
                }
                //cap nhat lop cho sinh vien
                System.out.println("chon lop cho sinh vien");
                int cntClass = 1;
                for (StudentClass studentClass:listClass) {
                    System.out.printf("%d.%s\n",cntClass,studentClass.getClassName());
                    cntClass++;
                }
                System.out.printf("%d.khong cap nhat lop\n",cntClass);
                System.out.print("su lua chon cua ban");
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice!=cntClass){
                    student.setStudentClass(listClass.get(choice-1));
                }
//                System.out.println("cap nhat diem javascript cho sinh vien");
//                System.out.println("1.nhap moi diem cho sinh vien");
//                System.out.println("2.them moi diem chosinh vien");
//                System.out.println("3.cap nhat 1 diem trong danh sach");
//                System.out.println("su lua chon cua ban");
//                int choiceJS = Integer.parseInt(scanner.nextLine());
//                switch (choiceJS){
//                    case 1:
//                        List<Float> listJS =  new ArrayList<>();
//                        Student.inputMark(listJS,scanner);
//                        student.setListMarkJavaScrip(listJS);
//                        break;
//                    case 2:
//                        Student.inputMark(student.getListMarkJavaScrip(),scanner);
//                        break;
//                    case 3:
//                        System.out.println("nhap vao lan thi muon cap nhat");
//                        int Lanthi = Integer.parseInt(scanner.nextLine());
//                        System.out.println("nhap vao diem thi");
//                        float mark = Float.parseFloat(scanner.nextLine());
//                        student.getListMarkJavaScrip().set(Lanthi-1,mark);
//                        break;
//                }
                StudentManagement.updateStudentMark(student.getListMarkJavaScrip(),scanner,student,"Javascript");
                StudentManagement.updateStudentMark(student.getListMarkJavaCore(),scanner,student,"javaCore");
                StudentManagement.updateStudentMark(student.getListMarkJavaWeb(),scanner,student,"javaWeb");
                student.getAvgMark();
                student.getGpa();
                System.out.println("nhap vao trang thai sinb vien can cap nhat");
                String studentStatus = scanner.nextLine();
                if (studentStatus!=""&&studentStatus.length()!=0){
                    student.setStudentStatus(Boolean.parseBoolean(studentStatus));
                }
            }
        }
    }

    public static void updateStudentMark(List<Float> lisMark,Scanner scanner,Student student,String subject){
        System.out.println("cap nhat diem javaCore cho sinh vien\n");
        System.out.println("1.nhap moi diem cho sinh vien");
        System.out.println("2.them moi diem chosinh vien");
        System.out.println("3.cap nhat 1 diem trong danh sach");
        System.out.println("su lua chon cua ban");
        int choiceJS = Integer.parseInt(scanner.nextLine());
        switch (choiceJS){
            case 1:
                List<Float> listJS =  new ArrayList<>();
                Student.inputMark(listJS,scanner);
                student.setListMarkJavaScrip(listJS);
                break;
            case 2:
                Student.inputMark(student.getListMarkJavaScrip(),scanner);
                break;
            case 3:
                System.out.println("nhap vao lan thi muon cap nhat");
                int Lanthi = Integer.parseInt(scanner.nextLine());
                System.out.println("nhap vao diem thi");
                float mark = Float.parseFloat(scanner.nextLine());
                student.getListMarkJavaScrip().set(Lanthi-1,mark);
                break;
        }
    }
    public static void statisticsByPerformance(){
        int good = 0;
        int normal = 0;
        int average = 0;
        int weak= 0;
        for (Student student:listStudent) {
            if (Objects.equals(student.getGpa(),"giỏi")){
                good++;
            }if (Objects.equals(student.getGpa(),"khá")){
                normal++;
            }if (Objects.equals(student.getGpa(),"trung bình")){
                average++;
            }if (Objects.equals(student.getGpa(),"yếu")){
                weak++;
            }
        }
    }
    public static void statisticPassStudent(){
        int cntPass=0;
        for (Student student:listStudent) {
            int jsSize = student.getListMarkJavaScrip().size();
            int jvSize = student.getListMarkJavaCore().size();
            int jwSize = student.getListMarkJavaWeb().size();
            if (student.getAvgMark()>=5&&student.getListMarkJavaScrip().get(jsSize-1)>5&&student.getListMarkJavaCore().get(jvSize-1)>5&&student.getListMarkJavaWeb().get(jwSize-1)>=5){
                System.out.println("so sinh vien pass qua cac mon hoc");
                cntPass++;
            }
        }
        System.out.printf("co %d hoc sinh Pass\n",cntPass);
    }
}
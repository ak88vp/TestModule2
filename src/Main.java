import model.Phonebook;
import model.Regex;
import sevier.ManagerPhonebook;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ManagerPhonebook managerPhonebook = getManagerPhonebook();
        int choice = 88;
        while (choice != 8) {
            System.out.println("------CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ--------");
            System.out.println(" 1 : Xem danh sách");
            System.out.println(" 2 : Thêm mới");
            System.out.println(" 3 : Cập nhập");
            System.out.println(" 4 : Xóa");
            System.out.println(" 5 : Tìm kiếm");
            System.out.println(" 6 : Ghi từ file");
            System.out.println(" 7 : Đọc vào file");
            System.out.println(" 8 : Thoát");
            System.out.println(" Chọn chức năng :");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
//                    ManagerPhonebook.getInstance().print();
                    print();
                    break;
                case 2:
                    add(scanner, managerPhonebook);
                    writer(managerPhonebook);
                    readFile();
                    break;
                case 3:
                    update(scanner, managerPhonebook);
                    writer(managerPhonebook);
                    readFile();
                    break;
                case 4:
                    System.out.println("Nhập tên người mà bạn muốn xóa trong danh bạ");
                    scanner.nextLine();
                    String nameDelete = scanner.nextLine();
                    if (managerPhonebook.find(nameDelete) != -1) {
                        managerPhonebook.delete(nameDelete);
                        writer(managerPhonebook);
                        readFile();
                    } else System.out.println("Danh bạ không có người này");
                    break;
                case 5:
                    System.out.println("Nhập tên người mà bạn muốn tìm trong danh bạ");
                    scanner.nextLine();
                    String nameFind = scanner.nextLine();
                    if (managerPhonebook.find(nameFind) != -1) {
                        managerPhonebook.findName(nameFind);
                    } else System.out.println("Danh bạ không có người này");
                    break;
                case 6:
                    writer(managerPhonebook);
                    break;
                case 7:
                    print();
                    break;


            }

        }
    }

    private static void print() {
        try (FileReader fileReader2 = new FileReader("PhoneBook.csv")) {
            BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
            String str3;
            System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------------------");
            while ((str3 = bufferedReader2.readLine()) != null) {
                String[] str2 = str3.split(",");
                for (String s : str2) {
                    System.out.printf(ANSI_YELLOW + "  %-27s|", s + ANSI_RESET);
                }
                System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------------------");
            }
            bufferedReader2.close();
        } catch (IOException i) {
            System.out.println();
        }
    }

    private static void writer(ManagerPhonebook managerPhonebook) {
        try {
            FileWriter fileWriter = new FileWriter("PhoneBook.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String str = "Tên , Ngày tháng năm sinh,Giới tính,Địa chỉ, Nhóm,Số điện thoại";
            for (int j = 0; j < managerPhonebook.getListPhonebook().size(); j++) {
                str += "\n" + managerPhonebook.getListPhonebook().get(j).getName() + "," + managerPhonebook.getListPhonebook().get(j).getDateOfBirth() + "," +
                        managerPhonebook.getListPhonebook().get(j).getSex() + "," + managerPhonebook.getListPhonebook().get(j).getAddress() + ","
                        + managerPhonebook.getListPhonebook().get(j).getClub() + "," + managerPhonebook.getListPhonebook().get(j).getNumberPhone();
            }
            bufferedWriter.write(str);
            bufferedWriter.close();
        } catch (IOException ignored) {
        }
    }

    private static ManagerPhonebook getManagerPhonebook() {
        return ManagerPhonebook.getInstance();
    }

    private static void update(Scanner scanner, ManagerPhonebook managerPhonebook) {
        System.out.println("Nhập tên người mà bạn muốn sửa trong danh bạ");
        scanner.nextLine();
        String nameEdit = scanner.nextLine();
        if (managerPhonebook.find(nameEdit) != -1) {
            System.out.println("Thêm tên :");
            scanner.nextLine();
            String newName = scanner.nextLine();
            System.out.println("Ngày tháng năm sinh :");
            String newDateOfBirth = scanner.nextLine();
            if (Regex.validateOfBirth(newDateOfBirth)) {
                System.out.println(" Giới tính:");
                String newSex = scanner.nextLine();
                System.out.println("Địa chỉ :");
                String newAddress = scanner.nextLine();
                System.out.println("Nhóm danh bạ :");
                String newClub = scanner.nextLine();
                System.out.println("Số điện thoại :");
                String newNumberPhone = scanner.nextLine();
                if (Regex.validateNumberPhone(newNumberPhone)) {
                    System.out.println("Nhập email :");
                    String newEmail = scanner.nextLine();
                    if (Regex.validateEmail(newEmail)) {
                        managerPhonebook.edit(nameEdit, new Phonebook(newName, newDateOfBirth, newSex, newAddress, newClub, newNumberPhone, newEmail));
                        System.out.println("Sửa thành công");
                    }

                    return;
                } else System.out.println("Sai số điện thoại");
                return;
            } else System.out.println("Sai định dạng ngày tháng");
            return;
        } else System.out.println("Không tìm thấy người này trong danh bạ");
    }

    private static void add(Scanner scanner, ManagerPhonebook managerPhonebook) {
        System.out.println("Thêm tên :");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("Ngày tháng năm sinh :");
        String dateOfBirth = scanner.nextLine();
        if (Regex.validateOfBirth(dateOfBirth)) {
            System.out.println(" Giới tính:");
            String sex = scanner.nextLine();
            System.out.println("Địa chỉ :");
            String address = scanner.nextLine();
            System.out.println("Nhóm danh bạ :");
            String club = scanner.nextLine();
            System.out.println("Số điện thoại :");
            String numberPhone = scanner.nextLine();
            if (Regex.validateNumberPhone(numberPhone)) {
                System.out.println("Nhập emai :");
                String email = scanner.nextLine();
                managerPhonebook.add(new Phonebook(name, dateOfBirth, sex, address, club, numberPhone, email));
                System.out.println("Thêm thành công");
                return;
            } else System.out.println("Sai số điện thoại");
            return;
        } else System.out.println("Sai định dạng ngày tháng");
    }

    public static void readFile() {
        try {
            ArrayList<Phonebook> list = new ArrayList<>();
            FileReader fileReader = new FileReader("PhoneBook.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String str = bufferedReader.readLine();
            while ((str = bufferedReader.readLine()) != null) {
                String[] str2 = str.split(",");
                String name = str2[0];
                String dateOfBirth = str2[1];
                String sex = str2[2];
                String address = str2[3];
                String club = str2[4];
                String numberPhone = str2[5];
                String email = str2[6];
                list.add(new Phonebook(name, dateOfBirth, sex, address, club, numberPhone, email));
            }
            getManagerPhonebook().setListPhonebook(list);
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println();
        }
    }
}

package model;

public class Phonebook {
    private String name;
    private String dateOfBirth;
    private String sex;
    private String address;
    private String club;
    private String numberPhone;
    private String email;
    private final static Phonebook instance = new Phonebook();

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public static Phonebook getInstance() {
        return instance;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public Phonebook(String name, String dateOfBirth, String sex, String address, String club, String numberPhone, String email) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.address = address;
        this.club = club;
        this.numberPhone = numberPhone;
        this.email = email;
    }

    private Phonebook() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    @Override
    public String toString() {
        return "Danh bạ{" +
                "Tên '" + name + '\'' +
                ", Ngày tháng năm sinh'" + dateOfBirth + '\'' +
                ", Giới tính'" + sex + '\'' +
                ", Địa chỉ'" + address + '\'' +
                ", Nhóm danh bạ '" + club + '\'' +
                ", Số điện thoại '" + numberPhone + '\'' +
                ", Email '" + email + '\'' +
                '}';
    }
}

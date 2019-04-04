package entity;


public class Student  {
    private String rollNumber;
    private String name;
    private int age;
    private String address;
    private int phone;
    private String email;

    public Student() {
    }

    public Student(String rollNumber, String name, int age, String address, int phone, String email) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.address = address;
        this.phone = phone;
        this.email = email;

    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}


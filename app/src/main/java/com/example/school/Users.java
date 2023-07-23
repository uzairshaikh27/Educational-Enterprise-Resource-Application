package com.example.school;

public class Users {
    String student_name, student_roll, student_attendance, today_date;

    public Users() {
    }



    public Users(String today_date ,  String student_attendance,String student_roll, String student_name) {
        this.today_date = today_date;
        this.student_name = student_name;
        this.student_roll = student_roll;
        this.student_attendance = student_attendance;

    }

    public String getToday_date() {
        return today_date;
    }

    public void setToday_date(String today_date) {
        this.today_date = today_date;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_roll() {
        return student_roll;
    }

    public void setStudent_roll(String student_roll) {
        this.student_roll = student_roll;
    }

    public String getStudent_attendance() {
        return student_attendance;
    }

    public void setStudent_attendance(String student_attendance) {
        this.student_attendance = student_attendance;
    }
}

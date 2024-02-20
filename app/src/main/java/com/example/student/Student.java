package com.example.student;

public class Student {
        private String studentID;
        private String studentName;
        private String studentAge;
        private String studentAddress;
        private String studentEmail;
        private String Register;

        public Student(String studentID, String studentName, String studentAge, String studentAddress, String studentEmail) {
            this.studentID = studentID;
            this.studentName = studentName;
            this.studentAge = studentAge;
            this.studentAddress = studentAddress;
            this.studentEmail = studentEmail;
        }

        public String getStudentID() {
            return studentID;
        }

        public String getStudentName() {
            return studentName;
        }

        public String getStudentAge() {
            return studentAge;
        }

        public String getStudentAddress() {
            return studentAddress;
        }

        public String getStudentEmail() {
            return studentEmail;
        }
    }

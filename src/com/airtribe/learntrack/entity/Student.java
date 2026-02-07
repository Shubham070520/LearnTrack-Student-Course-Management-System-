package com.airtribe.learntrack.entity;

public class Student extends Person {

        private String batch;
        private boolean active;

        // Constructor WITHOUT email
        public Student(int id, String firstName, String lastName, String batch) {
            super(id, firstName, lastName, null);
            this.batch = batch;
            this.active = true;
        }

        // Constructor WITH email (Overloading)
        public Student(int id, String firstName, String lastName, String email, String batch) {
            super(id, firstName, lastName, email);
            this.batch = batch;
            this.active = true;
        }

        // Polymorphism
        @Override
        public String getDisplayName() {
            return "Student: " + firstName + " " + lastName;
        }

        public String getBatch() {
            return batch;
        }
        public boolean isActive() {
            return active;
        }

        public void setBatch(String batch) {
            this.batch = batch;
        }
        public void setActive(boolean active) {
            this.active = active;
        }
    }

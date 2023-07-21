package com.vtopacademy.schools;

public class SchoolResponse {

    private final int schoolID;
    private final int number;
    private final String name;

    public SchoolResponse(int schoolID, int number, String name) {
        this.schoolID = schoolID;
        this.number = number;
        this.name = name;
    }

    public int getSchoolID() {
        return schoolID;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}

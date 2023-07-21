package com.vtopacademy.schools;

import java.util.Date;

public class School {
    private final int schoolID;
    private final int number;
    private final String name;
    private Date dateSavedToLocalDatabase;

    public School(int schoolID, int number, String name) {
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

    public Date getDateSavedToLocalDatabase() {
        return dateSavedToLocalDatabase;
    }

    public void setDateSavedToLocalDatabase(Date dateSavedToLocalDatabase) {
        this.dateSavedToLocalDatabase = dateSavedToLocalDatabase;
    }
}

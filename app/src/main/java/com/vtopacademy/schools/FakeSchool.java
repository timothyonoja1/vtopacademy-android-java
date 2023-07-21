package com.vtopacademy.schools;

import java.util.ArrayList;
import java.util.List;

public class FakeSchool {

    public FakeSchool() {

    }

    public List<School> getFakeSchools() {
        List<School> schools = new ArrayList<>();
        schools.add(new School(1, 1, "Senior Secondary"));
        return schools;
    }
}

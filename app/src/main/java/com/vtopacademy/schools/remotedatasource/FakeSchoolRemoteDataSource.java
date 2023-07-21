package com.vtopacademy.schools.remotedatasource;

import com.vtopacademy.schools.FakeSchool;
import com.vtopacademy.schools.School;
import java.util.List;
import javax.inject.Inject;

/** Fake School remote data source implementation class. Used for unit testing */
public class FakeSchoolRemoteDataSource implements SchoolRemoteDataSource {

    /** Constructs a new instance. */
    @Inject
    public FakeSchoolRemoteDataSource() {

    }

    @Override
    public List<School> getAllSchools() {
        FakeSchool fakeSchool = new FakeSchool();
        List<School> schools = fakeSchool.getFakeSchools();
        return schools;
    }
}

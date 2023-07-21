package com.vtopacademy.schools.repository;

import com.vtopacademy.ResultCallback;
import com.vtopacademy.schools.FakeSchool;
import com.vtopacademy.schools.School;
import java.util.List;
import javax.inject.Inject;

/** Fake school repository implementation class. Used for unit testing only. */
public class FakeSchoolRepository implements SchoolRepository {

    /** Constructs a new instance. */
    @Inject
    public FakeSchoolRepository(){

    }

    @Override
    public void getAllSchools(ResultCallback<List<School>> callback) {
        callback.onComplete(getAllSchoolsSync());
    }

    @Override
    public List<School> getAllSchoolsSync() {
        FakeSchool fakeSchool = new FakeSchool();
        return fakeSchool.getFakeSchools();
    }
}
package com.vtopacademy.schools.localdatasource;

import com.vtopacademy.schools.School;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/** Fake School local data source implementation class. Used for unit testing only. */
public class FakeSchoolLocalDataSource implements SchoolLocalDataSource {

    private final List<School> schools = new ArrayList<>();
    private boolean outdated = true;

    /** Constructs a new instance. */
    @Inject
    public FakeSchoolLocalDataSource() {

    }

    @Override
    public boolean isOutdated() {
        return outdated;
    }

    @Override
    public List<School> getAllSchools() {
        return schools;
    }

    @Override
    public boolean updateSchools(List<School> schools) {
        deleteAllSchools();
        this.schools.addAll(schools);
        outdated = false;
        return true;
    }

    @Override
    public boolean deleteAllSchools() {
        schools.clear();
        outdated = true;
        return true;
    }
}

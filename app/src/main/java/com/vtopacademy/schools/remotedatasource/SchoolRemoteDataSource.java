package com.vtopacademy.schools.remotedatasource;

import com.vtopacademy.schools.School;
import java.util.List;

/** School remote data source interface. */
public interface SchoolRemoteDataSource {

    /** Returns all schools. */
    List<School> getAllSchools();

}

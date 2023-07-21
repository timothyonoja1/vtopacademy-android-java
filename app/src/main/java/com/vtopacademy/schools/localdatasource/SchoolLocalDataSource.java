package com.vtopacademy.schools.localdatasource;

import com.vtopacademy.schools.School;
import java.util.List;

/** School local data source interface. */
public interface SchoolLocalDataSource {

    /** Checks whether school local data source is up-to-date. */
    boolean isOutdated();

    /** Returns all schools. */
    List<School> getAllSchools();

    /** Returns true after updating successfully. */
    boolean updateSchools(List<School> schools);

    /** Returns true after deleting successfully. */
    boolean deleteAllSchools();
}

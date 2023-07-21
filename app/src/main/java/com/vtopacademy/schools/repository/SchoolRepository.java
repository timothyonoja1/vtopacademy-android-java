package com.vtopacademy.schools.repository;

import com.vtopacademy.ResultCallback;
import com.vtopacademy.schools.School;
import java.util.List;

/** Repository interface for schools. */
public interface SchoolRepository {

    /** Returns and posts all schools to the callback.
     *  This should be called on the main thread.
     *  For other threads, call getAllSchoolsSync() instead. */
    void getAllSchools(ResultCallback<List<School>> callback);

    /** Returns all categories. */
    List<School> getAllSchoolsSync();
}

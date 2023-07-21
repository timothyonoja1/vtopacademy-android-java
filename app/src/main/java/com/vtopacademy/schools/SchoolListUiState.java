package com.vtopacademy.schools;

import java.util.List;

/** UI state for school list screen. */
public class SchoolListUiState {

    private final boolean fetchingSchools;
    private final List<School> schools;

    /** Constructs a new instance. */
    public SchoolListUiState(
            boolean fetchingSchools,
            List<School> schools) {
        this.fetchingSchools = fetchingSchools;
        this.schools = schools;
    }

    /** Checks whether schools are currently being fetched. */
    public boolean isFetchingSchools() {
        return fetchingSchools;
    }

    /** Returns all schools. */
    public List<School> getSchools() {
        return schools;
    }
}

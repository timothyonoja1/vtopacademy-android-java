package com.vtopacademy.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.vtopacademy.schools.School;
import com.vtopacademy.schools.SchoolListUiState;

/** State holder interface for the ui screens. */
public interface MainViewModel {

    /** Returns SchoolListUiState. */
    MutableLiveData<SchoolListUiState> getSchoolListUiState();

    /** Sets selected school. */
    void setSelectedSchool(School school);

}

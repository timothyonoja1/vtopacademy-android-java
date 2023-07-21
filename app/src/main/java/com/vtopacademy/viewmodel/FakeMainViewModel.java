package com.vtopacademy.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.vtopacademy.schools.FakeSchool;
import com.vtopacademy.schools.School;
import com.vtopacademy.schools.SchoolListUiState;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import dagger.hilt.android.lifecycle.HiltViewModel;

/** Fake MainViewModel implementation class. */
@HiltViewModel
public class FakeMainViewModel extends ViewModel implements MainViewModel {

    private School selectedSchool;

    /* Constructs a new instance */
    @Inject
    public FakeMainViewModel() {

    }

    @Override
    public MutableLiveData<SchoolListUiState> getSchoolListUiState() {
        MutableLiveData<SchoolListUiState> schoolListUiState
                = new MutableLiveData<>();
        FakeSchool fakeSchool = new FakeSchool();
        List<School> fakeSchools = fakeSchool.getFakeSchools();
        schoolListUiState.setValue(new SchoolListUiState(false, fakeSchools));
        return schoolListUiState;
    }

    @Override
    public void setSelectedSchool(School school) {
        selectedSchool = school;
    }

}

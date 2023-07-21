package com.vtopacademy.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.vtopacademy.schools.School;
import com.vtopacademy.schools.SchoolListUiState;
import com.vtopacademy.schools.repository.SchoolRepository;
import java.util.ArrayList;
import javax.inject.Inject;
import dagger.hilt.android.lifecycle.HiltViewModel;

/** MainViewModel implementation class. */
@HiltViewModel
public class MainViewModelImpl extends ViewModel implements MainViewModel {

    private final SchoolRepository schoolRepository;
    private final MutableLiveData<SchoolListUiState> schoolListUiState;
    private School selectedSchool;

    /** Constructs a new instance. */
    @Inject
    public MainViewModelImpl(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
        schoolListUiState = new MutableLiveData<>();
    }

    @Override
    public MutableLiveData<SchoolListUiState> getSchoolListUiState() {
        schoolListUiState.setValue(
                new SchoolListUiState(true, new ArrayList<>()));
        getAllSchools();
        return schoolListUiState;
    }

    private void getAllSchools() {
        schoolRepository.getAllSchools(result -> schoolListUiState
                .setValue(new SchoolListUiState(false, result)));
    }

    @Override
    public void setSelectedSchool(School school) {
        selectedSchool = school;
    }
}

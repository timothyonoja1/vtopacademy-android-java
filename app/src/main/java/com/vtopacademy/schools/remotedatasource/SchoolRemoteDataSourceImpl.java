package com.vtopacademy.schools.remotedatasource;

import com.vtopacademy.retrofit.ApiService;
import com.vtopacademy.schools.School;
import com.vtopacademy.schools.SchoolResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import retrofit2.Call;

/** SchoolRemoteDataSource implementation class. */
public class SchoolRemoteDataSourceImpl implements SchoolRemoteDataSource {

    private final ApiService apiService;

    /** Constructs a new instance. */
    @Inject
    public SchoolRemoteDataSourceImpl(ApiService apiService){
        this.apiService = apiService;
    }

    @Override
    public List<School> getAllSchools() {
        Call<List<SchoolResponse>> apiCall = apiService.getAllSchools();
        try {
            List<SchoolResponse> schoolResponses = apiCall.execute().body();
            if (schoolResponses == null) {
                return new ArrayList<>();
            }
            return convertToSchools(schoolResponses);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return new ArrayList<>();
        }
    }

    private List<School> convertToSchools(List<SchoolResponse> schoolResponses) {
        List<School> schools = new ArrayList<>();
        Date todaysDate = new Date();
        for (SchoolResponse schoolResponse : schoolResponses) {
            School school = new School(schoolResponse.getSchoolID(),
                    schoolResponse.getNumber(), schoolResponse.getName());
            school.setDateSavedToLocalDatabase(todaysDate);
            schools.add(school);
        }
        return schools;
    }
}

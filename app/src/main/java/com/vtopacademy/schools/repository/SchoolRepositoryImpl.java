package com.vtopacademy.schools.repository;

import com.vtopacademy.ResultCallback;
import com.vtopacademy.schools.School;
import com.vtopacademy.schools.localdatasource.SchoolLocalDataSource;
import com.vtopacademy.schools.remotedatasource.SchoolRemoteDataSource;
import java.util.List;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import android.os.Handler;

/** SchoolRepository Implementation class. */
public class SchoolRepositoryImpl implements SchoolRepository {

    private final SchoolRemoteDataSource schoolRemoteDataSource;
    private final SchoolLocalDataSource schoolLocalDataSource;
    private final Executor executor;
    private final Handler resultHandler;

    /** Constructs a new instance. */
    @Inject
    public SchoolRepositoryImpl(
            SchoolRemoteDataSource schoolRemoteDataSource,
            SchoolLocalDataSource schoolLocalDataSource,
            Executor executor, Handler resultHandler
    ) {
        this.schoolRemoteDataSource = schoolRemoteDataSource;
        this.schoolLocalDataSource = schoolLocalDataSource;
        this.executor = executor;
        this.resultHandler = resultHandler;
    }

    @Override
    public void getAllSchools(ResultCallback<List<School>> callback) {
        executor.execute(() -> {
            List<School> result = getAllSchoolsSync();
            postResultToMainThread(result, callback);
        });
    }

    @Override
    public List<School> getAllSchoolsSync() {
        if (schoolLocalDataSource.isOutdated()){
            refreshSchools();
        }
        return schoolLocalDataSource.getAllSchools();
    }

    private void refreshSchools() {
        List<School> results = schoolRemoteDataSource.getAllSchools();
        if (results.isEmpty()){
            return;
        }
        schoolLocalDataSource.updateSchools(results);
    }

    private void postResultToMainThread(
            final List<School> result,
            final ResultCallback<List<School>> callback
    ){
        resultHandler.post(() -> callback.onComplete(result));
    }
}

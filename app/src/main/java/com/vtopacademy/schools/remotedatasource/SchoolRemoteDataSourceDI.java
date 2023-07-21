package com.vtopacademy.schools.remotedatasource;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

/** Injects school remote data source. */
@Module
@InstallIn(SingletonComponent.class)
public abstract class SchoolRemoteDataSourceDI {

    /** Injects SchoolRemoteDataSource implementation with given parameter. */
    @Binds
    public abstract SchoolRemoteDataSource bindSchoolRemoteDataSource(
            FakeSchoolRemoteDataSource fakeSchoolRemoteDataSourceIml
    );

}

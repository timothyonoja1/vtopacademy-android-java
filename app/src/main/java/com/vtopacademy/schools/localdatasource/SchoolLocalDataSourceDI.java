package com.vtopacademy.schools.localdatasource;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

/** Injects school local data source. */
@Module
@InstallIn(SingletonComponent.class)
public abstract class SchoolLocalDataSourceDI {

    /** Injects SchoolLocalDataSource implementation with given parameter. */
    @Binds
    public abstract SchoolLocalDataSource bindSchoolLocalDataSource(
            FakeSchoolLocalDataSource fakeSchoolLocalDataSourceIml
    );

}

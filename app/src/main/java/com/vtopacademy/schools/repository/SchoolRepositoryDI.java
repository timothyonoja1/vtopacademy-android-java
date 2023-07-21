package com.vtopacademy.schools.repository;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

/** Injects school repository. */
@Module
@InstallIn(SingletonComponent.class)
public abstract class SchoolRepositoryDI {

    /** Injects SchoolRepository implementation with given parameter. */
    @Binds
    public abstract SchoolRepository bindSchoolRepository(
            SchoolRepositoryImpl schoolRepositoryImpl
    );

}

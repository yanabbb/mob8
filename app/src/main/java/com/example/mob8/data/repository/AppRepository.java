package com.example.mob8.data.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.mob8.data.AppDatabase;
import com.example.mob8.data.data_source.AppData;
import com.example.mob8.data.model.ItemModel;
import com.example.mob8.data.model.PeopleEntity;

import java.util.List;

public class AppRepository {
    private AppDatabase appDatabase;

    public AppRepository(Application application) {
        appDatabase = AppDatabase.getDataBase(application);
    }
    public LiveData<List<PeopleEntity>> getAllPeople() {
        return appDatabase.peopleDao().getAllItems();
    }

    public void addPeople(PeopleEntity people) {
        AppDatabase.databaseWriterExecutor.execute(() -> {
            appDatabase.peopleDao().insert(people);
        });
    }

    public LiveData<List<ItemModel>> getStudentsData() { return AppData.buildStudentsData(); }
    public LiveData<List<ItemModel>> getTeachersData() { return AppData.buildTeachersData(); }
    public LiveData<String> getNavigateButtonStudents() { return AppData.getNavigateToStudents(); }
    public LiveData<String> getNavigateButtonTeachers() { return AppData.getNavigateToTeachers(); }
    public LiveData<String> getStudentsTitle() { return AppData.getStudentsTitle(); }
    public LiveData<String> getTeachersTitle() { return AppData.getTeachersTitle(); }
}

package com.example.mob8.ui.vm;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.mob8.data.model.PeopleEntity;
import com.example.mob8.data.repository.AppRepository;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    AppRepository appRepository;

    public LiveData<List<PeopleEntity>> getAllPeople() {
        return appRepository.getAllPeople();
    }
    public void addPerfumery(String name) {
        appRepository.addPeople(new PeopleEntity(name));
    }
    public MainViewModel(@NonNull Application application) {
        super(application);
        appRepository = new AppRepository(application);

    }
    public LiveData<String> getButtonNavigateToStudents() {
        return appRepository.getNavigateButtonStudents();
    }
    public LiveData<String> getButtonNavigateToTeachers() {
        return appRepository.getNavigateButtonTeachers();
    }
}

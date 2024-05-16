package com.example.mob8.ui.vm;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.mob8.data.model.ItemModel;
import com.example.mob8.data.repository.AppRepository;

import java.util.List;

public class RecyclerViewModel extends AndroidViewModel {
    private LiveData<List<ItemModel>> studentsData;
    private LiveData<List<ItemModel>> teachersData;
    private LiveData<String> studentsTitle;
    private LiveData<String> teachersTitle;
    public RecyclerViewModel(@NonNull Application application) {
        super(application);
        AppRepository appRepository = new AppRepository(application);
        studentsData = appRepository.getStudentsData();
        teachersData = appRepository.getTeachersData();
        studentsTitle = appRepository.getStudentsTitle();
        teachersTitle = appRepository.getTeachersTitle();
    }

    public LiveData<List<ItemModel>> getStudentsData() {
        return studentsData;
    }

    public LiveData<String> getStudentsTitle() {
        return studentsTitle;
    }

    public LiveData<List<ItemModel>> getTeachersData() {
        return teachersData;
    }

    public LiveData<String> getTeachersTitle() {
        return teachersTitle;
    }
}

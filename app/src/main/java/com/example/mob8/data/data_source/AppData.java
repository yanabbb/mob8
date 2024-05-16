package com.example.mob8.data.data_source;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mob8.R;
import com.example.mob8.data.model.ItemModel;

import java.util.ArrayList;
import java.util.List;

public class AppData {

    public static LiveData<List<ItemModel>> buildStudentsData() {
        MutableLiveData<List<ItemModel>> studentsData = new MutableLiveData<>();
        ArrayList<ItemModel> students = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            students.add(new ItemModel("Student № " + (i + 1), R.drawable.students));
        }
        studentsData.setValue(students);
        return studentsData;
    }

    public static LiveData<List<ItemModel>> buildTeachersData() {
        MutableLiveData<List<ItemModel>> teachersData = new MutableLiveData<>();
        ArrayList<ItemModel> teachers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            teachers.add(new ItemModel("Teacher № " + (i + 1), R.drawable.teachers));
        }
        teachersData.setValue(teachers);
        return teachersData;
    }

    public static LiveData<String> getNavigateToStudents() {
        MutableLiveData<String> data = new MutableLiveData<>();
        data.setValue("Перейти к студентам");
        return data;
    }

    public static LiveData<String> getNavigateToTeachers() {
        MutableLiveData<String> data = new MutableLiveData<>();
        data.setValue("Перейти к преподавателям");
        return data;
    }

    public static LiveData<String> getStudentsTitle() {
        MutableLiveData<String> data = new MutableLiveData<>();
        data.setValue("Студенты");
        return data;
    }

    public static LiveData<String> getTeachersTitle() {
        MutableLiveData<String> data = new MutableLiveData<>();
        data.setValue("Преподаватели");
        return data;
    }
}

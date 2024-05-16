package com.example.mob8.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.mob8.R;
import com.example.mob8.data.FileUtils;
import com.example.mob8.data.SharedPreferenceUtils;
import com.example.mob8.ui.vm.MainViewModel;

public class MainFragment extends Fragment {

    private MainViewModel viewModel;
    private Button buttonCheckStudents;
    private Button buttonCheckTeachers;
    private Button buttonNavigate;

    public MainFragment() {
        super(R.layout.fragment_main);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        FileUtils.writeToFile(requireContext(), "dataFile.txt", "startFragment");

        boolean result = FileUtils.writeToExternalStorage("example.txt", "текст");
        if (result) {
            Log.i("write", "Файл успешно создан и данные записаны");
        } else {
            Log.i("write", "Ошибка при создании файла или записи данных");
        }

        SharedPreferenceUtils.saveData(requireContext(), "data");

        viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        buttonCheckStudents = getActivity().findViewById(R.id.buttonStudents);
        buttonCheckTeachers = getActivity().findViewById(R.id.buttonTeachers);
        buttonNavigate = getActivity().findViewById(R.id.navigateToPeople);
        viewModel.getButtonNavigateToStudents().observe(getViewLifecycleOwner(), text ->
                buttonCheckStudents.setText(text));
        viewModel.getButtonNavigateToTeachers().observe(getViewLifecycleOwner(), text ->
                buttonCheckTeachers.setText(text));
        buttonCheckStudents.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString("key", "students");
            Navigation.findNavController(v).navigate(R.id.action_mainFragment_to_recyclerFragment, bundle);
        });
        buttonCheckTeachers.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString("key", "teachers");
            Navigation.findNavController(v).navigate(R.id.action_mainFragment_to_recyclerFragment, bundle);
        });
        buttonNavigate.setOnClickListener(v ->
                Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_peopleFragment));
    }
}
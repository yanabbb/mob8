package com.example.mob8.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mob8.R;
import com.example.mob8.ui.adapters.RecyclerViewAdapter;
import com.example.mob8.ui.vm.RecyclerViewModel;

public class RecyclerFragment extends Fragment {
    private RecyclerViewModel viewModel;
    private RecyclerView recyclerView;
    private TextView title;

    public RecyclerFragment() {super(R.layout.fragment_recycler); }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(requireActivity()).get(RecyclerViewModel.class);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = getActivity().findViewById(R.id.recyclerView);
        title = getActivity().findViewById(R.id.title);
        String data = getArguments().getString("key");
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        RecyclerViewAdapter adapter = new RecyclerViewAdapter();
        recyclerView.setAdapter(adapter);
        if (data == "students") {
            viewModel.getStudentsData().observe(getViewLifecycleOwner(), list ->
                    adapter.updateList(list));
            viewModel.getStudentsTitle().observe(getViewLifecycleOwner(), text->
                    title.setText(text));
        } else if (data == "teachers") {
            viewModel.getTeachersData().observe(getViewLifecycleOwner(), list ->
                    adapter.updateList(list));
            viewModel.getTeachersTitle().observe(getViewLifecycleOwner(), text->
                    title.setText(text));
        } 


    }
}
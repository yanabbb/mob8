package com.example.mob8.ui.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mob8.databinding.FragmentPeopleBinding;
import com.example.mob8.ui.adapters.PeopleAdapter;
import com.example.mob8.ui.vm.MainViewModel;


public class PeopleFragment extends Fragment {
    FragmentPeopleBinding binding;
    private MainViewModel viewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPeopleBinding.inflate(inflater);

        binding.listPeople.setLayoutManager(new LinearLayoutManager(requireContext()));
        PeopleAdapter adapter = new PeopleAdapter();
        binding.listPeople.setAdapter(adapter);

        binding.buttonAdd.setOnClickListener(v ->
                viewModel.addPerfumery(binding.editTextMediaName.getText().toString())
        );

        viewModel.getAllPeople().observe(getViewLifecycleOwner(), perfumery ->
                adapter.setPeopleEntities(perfumery));
        return binding.getRoot();
    }
}
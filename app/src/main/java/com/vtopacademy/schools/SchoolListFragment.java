package com.vtopacademy.schools;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.vtopacademy.databinding.FragmentSchoolListBinding;
import com.vtopacademy.viewmodel.FakeMainViewModel;
import com.vtopacademy.viewmodel.MainViewModel;
import com.vtopacademy.viewmodel.MainViewModelImpl;
import java.util.List;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class SchoolListFragment extends Fragment {

    private FragmentSchoolListBinding binding;
    private MainViewModel mainViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSchoolListBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mainViewModel = new ViewModelProvider(requireActivity())
                .get(MainViewModelImpl.class);
        mainViewModel.getSchoolListUiState().observe(getViewLifecycleOwner(),
                result -> {
                    if (result.isFetchingSchools()) {
                        binding.progressBar.setVisibility(View.VISIBLE);
                    }
                    else {
                        updateUI(result.getSchools());
                        binding.progressBar.setVisibility(View.GONE);
                    }
                }
        );
    }

    private void updateUI(List<School> schools) {
        SchoolAdapter schoolAdapter = new SchoolAdapter(schools, this::onClick);
        binding.recyclerView.setAdapter(schoolAdapter);
    }

    private void onClick(School school) {
        mainViewModel.setSelectedSchool(school);
        navigateToSubjectListFragment();
    }

    private void navigateToSubjectListFragment() {
        //NavDirections action = SchoolListFragmentDirections
        //        .actionSchoolListFragmentToKclassListFragment();
        //Navigation.findNavController(binding.getRoot()).navigate(action);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

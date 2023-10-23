package css.cis3334.project;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import css.cis3334.project.databinding.FragmentDashboardBinding;

public class FragmentDashboard extends Fragment {

    private FragmentDashboardBinding binding;
    private MainViewModel viewModel;
    RecyclerView recyclerViewOrder;
    RecycleViewAdapter recycleViewAdapter;
    OrderFirebaseData orderDataSource;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //DashboardViewModel dashboardViewModel =  new ViewModelProvider(this).get(DashboardViewModel.class);
        // Use the shared ViewModel
        viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerViewOrder = binding.recyclerViewOrder;
        recycleViewAdapter = new RecycleViewAdapter(orderDataSource);
        recyclerViewOrder.setAdapter(recycleViewAdapter);
        recyclerViewOrder.setLayoutManager(new LinearLayoutManager(getContext()));
        recycleViewAdapter.notifyDataSetChanged();
    }
}

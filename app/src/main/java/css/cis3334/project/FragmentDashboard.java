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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import css.cis3334.project.databinding.FragmentDashboardBinding;

public class FragmentDashboard extends Fragment {

    private FragmentDashboardBinding binding;
    private MainViewModel viewModel;
    RecyclerView recyclerViewOrder;
    RecycleViewAdapter recycleViewAdapter;
    OrderFirebaseData orderDataSource;
    DatabaseReference myOrderDBRef;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //DashboardViewModel dashboardViewModel =  new ViewModelProvider(this).get(DashboardViewModel.class);
        // Use the shared ViewModel
        viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        setupFirebaseDataChange();
        setupRecyclerView();

        return root;
    }

    //instantiate firebase data and build recycler view
    private void setupRecyclerView(){
        recyclerViewOrder = binding.recyclerViewOrder;
        orderDataSource = new OrderFirebaseData();
        orderDataSource.open();
        recycleViewAdapter = new RecycleViewAdapter(orderDataSource);
        recyclerViewOrder.setAdapter(recycleViewAdapter);
        recyclerViewOrder.setLayoutManager(new LinearLayoutManager(getContext()));
        recycleViewAdapter.notifyDataSetChanged();
    }

    //sets up firebase access
    private void setupFirebaseDataChange() {
        orderDataSource = new OrderFirebaseData();
        myOrderDBRef = orderDataSource.open();
        myOrderDBRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d("CIS3334", "Starting onDataChange()");
                orderDataSource.updateOrderList(dataSnapshot);
                recycleViewAdapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("CIS3334", "onCancelled: ");
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

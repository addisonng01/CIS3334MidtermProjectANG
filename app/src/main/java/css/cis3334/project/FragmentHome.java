package css.cis3334.project;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import css.cis3334.project.databinding.FragmentHomeBinding;

public class FragmentHome extends Fragment {

    private FragmentHomeBinding binding;
    private MainViewModel viewModel;
    ImageView ivHotdog;
    ImageView ivBurger;
    ImageView ivPizza;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        // Use the shared ViewModel
        viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //final TextView textView = binding.textHome;
        //viewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        setupImageViewClick();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void setupImageViewClick()
    {
        //sets up bindings with imageViews
        ivHotdog = binding.ivHotdog;
        ivBurger = binding.ivBurger;
        ivPizza = binding.ivPizza;

        ivHotdog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //creates intent with storefront_ui class
                Intent addActIntent = new Intent(v.getContext(), storefront_ui.class);
                //creates a key to be used in storefront_ui
                String intentHotdog = "keyHotdog";
                addActIntent.putExtra("strKey", intentHotdog);
                startActivity(addActIntent);
            }
        });

        ivBurger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addActIntent = new Intent(v.getContext(), storefront_ui.class);
                String intentBurger = "keyBurger";
                addActIntent.putExtra("strKey", intentBurger);
                startActivity(addActIntent);
            }
        });
        ivPizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addActIntent = new Intent(v.getContext(), storefront_ui.class);
                String intentPizza = "keyPizza";
                addActIntent.putExtra("strKey", intentPizza);
                startActivity(addActIntent);
            }
        });

    }
}

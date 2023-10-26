package css.cis3334.project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import css.cis3334.project.databinding.FragmentNotificationsBinding;

public class FragmentNotifications extends Fragment {

    private FragmentNotificationsBinding binding;
    private MainViewModel viewModel;
    EditText etEmail, etPhoneNum, etFirstName, etLastName;
    TextView tvEmail, tvPhone, tvName;
    Button buttonUpdate;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //NotificationsViewModel notificationsViewModel =  new ViewModelProvider(this).get(NotificationsViewModel.class);
        // Use the shared ViewModel
        viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        // Set the text in the shared ViewModel. This should appear in the other fragments.
        viewModel.setText("Notification Set !!!");

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //final TextView textView = binding.textNotifications;
        //viewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        setupButtonUpdate();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void setupButtonUpdate()
    {
        //binds ui to code
        buttonUpdate = binding.buttonUpdate;
        etEmail = binding.etEmail;
        etPhoneNum = binding.etPhoneNum;
        etFirstName = binding.etFirstName;
        etLastName = binding.etLastName;
        tvEmail = binding.tvEmail;
        tvPhone = binding.tvPhone;
        tvName = binding.tvName;

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //pulls text from the editText
                String email = etEmail.getText().toString();
                String phoneNum = etPhoneNum.getText().toString();
                String fname = etFirstName.getText().toString();
                String lname = etLastName.getText().toString();
                //sets textView with info
                tvName.setText("Name: " + fname + " " + lname);
                tvEmail.setText("Email Address: " + email);
                tvPhone.setText("Phone Number: " + phoneNum);
            }
        });
    }
}

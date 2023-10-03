package com.myapps.appdd.ui.logout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.myapps.appdd.R;

public class LogoutFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_logout,container,false);

        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);

        // Now, you can work with the Toolbar as needed
        if (toolbar != null) {
            // Example: Set a title for the Toolbar
            toolbar.setTitle("Log Out");
        }

        return root;
    }

}
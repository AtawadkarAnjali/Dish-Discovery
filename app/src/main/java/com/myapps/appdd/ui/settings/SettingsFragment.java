package com.myapps.appdd.ui.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.google.android.material.switchmaterial.SwitchMaterial;
import com.myapps.appdd.R;

import java.util.Objects;

public class SettingsFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_settings,container,false);

        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);

        // Now, you can work with the Toolbar as needed
        if (toolbar != null) {
            // Example: Set a title for the Toolbar
            toolbar.setTitle("Settings");
        }

        return root;
    }

}
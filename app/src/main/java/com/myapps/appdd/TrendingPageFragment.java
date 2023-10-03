package com.myapps.appdd;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.myapps.appdd.activities.TrendingRecipesActivity;

public class TrendingPageFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public TrendingPageFragment() {
        // Required empty public constructor
    }

    public static TrendingPageFragment newInstance(String param1, String param2) {
        TrendingPageFragment fragment = new TrendingPageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trending_page, container, false);

        // Access the Toolbar from the activity
        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);

        // Now, you can work with the Toolbar as needed
        if (toolbar != null) {
            // Example: Set a title for the Toolbar
            toolbar.setTitle("Popular Recipes");
        }

        Button popRecipes = view.findViewById(R.id.pop_recipes);
        popRecipes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TrendingRecipesActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
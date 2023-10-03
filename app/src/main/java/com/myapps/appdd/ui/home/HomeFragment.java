package com.myapps.appdd.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.myapps.appdd.Listeners.RandomRecipeResponseListener;
import com.myapps.appdd.R;
import com.myapps.appdd.activities.TrendingRecipesActivity;
import com.myapps.appdd.adapters.HomeAdapter;
import com.myapps.appdd.adapters.RecommendedAdapter;
import com.myapps.appdd.adapters.TrendingAdapter;
import com.myapps.appdd.models.HomeCategory;
import com.myapps.appdd.models.RecommendedModel;
import com.myapps.appdd.models.TrendingModel;

import java.util.ArrayList;
import java.util.List;
public class HomeFragment extends Fragment {

    RecyclerView trendingRec, homeCatRec, recommendedRec;
    FirebaseFirestore db;
    //Trending Recipes
    List<TrendingModel> trendingModelList;
    TrendingAdapter trendingAdapter;

    //Home Categories
    List<HomeCategory> categoryList;
    HomeAdapter homeAdapter;

    //Recommended Recipes
    List<RecommendedModel> recommendedModelList;
    RecommendedAdapter recommendedAdapter;

    RandomRecipeResponseListener randomRecipeResponseListener;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home,container,false);

        db = FirebaseFirestore.getInstance();

        trendingRec = root.findViewById(R.id.trend_rec);
        homeCatRec = root.findViewById(R.id.cat_rec);
        recommendedRec = root.findViewById(R.id.recommended_rec);

        //Trending Recipes
        trendingRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        trendingModelList = new ArrayList<>();
        trendingAdapter = new TrendingAdapter(getActivity(),trendingModelList);
        trendingRec.setAdapter(trendingAdapter);

        db.collection("TrendingRecipes")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                TrendingModel trendingModel = document.toObject(TrendingModel.class);
                                trendingModelList.add(trendingModel);
                                trendingAdapter.notifyDataSetChanged();
                            }
                        } else {
                            String errorMessage = task.getException().getMessage();
                            Toast.makeText(getActivity(),"Error"+task.getException(),Toast.LENGTH_LONG).show();
                        }
                    }
                });

        //Home Categories
        homeCatRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        categoryList = new ArrayList<>();
        homeAdapter = new HomeAdapter(getActivity(),categoryList);
        homeCatRec.setAdapter(homeAdapter);

        db.collection("HomeCategory")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                HomeCategory homeCategory = document.toObject(HomeCategory.class);
                                categoryList.add(homeCategory);
                                homeAdapter.notifyDataSetChanged();
                            }
                        } else {
                            String errorMessage = task.getException().getMessage();
                            Toast.makeText(getActivity(),"Error"+task.getException(),Toast.LENGTH_LONG).show();
                        }
                    }
                });

        //Recommended Recipes
        recommendedRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        recommendedModelList = new ArrayList<>();
        recommendedAdapter = new RecommendedAdapter(getActivity(),recommendedModelList);
        recommendedRec.setAdapter(recommendedAdapter);

        db.collection("Recommended")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                RecommendedModel recommendedModel = document.toObject(RecommendedModel.class);
                                recommendedModelList.add(recommendedModel);
                                recommendedAdapter.notifyDataSetChanged();
                            }
                        } else {
                            String errorMessage = task.getException().getMessage();
                            Toast.makeText(getActivity(),"Error"+task.getException(),Toast.LENGTH_LONG).show();
                        }
                    }
                });

        TextView viewAllTrending = root.findViewById(R.id.view_all_trending);

        viewAllTrending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TrendingRecipesActivity.class);
                startActivity(intent);
            }
        });

        TextView viewAllRecommended = root.findViewById(R.id.view_all_recommended);

        viewAllRecommended.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TrendingRecipesActivity.class);
                startActivity(intent);
            }
        });

        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);

        // Now, you can work with the Toolbar as needed
        if (toolbar != null) {
            // Example: Set a title for the Toolbar
            toolbar.setTitle("Dish Discovery");
        }

        return root;
    }

}



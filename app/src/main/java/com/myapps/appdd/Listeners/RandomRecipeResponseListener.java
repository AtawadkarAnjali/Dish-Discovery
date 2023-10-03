package com.myapps.appdd.Listeners;

import com.myapps.appdd.Models2.RandomRecipeApiResponse;

public interface RandomRecipeResponseListener {
    void didFetch(RandomRecipeApiResponse response, String message);
    void didError(String message);
}

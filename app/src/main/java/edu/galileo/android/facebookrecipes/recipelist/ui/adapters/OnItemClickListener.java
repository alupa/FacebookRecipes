package edu.galileo.android.facebookrecipes.recipelist.ui.adapters;

import edu.galileo.android.facebookrecipes.entities.Recipe;

/**
 * Created by Alvaro on 26-06-2016.
 */
public interface OnItemClickListener {
    void onFavClick(Recipe recipe);
    void onItemClick(Recipe recipe);
    void onDeleteClick(Recipe recipe);
}

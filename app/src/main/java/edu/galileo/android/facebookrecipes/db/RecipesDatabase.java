package edu.galileo.android.facebookrecipes.db;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by Alvaro on 22-06-2016.
 */
@Database(name = RecipesDatabase.NAME, version = RecipesDatabase.VERSION)
public class RecipesDatabase {
    public static final int VERSION = 1;
    public static final String NAME = "Recipes";
}

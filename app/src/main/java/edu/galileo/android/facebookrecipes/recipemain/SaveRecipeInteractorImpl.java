package edu.galileo.android.facebookrecipes.recipemain;

import edu.galileo.android.facebookrecipes.entities.Recipe;

/**
 * Created by Alvaro on 24-06-2016.
 */
public class SaveRecipeInteractorImpl implements SaveRecipeInteractor {
    RecipeMainRepository repository;

    public SaveRecipeInteractorImpl(RecipeMainRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(Recipe recipe) {
        repository.saveRecipe(recipe);
    }
}

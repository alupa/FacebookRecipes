package edu.galileo.android.facebookrecipes.recipelist;

/**
 * Created by Alvaro on 26-06-2016.
 */
public class RecipeListInteractorImpl implements RecipeListInteractor {
    private RecipeListRepository repository;

    public RecipeListInteractorImpl(RecipeListRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute() {
        repository.getSavedRecipes();
    }

    @Override
    public void searchFavs() {
        repository.getFavoriteRecipes();
    }
}

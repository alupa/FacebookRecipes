package edu.galileo.android.facebookrecipes.recipelist.di;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import edu.galileo.android.facebookrecipes.api.RecipeClient;
import edu.galileo.android.facebookrecipes.api.RecipeService;
import edu.galileo.android.facebookrecipes.entities.Recipe;
import edu.galileo.android.facebookrecipes.libs.base.EventBus;
import edu.galileo.android.facebookrecipes.libs.base.ImageLoader;
import edu.galileo.android.facebookrecipes.recipelist.RecipeListInteractor;
import edu.galileo.android.facebookrecipes.recipelist.RecipeListInteractorImpl;
import edu.galileo.android.facebookrecipes.recipelist.RecipeListPresenter;
import edu.galileo.android.facebookrecipes.recipelist.RecipeListPresenterImpl;
import edu.galileo.android.facebookrecipes.recipelist.RecipeListRepository;
import edu.galileo.android.facebookrecipes.recipelist.RecipeListRepositoryImpl;
import edu.galileo.android.facebookrecipes.recipelist.StoredRecipesInteractor;
import edu.galileo.android.facebookrecipes.recipelist.StoredRecipesInteractorImpl;
import edu.galileo.android.facebookrecipes.recipelist.ui.RecipeListView;
import edu.galileo.android.facebookrecipes.recipelist.ui.adapters.OnItemClickListener;
import edu.galileo.android.facebookrecipes.recipelist.ui.adapters.RecipesAdapter;
import edu.galileo.android.facebookrecipes.recipemain.GetNextRecipeInteractor;
import edu.galileo.android.facebookrecipes.recipemain.GetNextRecipeInteractorImpl;
import edu.galileo.android.facebookrecipes.recipemain.RecipeMainPresenter;
import edu.galileo.android.facebookrecipes.recipemain.RecipeMainPresenterImpl;
import edu.galileo.android.facebookrecipes.recipemain.RecipeMainRepository;
import edu.galileo.android.facebookrecipes.recipemain.RecipeMainRepositoryImpl;
import edu.galileo.android.facebookrecipes.recipemain.SaveRecipeInteractor;
import edu.galileo.android.facebookrecipes.recipemain.SaveRecipeInteractorImpl;
import edu.galileo.android.facebookrecipes.recipemain.ui.RecipeMainView;

/**
 * Created by Alvaro on 24-06-2016.
 */
@Module
public class RecipeListModule {
    RecipeListView view;
    OnItemClickListener clickListener;

    public RecipeListModule(OnItemClickListener clickListener, RecipeListView view) {
        this.clickListener = clickListener;
        this.view = view;
    }

    @Provides @Singleton
    RecipeListView providesRecipeListView(){
        return view;
    }

    @Provides @Singleton
    RecipeListPresenter providesRecipeListPresenter(EventBus eventBus, RecipeListInteractor listInteractor, StoredRecipesInteractor storedInteractor, RecipeListView view){
        return new RecipeListPresenterImpl(eventBus, listInteractor, storedInteractor, view);
    }

    @Provides @Singleton
    StoredRecipesInteractor providesStoredRecipesInteractor(RecipeListRepository repository){
        return new StoredRecipesInteractorImpl(repository);
    }

    @Provides @Singleton
    RecipeListInteractor providesRecipeListInteractor(RecipeListRepository repository){
        return new RecipeListInteractorImpl(repository);
    }

    @Provides @Singleton
    RecipeListRepository providesRecipeListRepository(EventBus eventBus){
        return new RecipeListRepositoryImpl(eventBus);
    }

    @Provides @Singleton
    RecipesAdapter providesRecipesAdapter(ImageLoader imageLoader, OnItemClickListener onItemClickListener, List<Recipe> recipeList){
        return new RecipesAdapter(imageLoader, onItemClickListener, recipeList);
    }

    @Provides @Singleton
    OnItemClickListener providesOnItemClickListener(){
        return this.clickListener;
    }

    @Provides @Singleton
    List<Recipe> providesEmptyList(){
        return new ArrayList<Recipe>();
    }
}

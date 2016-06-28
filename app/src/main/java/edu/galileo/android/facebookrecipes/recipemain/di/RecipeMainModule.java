package edu.galileo.android.facebookrecipes.recipemain.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import edu.galileo.android.facebookrecipes.api.RecipeClient;
import edu.galileo.android.facebookrecipes.api.RecipeService;
import edu.galileo.android.facebookrecipes.libs.base.EventBus;
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
public class RecipeMainModule {
    RecipeMainView view;

    public RecipeMainModule(RecipeMainView view) {
        this.view = view;
    }

    @Provides @Singleton
    RecipeMainView providesRecipeMainView(){
        return view;
    }

    @Provides @Singleton
    RecipeMainPresenter providesRecipeMainPresenter(EventBus eventBus, GetNextRecipeInteractor getNextInteractor, SaveRecipeInteractor saveInteractor, RecipeMainView view){
        return new RecipeMainPresenterImpl(eventBus, getNextInteractor, saveInteractor, view);
    }

    @Provides @Singleton
    SaveRecipeInteractor providesSaveRecipeInteractor(RecipeMainRepository repository){
        return new SaveRecipeInteractorImpl(repository);
    }

    @Provides @Singleton
    GetNextRecipeInteractor providesGetNextRecipeInteractor(RecipeMainRepository repository){
        return new GetNextRecipeInteractorImpl(repository);
    }

    @Provides @Singleton
    RecipeMainRepository providesRecipeMainRepository(EventBus eventBus, RecipeService service){
        return new RecipeMainRepositoryImpl(eventBus, service);
    }

    @Provides @Singleton
    RecipeService providesRecipeService(){
        return new RecipeClient().getRecipeService();
    }
}

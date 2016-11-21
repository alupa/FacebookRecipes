package edu.galileo.android.facebookrecipes.entities;

import org.junit.Test;

import edu.galileo.android.facebookrecipes.BaseTest;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by Alvaro on 20-11-2016.
 */
public class RecipeTest extends BaseTest {

    private final static String RECIPE_ID = "recipeId";
    private final static String TITLE = "title";
    private final static String IMAGE_URL = "imageUrl";
    private final static String SOURCE_URL = "sourceUrl";
    private final static boolean FAVORITE = false;

    private Recipe recipe;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        recipe = new Recipe();
    }

    @Test
    public void testGetSet() throws Exception {
        recipe.setRecipeId(RECIPE_ID);
        recipe.setTitle(TITLE);
        recipe.setImageURL(IMAGE_URL);
        recipe.setSourceURL(SOURCE_URL);
        recipe.setFavorite(FAVORITE);

        assertThat(recipe.getRecipeId(), is(RECIPE_ID));
        assertThat(recipe.getTitle(), is(TITLE));
        assertThat(recipe.getImageURL(), is(IMAGE_URL));
        assertThat(recipe.getSourceURL(), is(SOURCE_URL));
        assertThat(recipe.getFavorite(), is(FAVORITE));
    }

    @Test
    public void testEquals_True() throws Exception {
        recipe.setRecipeId(RECIPE_ID);

        Recipe other = new Recipe();
        other.setRecipeId(RECIPE_ID);

        boolean result = recipe.equals(other);
        assertTrue(result);
    }

    @Test
    public void testEquals_False() throws Exception {
        recipe.setRecipeId(RECIPE_ID);

        Recipe other = new Recipe();
        other.setRecipeId("other");

        boolean result = recipe.equals(other);
        assertFalse(result);
    }

    @Test
    public void testEquals_False_ObjectType() throws Exception {
        recipe.setRecipeId(RECIPE_ID);

        String other = "";

        boolean result = recipe.equals(other);
        assertFalse(result);
    }
}

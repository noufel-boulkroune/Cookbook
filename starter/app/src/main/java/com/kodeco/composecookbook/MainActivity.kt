package com.kodeco.composecookbook

import RecipeListViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.kodeco.composecookbook.ui.theme.ComposeCookbookTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        val viewModel = RecipeListViewModel()
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCookbookTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(modifier = Modifier.fillMaxSize()) {
                        TopAppBar(
                            title = {
                                Text(
                                    text = "Compose Cookbook",
                                    modifier = Modifier.testTag("topAppBarText")
                                )
                            },
                            colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.White),
                            modifier = Modifier.testTag("topAppBar")
                        )
                        RecipeList(viewModel)
                    }

                }
            }
        }
    }
}
//@Composable
//fun RecipeList(recipes: List<Recipe>) {
//    LazyColumn {
//        items(recipes) {recipe ->
//            RecipeCard(recipe,  Modifier.padding(16.dp))
//        }
//    }
//}


@Composable
fun RecipeList(viewModel: RecipeListViewModel) {
    // Convert the flow (of MutableStateList) into a State
    val recipeListState = viewModel.recipeListFlow.collectAsStateWithLifecycle()

    LazyColumn {
        items(recipeListState.value) {
            RecipeCard(it, Modifier.padding(16.dp)) // Added a modifier argument here
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
@Preview
fun RecipeCardPreview() {
    val viewModel = RecipeListViewModel()
    val previewRecipe = Recipe(
        imageResource = R.drawable.noodles,
        title = "Ramen",
        ingredients = listOf("Noodles", "Eggs", "Mushrooms", "Carrots", "Soy sauce"),
        description = "Japan’s famous noodles-and-broth dish. It’s meant to be slurped LOUDLY."
    )
    RecipeCard(previewRecipe, Modifier.padding(16.dp))
}
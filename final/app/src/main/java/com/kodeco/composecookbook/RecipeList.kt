package com.kodeco.composecookbook

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle

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

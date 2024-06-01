package com.kodeco.composecookbook

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun RecipeList(recipes: List<Recipe>) {
    LazyColumn {
        items(recipes) {
            RecipeCard(it, Modifier.padding(16.dp))
        }
    }
}

@Composable
@Preview
fun RecipeListPreview() {
    RecipeList(defaultRecipes)
}
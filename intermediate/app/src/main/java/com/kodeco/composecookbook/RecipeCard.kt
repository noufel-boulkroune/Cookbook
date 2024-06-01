package com.kodeco.composecookbook

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun RecipeCard(recipe: Recipe, modifier: Modifier) {
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.surface,
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.secondary),
        shape = RoundedCornerShape(12.dp),
        tonalElevation = 2.dp,
        shadowElevation = 10.dp
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Image(
                painterResource(recipe.imageResource),
                contentDescription = recipe.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth().height(144.dp)
            )
            Row {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = recipe.title,
                        style = MaterialTheme.typography.headlineLarge,
                        fontWeight = FontWeight(700)
                    )
                    for (ingredient in recipe.ingredients) {
                        Text(
                            text = "• $ingredient",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
                Column(modifier = Modifier.padding(16.dp)) {
                    Spacer(modifier = Modifier.height(42.dp))
                    Text(
                        text = recipe.description,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun RecipeCardPreview() {
    RecipeCard(defaultRecipes[0], Modifier.padding(16.dp))
}
package com.kodeco.composecookbook

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun RecipeCard(recipe: Recipe ,  modifier: Modifier) {
    Surface(
        color = MaterialTheme.colorScheme.surface,
        modifier = modifier,
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.secondary),
        shape = RoundedCornerShape(15.dp),
        tonalElevation = 2.dp,
        shadowElevation = 10.dp
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Image(
                painterResource(recipe.imageResource),
                contentDescription = recipe.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(175.dp)
            )
            Text(
                recipe.title,
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 8.dp),

                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight(700)
            )
            Row(modifier = Modifier.padding(16.dp, 0.dp, 16.dp, 16.dp)) {
                Column {
                    recipe.ingredients.forEach { ingredient ->
                        Text(text = "• $ingredient", style = MaterialTheme.typography.bodySmall)
                    }
                }
                Box(Modifier.width(30.dp))

                Text(recipe.description, style = MaterialTheme.typography.bodySmall)

            }
        }
    }

}

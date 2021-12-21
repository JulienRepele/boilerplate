package com.repele.boilerplate.presentation.composable.element

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun GridElement(
    title: String,
    modifier: Modifier = Modifier,
    subtitle: String?,
    imageUrl: String?,
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        color = MaterialTheme.colorScheme.secondaryContainer,
    ) {
        Column {
            LoadingImage(
                imageUrl = imageUrl,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(128.dp),
                color = MaterialTheme.colorScheme.onSecondaryContainer,
            )
            Text(
                text = title,
                modifier = Modifier.padding(8.dp, 8.dp, 8.dp, 2.dp),
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
            )
            Text(
                text = subtitle ?: "",
                modifier = Modifier.padding(8.dp, 2.dp, 8.dp, 8.dp),
                style = MaterialTheme.typography.labelSmall,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UserElementPreview() {
    GridElement(
        title = "Dale Cooper",
        imageUrl = "https://upload.wikimedia.org/wikipedia/en/5/50/Agentdalecooper.jpg",
        subtitle = "dale.cooper@fbi.com"
    )
}
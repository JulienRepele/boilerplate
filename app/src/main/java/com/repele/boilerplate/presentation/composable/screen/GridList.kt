package com.repele.boilerplate.presentation.composable.screen

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells.Fixed
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.repele.boilerplate.domain.model.User
import com.repele.boilerplate.presentation.composable.UsersViewModel
import com.repele.boilerplate.presentation.composable.element.GridElement

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun UsersGridScreen(
    usersViewModel: UsersViewModel = hiltViewModel(),
    navigateToDetailsScreen: (String) -> Unit,
) {
    val users by usersViewModel.users.collectAsState()

    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        UsersGrid(
            elements = users,
            navigateToDetailsScreen = navigateToDetailsScreen
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun UsersGrid(
    elements: List<User>,
    modifier: Modifier = Modifier,
    navigateToDetailsScreen: (String) -> Unit,
) {
    LazyVerticalGrid(
        cells = Fixed(2),
        modifier = modifier.background(MaterialTheme.colorScheme.background),
    ) {
        items(elements) { element ->
            GridElement(
                title = "${element.firstName} ${element.lastName}",
                modifier = Modifier
                    .padding(4.dp)
                    .clickable { navigateToDetailsScreen(element.email) },
                imageUrl = element.thumbnailUrl,
                subtitle = element.email,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun UsersGridPreview() {
    UsersGrid(
        elements = mockElements,
    ) {}
}

private val mockElements = listOf(
    User(
        firstName = "Dale",
        lastName = "Cooper",
        email = "dale.cooper@fbi.com",
        thumbnailUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-1024.jpg"
    ),
)


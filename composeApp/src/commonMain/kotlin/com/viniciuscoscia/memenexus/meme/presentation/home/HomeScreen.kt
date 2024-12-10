@file:OptIn(ExperimentalMaterial3Api::class)

package com.viniciuscoscia.memenexus.meme.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.viniciuscoscia.memenexus.core.presentation.DarkContent
import com.viniciuscoscia.memenexus.core.presentation.DarkSurface
import com.viniciuscoscia.memenexus.core.presentation.MemeNexusTheme
import com.viniciuscoscia.memenexus.core.presentation.components.DropdownMenuWithArrow
import com.viniciuscoscia.memenexus.core.presentation.components.RemoteSvgLoader
import com.viniciuscoscia.memenexus.meme.domain.entity.MemeTemplate
import com.viniciuscoscia.memenexus.meme.presentation.home.component.MemeList
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Preview
@Composable
fun HomeScreenRoot(
    viewModel: HomeViewModel = koinViewModel(),
    onMemeTemplateClick: (MemeTemplate) -> Unit,
) {
    MemeNexusTheme {
        val state by viewModel.state.collectAsStateWithLifecycle()

        HomeScreen(
            homeState = state,
            onAction = { action ->
                when (action) {
//                    is BookListAction.OnBookClick -> onBookClick(action.book)
                    else -> Unit
                }
                viewModel.onAction(action)
            }
        )

        HomeScreen(state, viewModel::onAction)
    }
}

@Preview
@Composable
fun HomeScreen(
    homeState: HomeState,
    onAction: (HomeAction) -> Unit,
) {
    Column(
        modifier = Modifier
            .statusBarsPadding()
            .navigationBarsPadding()
            .background(DarkSurface)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HomeTopBar()
        HomeBody(
            homeState = homeState,
            onAction = onAction
        )
    }
}

@Preview
@Composable
private fun HomeTopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .background(DarkContent)
                .padding(vertical = 8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            HomeTitle()
            val options = listOf("Favorites First", "Newest First")
            DropdownMenuWithArrow(
                options = options
            )
        }
    }
}

@Composable
private fun HomeBody(
    homeState: HomeState,
    onAction: (HomeAction) -> Unit,
) {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = MaterialTheme.colorScheme.surfaceContainer
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            if (homeState.memes.isNotEmpty()) {
                MemeList(
                    memes = homeState.memes,
                    onMemeClick = {
                        println("Meme clicked: $it")
                    }
                )
            } else {
                NoMemesCreatedYet()
            }

            val sheetState = rememberModalBottomSheetState(
                skipPartiallyExpanded = false
            )
            var isSheetOpen by rememberSaveable { mutableStateOf(false) }

            HomeFab(
                modifier = Modifier
                    .padding(
                        all = 24.dp,
                    )
                    .align(Alignment.BottomEnd),
            ) {
                isSheetOpen = true
            }

            if (isSheetOpen) {
                HomeTemplateBottomSheet(
                    bottomSheetState = sheetState,
                    onDismissRequest = {
                        isSheetOpen = false
                    }
                )
            }
        }
    }
}

@Composable
fun HomeTemplateBottomSheet(
    bottomSheetState: SheetState,
    onDismissRequest: () -> Unit
) {
    ModalBottomSheet(
        sheetState = bottomSheetState,
        modifier = Modifier.fillMaxSize(),
        onDismissRequest = onDismissRequest
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "This is a bottom sheet!")
        }
    }
}

@Preview
@Composable
private fun NoMemesCreatedYet() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .navigationBarsPadding()
            .fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            RemoteSvgLoader(
                modifier = Modifier
                    .fillMaxWidth(0.35f),
                svgPath = "https://meme-nexus.s3.us-east-2.amazonaws.com/AppSVGs/homeBackgroundEmptyList.svg"
            )

            Text(
                text = "Tap + button to create your first meme",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Composable
private fun HomeFab(modifier: Modifier, onClick: () -> Unit) {
    FloatingActionButton(
        modifier = modifier,
        onClick = onClick,
        content = {
            Text(
                fontWeight = FontWeight(350),
                fontSize = 30.sp,
                text = "+",
            )
        }
    )
}

@Composable
private fun HomeTitle() {
    Text(
        text = "Your Memes",
        style = MaterialTheme.typography.headlineMedium,
        color = Color.White,
        modifier = Modifier.padding(horizontal = 16.dp)
    )
}
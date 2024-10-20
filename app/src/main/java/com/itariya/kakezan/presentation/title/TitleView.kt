package com.itariya.kakezan.presentation.title

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.itariya.kakezan.const.ViewRoute

class TitleViewStyles {
    object MainDiv {
        val HEIGHT_WEIGHT = 0.5f
    }

    object CardDiv {
        val HEIGHT_WEIGHT = 0.5f
        val PADDING = 30.dp
        val ROW_MARGIN = 30.dp
    }
}

@Composable
fun TitleView(
    navController: NavController,
    viewModel: TitleViewModel = hiltViewModel(),
) {
    LaunchedEffect(Unit) {
        viewModel.init()
    }

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
    ){
        TitleViewContent(
            onClickStart = {
                navController.navigate(ViewRoute.KakezanMenuView.route)
            }
        )
    }
}

@Composable
fun TitleViewContent(
    onClickStart: () -> Unit = {}
) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
    ){
        Text("かけ算アプリ")
        Button(
            onClick = { onClickStart() }
        ) {
            Text(text = "はじめる")
        }
    }
}

package com.itariya.kakezan.presentation.kakezanMenu

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.itariya.kakezan.const.ViewRoute

class KakezanMenuViewStyles {
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
fun KakezanMenuView(
    navController: NavController,
    viewModel: KakezanMenuViewModel = hiltViewModel(),
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
        KakezanMenuViewContent(
            onClickBack = {
                navController.navigate(ViewRoute.TitleView.route)
            }
        )
    }
}

@Composable
fun KakezanMenuViewContent(
    onClickBack: () -> Unit = {}
) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text("九九の表")
            Button(
                onClick = {
                    onClickBack()
                }
            ) {
                Text(text = "戻る")
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .border(2.dp, Color.LightGray)
        ) {
            for(i in 1..9) {
                Column (
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f)
                        .border(1.dp, Color.LightGray)
                ) {
                    Column (
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .border(1.dp, Color.LightGray)
                    ) {
                        Text("${i}の段")
                    }
                    for(j in 1..9) {
                        Column (
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f)
                                .border(1.dp, Color.LightGray)
                        ) {
                            Text("$i × $j = ${i * j}")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun TimesTable(
    multiplicationTable: Int = 1
) {
    Column (
        modifier = Modifier
            .width(120.dp)
    ) {
        for(i in 1..9) {
            Column (
                modifier = Modifier
                    .weight(1f)
            ) {
                Text("$multiplicationTable × $i = ${multiplicationTable * i}")
            }
        }
    }
}
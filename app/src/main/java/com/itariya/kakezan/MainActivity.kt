package com.itariya.kakezan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.itariya.kakezan.const.ViewRoute
import com.itariya.kakezan.presentation.kakezanMenu.KakezanMenuView
import com.itariya.kakezan.presentation.title.TitleView
import com.itariya.kakezan.ui.theme.KakezanTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ステータスバーとナビゲーションバーを非表示にする
        WindowCompat.setDecorFitsSystemWindows(window, false)
        WindowInsetsControllerCompat(window, window.decorView).hide(WindowInsetsCompat.Type.systemBars())

        setContent {
            KakezanTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background)
                {
                    val navController = rememberNavController()
                    //-----------------
                    // 画面遷移の定義
                    //-----------------
                    NavHost(
                        navController = navController,
                        startDestination = ViewRoute.TitleView.route, // 開始画面の指定
                    ) {
                        // タイトル画面
                        composable(route = ViewRoute.TitleView.route) {
                            TitleView(navController)
                        }
                        // 掛け算メニュー画面
                        composable(route = ViewRoute.KakezanMenuView.route) {
                            KakezanMenuView(navController)
                        }
                    }
                }
            }
        }
    }
}

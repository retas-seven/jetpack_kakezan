package com.itariya.kakezan.const

sealed class ViewRoute(val route: String) {
    object MyTest : ViewRoute("mytest_screen")
    object TitleView : ViewRoute("title_view")
    object KakezanMenuView : ViewRoute("kakezan_menu_view")
}


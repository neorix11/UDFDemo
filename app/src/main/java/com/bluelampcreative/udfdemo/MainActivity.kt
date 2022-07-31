package com.bluelampcreative.udfdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.bluelampcreative.udfdemo.ui.views.moviesearch.MovieSearchView
import com.bluelampcreative.udfdemo.nav.Screen
import com.bluelampcreative.udfdemo.nav.bottomNavigationItems
import com.bluelampcreative.udfdemo.ui.theme.UDFDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainLayout()
        }
    }
}

@Composable
fun MainLayout() {

    val navController = rememberNavController()

    UDFDemoTheme {
      Scaffold(
          bottomBar = {
              BottomAppBar(
                  cutoutShape = MaterialTheme.shapes.small.copy(CornerSize(percent = 50))
              ) {
                  val navBackStackEntry by navController.currentBackStackEntryAsState()
                  val currentRoute = navBackStackEntry?.destination?.route

                  bottomNavigationItems.forEach { bottomNavigationItem ->
                      BottomNavigationItem(
                          icon = {
                              Icon(
                                  bottomNavigationItem.icon,
                                  contentDescription = bottomNavigationItem.iconDescription
                              )
                          },
                          label = { Text(bottomNavigationItem.iconDescription) },
                          selected = currentRoute == bottomNavigationItem.route,
                          onClick = {
                              navController.navigate(bottomNavigationItem.route) {
                                  popUpTo(navController.graph.id)
                                  launchSingleTop = true
                              }
                          }
                      )
                  }
              }
          }
      ){ paddingValues ->
          Box(Modifier.padding(paddingValues)) {
              NavHost(navController = navController, startDestination = Screen.MovieSearch.title) {
                  composable(Screen.MovieSearch.title) {
                      MovieSearchView{
                          navController.navigate(Screen.MovieDetail.title + "/${it.title}/${it.id}")
                      }
                  }
//                  composable(Screen.WatchList.title) {
//                      WatchListView()
//                  }
//                  composable(Screen.MovieDetail.title + "/{title}/{movieId}") {
//                      MovieDetailView(
//                          it.arguments?.get("title") as String,
//                          it.arguments?.get("movieId") as String,
//                          popBack = { navController.popBackStack() }
//                      )
//                  }
              }
          }
      }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    UDFDemoTheme{}
}
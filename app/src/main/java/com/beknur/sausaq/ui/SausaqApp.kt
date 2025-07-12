package com.beknur.sausaq.ui

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay


import com.beknur.sausaq.navigation.BottomBarScreen
import com.beknur.sausaq.navigation.BottomBarScreenSaver
import com.beknur.sausaq.navigation.RootGraph
import com.beknur.sausaq.navigation.Screen


import com.beknur.sausaq.navigation.bottomBarItems



@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview
@Composable
fun SausaqApp() {

	var currentDestination: BottomBarScreen by rememberSaveable(
		stateSaver = BottomBarScreenSaver
	) { mutableStateOf(BottomBarScreen.Catalog) }

	val backStackHome = rememberNavBackStack(Screen.Home)
	val backStackProfile = rememberNavBackStack(Screen.Profile)
	val backStackCatalog = rememberNavBackStack(Screen.Catalog)
	val backStackCart = rememberNavBackStack(Screen.Cart)
	val backStackFav = rememberNavBackStack(Screen.Favorites)


	val backStacks = rememberSaveable {
		mapOf(
			BottomBarScreen.Catalog to backStackCatalog,
			BottomBarScreen.Profile to backStackProfile,
			BottomBarScreen.Home to backStackHome,
			BottomBarScreen.Cart to backStackCart,
			BottomBarScreen.Favorites to backStackFav
		)
	}

	Scaffold(

		bottomBar = {

			NavigationBar {

				bottomBarItems.forEach { destination ->
					NavigationBarItem(

						selected = currentDestination == destination,
						onClick = { currentDestination = destination },


						icon = {
							Icon(
								painter = painterResource(destination.icon), ""
							)
						},
						label = { Text(text = destination.title, fontSize = 10.sp, maxLines = 1) },
						colors = NavigationBarItemDefaults.colors(
							indicatorColor = Color.Transparent,
							selectedIconColor = Color.Green,
							unselectedIconColor = Color.Black,
							selectedTextColor = Color.Green,
							unselectedTextColor = Color.Black
						),
					)
				}
			}
		}
	) { innerPadding ->

		Box(
			modifier = Modifier
				.fillMaxSize()
				.padding(innerPadding)
		) {
			val backStack=backStacks[currentDestination]!!
			RootGraph(backStack)
		}


	}
}









package com.beknur.tanda.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation3.runtime.rememberNavBackStack
import com.beknur.navigation.NavigationManager


import com.beknur.tanda.navigation.BottomBarScreen
import com.beknur.tanda.navigation.BottomBarScreenSaver
import com.beknur.tanda.navigation.RootGraph
import com.beknur.navigation.Screen
import com.beknur.tanda.MainViewModel


import com.beknur.tanda.navigation.bottomBarItems
import org.koin.compose.koinInject


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview
@Composable
fun SausaqApp(mainViewModel: MainViewModel= koinInject()) {
	val showBottomBar by mainViewModel.isBottomBarVisible.collectAsStateWithLifecycle()
	var currentDestination: BottomBarScreen by rememberSaveable(
		stateSaver = BottomBarScreenSaver
	) { mutableStateOf(BottomBarScreen.Catalog) }

	val navigationManager: NavigationManager = koinInject()

	val backStackHome = rememberNavBackStack(Screen.Home)
	val backStackProfile = rememberNavBackStack(Screen.Profile)
	val backStackCatalog = rememberNavBackStack(Screen.Catalog)
	val backStackCart = rememberNavBackStack(Screen.Cart)
	val backStackFav = rememberNavBackStack(Screen.Favorites)


	val backStacks= mapOf(
			BottomBarScreen.Catalog to backStackCatalog,
			BottomBarScreen.Profile to backStackProfile,
			BottomBarScreen.Home to backStackHome,
			BottomBarScreen.Cart to backStackCart,
			BottomBarScreen.Favorites to backStackFav
	)


	Scaffold(
		bottomBar = {
			if (showBottomBar) {
				NavigationBar {

					bottomBarItems.forEach { destination ->
						NavigationBarItem(

							selected = currentDestination == destination,
							onClick = { currentDestination = destination },


							icon = {
								Icon(
									imageVector = ImageVector.vectorResource(destination.icon), ""
								)
							},
							label = {
								Text(
									text = destination.title,
									fontSize = 10.sp,
									maxLines = 1
								)
							},
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
		}
	) { innerPadding ->

		Box(
			modifier = Modifier
				.fillMaxSize()
				.padding(innerPadding)
		) {
			val backStack=backStacks[currentDestination]!!
			RootGraph(backStack,navigationManager,mainViewModel)
		}


	}
}









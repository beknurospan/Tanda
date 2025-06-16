package com.beknur.sausaq.ui

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.beknur.sausaq.navigation.BottomBarScreen
import com.beknur.sausaq.navigation.BottomBarScreenSaver
import com.beknur.sausaq.navigation.bottomBarItems


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview
@Composable
fun SausaqApp() {

	val backStack = rememberNavBackStack<BottomBarScreen>(BottomBarScreen.Home)

	var currentDestination:BottomBarScreen by rememberSaveable(
		stateSaver= BottomBarScreenSaver
	) { mutableStateOf(BottomBarScreen.Home) }

	Scaffold(
		bottomBar = {

			NavigationBar {
				bottomBarItems.forEach { destination ->
					NavigationBarItem(

						selected = currentDestination==destination,
						onClick = { currentDestination=destination},

						icon = { Icon( painter = painterResource(destination.icon)
							,"" )},
						label = { Text(text=destination.title, fontSize = 10.sp, maxLines = 1) },
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
		}) {

	}


}
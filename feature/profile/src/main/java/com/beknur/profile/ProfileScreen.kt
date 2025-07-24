package com.beknur.profile


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.beknur.profile.composables.LangBar
import com.beknur.profile.composables.MyData
import com.beknur.profile.composables.ProfileItem
import com.beknur.profile.composables.UnauthorizedBanner


@Composable
fun ProfileScreenRoute(viewModel: ProfileViewModel) {

	val viewState by viewModel.viewState.collectAsStateWithLifecycle()
	ProfileScreen(viewState, viewModel::handleEvent)
}


@Composable
fun ProfileScreen(
	viewState: ProfileViewState,
	sendUiEvent: (ProfileUiEvent) -> Unit
) {

	Column(
		modifier = Modifier
			.fillMaxSize()

			.background(Color.White),
	) {
		LangBar(viewState.currentLang,{sendUiEvent(ProfileUiEvent.OnLangChanged(it))})

		if (viewState.isAuth) {
			MyData()
		} else {
			UnauthorizedBanner { sendUiEvent(ProfileUiEvent.OnAuthClick) }
		}


		val profileItems = if (viewState.isAuth)
			ProfileItem.items else ProfileItem.unauthorizedItems

		profileItems.forEach { item ->
			val title = stringResource(item.titleRes)
			val icon = item.iconRes
			val event = item.event
			ProfileItem(icon = icon, text = title) { sendUiEvent(event) }
		}
	}

}


@Preview
@Composable
fun ProfileScreenPreview() {
	ProfileScreen(viewState = ProfileViewState("Бекнур", "87756294455", true,LangParamsUI.KZ)) { }
}




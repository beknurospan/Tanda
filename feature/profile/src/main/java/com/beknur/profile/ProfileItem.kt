package com.beknur.profile
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.beknur.designsystem.R as coreR
import com.beknur.profile.R

sealed class ProfileItem(
	@DrawableRes val iconRes: Int,
    @StringRes val titleRes: Int,
	val event: ProfileUiEvent
) {
	data object Orders : ProfileItem(
		iconRes = coreR.drawable.shopicons_regular_clock,
		titleRes = R.string.feature_profile_my_orders,
		event = ProfileUiEvent.OnOrderClick
	)

	data object Cards : ProfileItem(
		iconRes = coreR.drawable.shopicons_regular_creditcard,
		titleRes = R.string.feature_profile_cards,
		event = ProfileUiEvent.OnCardsClick
	)

	data object Address : ProfileItem(
		iconRes = coreR.drawable.location_on,
		titleRes = R.string.feature_profile_adress,
		event = ProfileUiEvent.OnAddressClick
	)

	data object Notifications : ProfileItem(
		iconRes = coreR.drawable.shopicons_regular_bell,
		titleRes = R.string.feature_profile_notifications,
		event = ProfileUiEvent.OnNotificationClick
	)

	data object AboutApp : ProfileItem(
		iconRes = coreR.drawable.shopicons_regular_book1,
		titleRes = R.string.feature_profile_about_app,
		event = ProfileUiEvent.OnAboutAppClick
	)

	data object Support : ProfileItem(
		iconRes = coreR.drawable.shopicons_regular_service,
		titleRes =R.string.feature_profile_support,
		event = ProfileUiEvent.OnSupportClick
	)

	data object Logout : ProfileItem(
		iconRes = coreR.drawable.sign_out_squre,
		titleRes = R.string.feature_profile_logout,
		event = ProfileUiEvent.OnLogoutClick
	)

	companion object {
		val items = listOf(
			Orders, Cards, Address, Notifications, AboutApp, Support, Logout
		)
		val unauthorizedItems= listOf(
			Support,AboutApp
		)
	}

}

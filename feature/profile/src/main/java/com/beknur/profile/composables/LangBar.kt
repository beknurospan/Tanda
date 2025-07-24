package com.beknur.profile.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.beknur.designsystem.theme.Green
import com.beknur.designsystem.theme.GreenDark
import com.beknur.designsystem.theme.WhiteGray
import com.beknur.profile.LangParamsUI


@Composable
fun LangBar(currentLang: LangParamsUI,onLanguageChange: (LangParamsUI) -> Unit) {
	Row(modifier = Modifier
		.fillMaxWidth()
		.height(54.dp)
		.background(Color.White)
		.padding(10.dp)) {

			LanguageSwitcher(currentLang,onLanguageChange)
	}
}

@Composable
fun LanguageSwitcher(
	currentLang: LangParamsUI,
	onLanguageChange: (LangParamsUI) -> Unit
) {
	Row(
		modifier = Modifier
			.clip(RoundedCornerShape(20.dp))
			.background(Color.White)
			.padding(4.dp),
		verticalAlignment = Alignment.CenterVertically
	) {
		LanguageButton(LangParamsUI.RUS.code, currentLang == LangParamsUI.RUS) {
			onLanguageChange(LangParamsUI.RUS)
		}
		Spacer(modifier = Modifier.width(4.dp))
		LanguageButton(LangParamsUI.KZ.code, currentLang == LangParamsUI.KZ) {
			onLanguageChange(LangParamsUI.KZ)
		}
	}
}

@Composable
fun LanguageButton(
	label: String,
	selected: Boolean,
	onClick: () -> Unit
) {
	Box(
		modifier = Modifier
			.clip(RoundedCornerShape(16.dp))
			.background(if (selected) WhiteGray else Color.Transparent)
			.clickable { onClick.invoke() }
			.padding(horizontal = 12.dp, vertical = 6.dp)
	) {
		Text(
			text = label,
			color = if (selected) Green else Color.DarkGray
		)
	}
}

@Composable
@Preview
fun LangBarPreview(){
	LangBar(LangParamsUI.RUS) { }
}

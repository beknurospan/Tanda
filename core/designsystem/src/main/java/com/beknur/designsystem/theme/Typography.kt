package com.beknur.designsystem.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import com.beknur.designsystem.R



object CustomTypography{
	val provider = GoogleFont.Provider(
		providerAuthority = "com.google.android.gms.fonts",
		providerPackage = "com.google.android.gms",
		certificates = R.array.com_google_android_gms_fonts_certs
	)
	val adlamFontName = GoogleFont("Adlam Display")
	val AdlamFontFamily = FontFamily(
		Font(googleFont = adlamFontName, fontProvider = provider, weight = FontWeight.Normal),
		Font(googleFont = adlamFontName, fontProvider = provider, weight = FontWeight.Bold)
	)
	val PoppinsFontFamily = FontFamily(
		Font(googleFont = GoogleFont("Poppins"), fontProvider = provider, weight = FontWeight.Normal),
		Font(googleFont = GoogleFont("Poppins"), fontProvider = provider, weight = FontWeight.Medium),
		Font(googleFont = GoogleFont("Poppins"), fontProvider = provider, weight = FontWeight.Bold)
	)

	val Typography = TextStyle(
			fontFamily = AdlamFontFamily,
			fontSize = 18.sp
		)




}

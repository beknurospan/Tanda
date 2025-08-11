package com.beknur.tanda

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.beknur.tanda.ui.SausaqApp


class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {

			SausaqApp()

		}
	}
}



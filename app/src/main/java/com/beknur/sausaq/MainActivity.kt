package com.beknur.sausaq

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.content.ContentProviderCompat.requireContext
import com.beknur.sausaq.ui.SausaqApp
import java.io.File
import java.security.AccessController.getContext


class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {

		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {

			SausaqApp()

		}
	}
}



package com.beknur.profile


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.beknur.designsystem.R as coreR
import com.beknur.designsystem.theme.Gray
import com.beknur.designsystem.theme.Green


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun ProfileScreen() {

	Column(
		modifier = Modifier
			.fillMaxSize()

			.background(White),
		verticalArrangement = Arrangement.spacedBy(15.dp)
	) {
		TopAppBar(
			title = { Text("Профиль") },
		)

		UnauthorizedScreen()
		ProfileItem(coreR.drawable.shopicons_regular_clock, "Мои заказы")
		ProfileItem(coreR.drawable.shopicons_regular_creditcard, "Карты")
		ProfileItem(coreR.drawable.location_on, "Адрес")
		ProfileItem(coreR.drawable.shopicons_regular_bell, "Уведомления")

		ProfileItem(coreR.drawable.shopicons_regular_book1, "О приложений")
		ProfileItem(coreR.drawable.shopicons_regular_service, "Поддержка")
		ProfileItem(coreR.drawable.sign_out_squre, "Выйти")


	}

}


@Composable
fun ProfileItem(
	icon: Int,
	text: String
) {


	Card(
		modifier = Modifier
			.fillMaxWidth()
			.height(50.dp)
			.padding(horizontal = 15.dp),
		colors = CardDefaults.cardColors(containerColor = White),
		elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),

		) {

		Row(
			modifier = Modifier
				.fillMaxSize()
				.padding(5.dp),
			verticalAlignment = Alignment.CenterVertically,
			horizontalArrangement = Arrangement.spacedBy(5.dp)
		) {
			Icon(
				imageVector = ImageVector.vectorResource(id = icon),
				contentDescription = "", tint = Color.Unspecified
			)
			Text(text)
		}

	}
}

@Preview
@Composable
fun MyData() {
	Row(
		modifier = Modifier
			.fillMaxWidth()
			.height(90.dp)
			.padding(horizontal = 20.dp),
		verticalAlignment = Alignment.CenterVertically,
		horizontalArrangement = Arrangement.spacedBy(5.dp)
	) {
		Icon(
			imageVector = ImageVector.vectorResource(id = coreR.drawable.penguin_svgrepo_com_1),
			contentDescription = "", tint = Color.Unspecified
		)
		Column {
			Text("Бекнур Оспан")
			Text("8 775 629 44 55")
		}


	}
}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Preview
@Composable
fun UnauthorizedScreen() {
	Column(
		modifier = Modifier
			.fillMaxWidth()
			.height(300.dp)
			.background(Gray),
		horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.SpaceAround
	) {
		Image(
			imageVector = ImageVector.vectorResource(coreR.drawable.penguin_svgrepo_com_1),
			contentDescription = "",
			modifier = Modifier.size(100.dp)
		)
		Text("Совершайте Покупки делайте все ")
		Button(
			onClick = { /* TODO */ },
			modifier = Modifier
				.fillMaxWidth()
				.height(40.dp)
				.padding(horizontal = 40.dp),
			shape = RoundedCornerShape(4.dp),
			colors = ButtonDefaults.buttonColors(
				containerColor = Color.Green,           // Фон кнопки
				contentColor = Color.White            // Цвет текста/иконки внутри
			)
		) {
			Text("Авторизоваться")
		}
	}
}
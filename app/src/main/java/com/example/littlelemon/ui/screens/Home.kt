package com.example.littlelemon.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import com.example.littlelemon.R
import com.example.littlelemon.const.EndPoints
import com.example.littlelemon.data.MenuItemEntity
import com.example.littlelemon.network.MenuItemNetwork
import com.example.littlelemon.ui.composables.AppLogo
import com.example.littlelemon.ui.composables.MenuItemCompose
import com.example.littlelemon.ui.composables.PrimaryButton
import com.example.littlelemon.ui.composables.PrimaryTextField
import com.example.littlelemon.ui.composables.SecondaryTextField
import com.example.littlelemon.ui.navigation.ProfileRoute
import com.example.littlelemon.ui.theme.AppColors
import com.example.littlelemon.ui.theme.Typography
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    navController: NavController,
    items: List<MenuItemEntity>
) {


    val categories = items.map { it.category }.toSet().toList()

    val choosedCategory = remember {
        mutableStateOf(if (categories.isEmpty()) "" else categories.first())
    }


    val searchQuery = remember {
        mutableStateOf("")
    }


    val searchingItems = items.filter { it.title.contains(searchQuery.value, ignoreCase = true) }
    val itemsOnScope =
        if (choosedCategory.value.isNotEmpty()) items.filter { it.category == choosedCategory.value } else {
            items
        }


    val isSearching = searchQuery.value.isNotEmpty()


    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            AppLogo(
                modifier = Modifier
                    .fillMaxWidth(0.79f)
                    .height(65.dp)
            )
            IconButton(
                onClick = {
                    navController.navigate(ProfileRoute.route)

                },
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null
                )

            }
        }
        Box(
            modifier = Modifier
                .background(color = AppColors.secondary)
                .fillMaxWidth(1f)
        ) {
            Row {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(0.6f)
                        .padding(
                            16.dp
                        )
                ) {
                    Text(
                        text = "Little Lemon",
                        style = Typography.displayLarge.copy(color = AppColors.primaryColor)
                    )

                    Spacer(
                        modifier =
                        Modifier.height(16.dp)
                    )
                    Text(
                        text = "Chicago",
                        style = Typography.displayMedium.copy(color = Color.White)
                    )
                    Text(
                        text = "We are making the best food order from our app made by a naive developer thinks he will be a programmer some day",
                        style = Typography.bodyLarge.copy(color = Color.White)
                    )

                    SecondaryTextField(

                        onChanged = {
                            searchQuery.value = it
                        },
                        value = searchQuery.value,
                        leading = {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = null
                            )
                        },
                    ) {
                        Text(text = "Search")
                    }
                }
                Image(
                    painter = painterResource(id = R.drawable.hero),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,

                    modifier = Modifier
                        .padding(20.dp)
                        .size(200.dp)
                        .clip(RoundedCornerShape(16.dp))

                )
            }
        }

        LazyRow(content = {
            items(categories) {
                CategoryCompose(
                    name = it,
                    onPressed = {

                        choosedCategory.value = it
                    }, choosed = choosedCategory.value == it
                )
            }
        })


        Spacer(modifier = Modifier.height(8.dp))
        LazyColumn {
            items(
                if (isSearching) searchingItems else itemsOnScope
            ) {
                MenuItemCompose(item = it)
            }
        }
    }


}

@Composable
fun CategoryCompose(
    onPressed: () -> Unit = {},
    name: String,
    choosed: Boolean = false,
) {

    val border = if (choosed) 2.dp else {
        0.dp
    }
    val color = if (choosed) AppColors.primaryColor else {
        Color.Transparent
    }
    Card(
        shape = RoundedCornerShape(50.dp),
        modifier = Modifier
            .clickable {
                onPressed.invoke()
            }
            .padding(8.dp)
            .border(
                border,
                color,
                shape = RoundedCornerShape(50.dp)
            ),
    ) {
        Text(
            text = name,
            modifier = Modifier.padding(12.dp)
        )
    }
}

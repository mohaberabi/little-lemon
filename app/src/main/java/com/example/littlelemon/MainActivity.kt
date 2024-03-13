package com.example.littlelemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.littlelemon.const.EndPoints
import com.example.littlelemon.data.AppDatabase
import com.example.littlelemon.network.MenuItemNetwork
import com.example.littlelemon.ui.navigation.Navigator
import com.example.littlelemon.ui.theme.LittleLemonTheme
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

const val appName = "littleLemon"

class MainActivity : ComponentActivity() {
    private val database by lazy {
        Room.databaseBuilder(applicationContext, AppDatabase::class.java, "database").build()
    }

    private val prefs by lazy {
        getSharedPreferences(appName, MODE_PRIVATE)
    }

    private val client = HttpClient(Android) {
        install(ContentNegotiation) {
            json(contentType = ContentType("text", "plain"))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LittleLemonTheme {
                val items = database.menuItemDao().getAll().observeAsState(emptyList())
                Navigator(
                    prefs = prefs,
                    items = items.value,
                )
            }
        }


        lifecycleScope.launch(Dispatchers.IO) {
            if (database.menuItemDao().isEmpty()) {

                val data = fetchData()

                for (item in data) {
                    database.menuItemDao().insert(item.toMenuEntity())
                }

            }
        }

    }

    private suspend fun fetchData(): List<MenuItemNetwork> {
        val response: Map<String, List<MenuItemNetwork>> = client.get(EndPoints.menuEndPoint)
            .body()
        val items = response["menu"] ?: emptyList()
        return items
    }

}


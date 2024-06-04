package com.example.rma_project.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.rma_project.data.auth.AuthViewModel
import com.example.rma_project.data.model.City
import com.example.rma_project.viewmodel.CityViewModel


// OVDJE SAM STAO, ISPROBAT JEL RADI OVA FUNKCIJA, IMPORTAT JU U MAIN ACTIVITY
// gradovi mi se prikazuju samo u logcatu
/*
@Composable
fun CitySearchScreen(navController: NavHostController, cityViewModel: CityViewModel = CityViewModel()) {
    var searchQuery by remember { mutableStateOf(TextFieldValue("")) }
    val cities by cityViewModel.cities.collectAsState()

    Column (
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        TextField(
            value = searchQuery,
            onValueChange = { newValue ->
                searchQuery = newValue
                cityViewModel.updateQuery(newValue.text)
            },
            label = { Text("Search Cities") }
        )
        LazyColumn {
            items(cities) { city ->
                Text("${city.name}, ${city.country} - Population: ${city.population}, ${city.id}",
                    modifier = Modifier
                        .clickable {
                            navController.navigate(
                                "city_detail/${city.name}/${city.country}/${city.population}/${city.id}"
                            )
                        })
            }
        }
    }
}
*/
@Composable
fun CitySearchScreen(navController: NavController, cityViewModel: CityViewModel = CityViewModel(), authViewModel: AuthViewModel = AuthViewModel()) {
    var query by remember { mutableStateOf("") }
    val cities by cityViewModel.cities.collectAsState()
    val errorMessage by cityViewModel.errorMessage.collectAsState()

    Column(modifier = Modifier
        .padding(16.dp)
        .fillMaxSize()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TextField(
                value = query,
                onValueChange = {
                    query = it
                    if(query.isNotEmpty()){
                        cityViewModel.searchCities(query)
                    }
                                },
                label = { Text("Enter city name") },
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { cityViewModel.searchCities(query) }) {
                Text("Search")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        errorMessage?.let {
            Text(
                text = it,
                color = Color.Red,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }

        LazyColumn(modifier = Modifier.weight(1f).fillMaxWidth()) {
            items(cities) { city ->
                CityItem(city) {
                    navController.navigate(
                        "city-detail/${city.name}/${city.country}/${city.population}"
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Button(
                onClick = {
                    // Handle logout logic here
                    authViewModel.logout()
                    navController.navigate("login")
                }
            ) {
                Text("Logout")
            }
        }
    }
}
@Composable
fun CityItem(city: City, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .background(color = Color(0xFFDFFFD6), shape = RoundedCornerShape(8.dp))
            .clickable { onClick() }
            .padding(16.dp)
    ) {
        Text(
            text = city.name,
            color = Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "${city.country} - Population: ${city.population}",
            color = Color.DarkGray,
            fontSize = 14.sp
        )
    }
}

/*
@Composable
fun CitySearchScreen(navController: NavHostController, cityViewModel: CityViewModel = CityViewModel()) {
    CityAutoComplete(cityViewModel) { city ->
        navController.navigate(
            "city-detail/${city.name}/${city.country}/${city.population}"
        )
    }
}
*/
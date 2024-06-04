package com.example.rma_project.data.components

/*
@Composable
fun CityAutoComplete(
    cityViewModel: CityViewModel,
    onCitySelected: (City) -> Unit
) {
    var query by remember { mutableStateOf("") }
    var textFieldSize by remember { mutableStateOf(Size.Zero) }
    var expanded by remember { mutableStateOf(false) }
    val cities by cityViewModel.cities.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = { expanded = false }
            )
    ) {
        Text(
            modifier = Modifier.padding(start = 3.dp, bottom = 2.dp),
            text = "Cities",
            fontSize = 16.sp,
            color = Color.Black,
            fontWeight = FontWeight.Medium
        )

        Column(modifier = Modifier.fillMaxWidth()) {
            Row(modifier = Modifier.fillMaxWidth()) {
                AutoCompleteTextField(
                    value = query,
                    onValueChange = {
                        query = it
                        cityViewModel.updateQuery(it)
                        expanded = true
                    },
                    placeholder = "Enter city name",
                    textFieldSize = { size -> textFieldSize = size }
                ) {
                    expanded = !expanded
                }
            }

            AnimatedVisibility(visible = expanded) {
                AutoCompleteDropdown(
                    modifier = Modifier.padding(horizontal = 5.dp),
                    textFieldWidth = textFieldSize.width.dp,
                    items = if (query.isNotEmpty()) cities else emptyList()
                ) { city ->
                    query = city.name
                    onCitySelected(city)
                    expanded = false
                }
            }
        }
    }
}

@Composable
fun AutoCompleteTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    textFieldSize: (Size) -> Unit,
    onClick: () -> Unit
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(placeholder) },
        modifier = Modifier
            .fillMaxWidth()
            .onGloballyPositioned { coordinates ->
                textFieldSize(coordinates.size.toSize())
            }
            .clickable { onClick() }
    )
}

@Composable
fun AutoCompleteDropdown(
    modifier: Modifier,
    textFieldWidth: Dp,
    items: List<City>,
    onItemClick: (City) -> Unit
) {
    DropdownMenu(
        expanded = true,
        onDismissRequest = { },
        modifier = modifier
            .width(textFieldWidth)
            .background(Color.White)
    ) {
        items.forEach { city ->
            DropdownMenuItem(
                {
                    Text(text = "${city.name}, ${city.country} - Population: ${city.population}")
                },
                onClick = { onItemClick(city) }
            )
    }
}
    }
*/
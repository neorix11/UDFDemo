package com.demo.composables.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalTextInputService
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun MovieSearchBar(onSearch: (searchTerm: String) -> Unit) {

    val focus = LocalTextInputService.current
    val searchText = remember { mutableStateOf("")}

    Row(
        Modifier.padding(8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,) {
       OutlinedTextField(
           value = searchText.value,
           onValueChange = { searchText.value = it},
           keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done, keyboardType = KeyboardType.Text),
           keyboardActions = KeyboardActions(
               onDone = {
                   onSearch(searchText.value)
                   focus?.hideSoftwareKeyboard()
               }),
           singleLine = true
           )
        Spacer(Modifier.width(8.dp))
        IconButton(
            onClick = {
                onSearch(searchText.value)
                focus?.hideSoftwareKeyboard()
            }) {
            Icon(Icons.Default.Search, "Search")
        }
    }
}
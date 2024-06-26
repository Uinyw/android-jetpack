package com.uinyw.androidjetpack.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserDataInputScreen(userViewModel: UserViewModel = hiltViewModel()) {
    val user by userViewModel.getUser().collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                ),
                title = {
                    Text("Tell us about yourself")
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier.padding(padding)
        ) {

            InputComponent(label = "First Name", userInput = user.getFirstName()) {
                userViewModel.onFirstNameChange(it)
            }

            InputComponent(label = "Last Name", userInput = user.getLastName()) {
                userViewModel.onLastNameChange(it)
            }

            InputComponent(label = "Email", userInput = user.getEmail()) {
                userViewModel.onEmailChange(it)
            }

            InputComponent(label = "Phone", userInput = user.getPhone()) {
                userViewModel.onPhoneChange(it)
            }

            Text("${user.getFirstName()} ${user.getLastName()}: ${user.getEmail()}, ${user.getPhone()}")
        }
    }
}

@Composable
fun InputComponent(label: String, userInput: String, onUserInputChange: (String) -> Unit) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        OutlinedTextField(
            value = userInput,
            onValueChange = onUserInputChange,
            label = {
                Text(text = label)
            }
        )

    }

}





@Preview
@Composable
fun UserDataInputScreenPreview() {
    UserDataInputScreen(UserViewModel())
}
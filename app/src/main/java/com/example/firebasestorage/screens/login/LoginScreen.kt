package com.example.firebasestorage.screens.login

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.firebasestorage.data.AuthViewModel
import com.example.firebasestorage.navigation.ROUT_SIGNUP

@Composable
fun LoginScreen(navController: NavController) {
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }
    var mContext = LocalContext.current


    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {

        //TopAppBar
        TopAppBar(title = { Text(text = "Login Here")},
            navigationIcon = {
                IconButton(onClick = {
                    navController.navigate(ROUT_SIGNUP)
                }) {
                    Icon(imageVector = Icons.Filled.ArrowBack , contentDescription = "arrowback")
                }
            },
            backgroundColor = Color.Yellow)


        Spacer(modifier = Modifier.height(20.dp))

        //Lottie Animation
        val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(com.example.firebasestorage.R.raw.register))
        val progress by animateLottieCompositionAsState(composition )

        LottieAnimation(composition, progress,
            modifier = Modifier.size(300.dp))


        //Textfields
        Column(modifier = Modifier.padding(20.dp)) {

            Spacer(modifier = Modifier.height(20.dp))

            TextField(value = email ,
                onValueChange = {email=it},
                shape = RoundedCornerShape(5.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .border(2.dp, Color.Yellow)   ,
                label = { Text(text = "Email Address")},
                placeholder = { Text(text = "Enter email")},
                leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                colors = TextFieldDefaults.textFieldColors(Color.Yellow)


            )

            Spacer(modifier = Modifier.height(20.dp))

            TextField(value = password ,
                onValueChange = {password=it},
                modifier = Modifier
                    .fillMaxWidth()
                    .border(2.dp, Color.Yellow)     ,
                label = { Text(text = "Password")},
                placeholder = { Text(text = "Type your password")},
                leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = PasswordVisualTransformation(),
                colors = TextFieldDefaults.textFieldColors(Color.Yellow)

            )

        }

        Button(onClick = {
            // HANDLE LOGIN LOGIC //
            var xyz = AuthViewModel(navController, mContext)
            xyz.login(email.text,password.text)
        },
            colors = ButtonDefaults.buttonColors(Color.Yellow),
            modifier = Modifier
                .width(300.dp)
                .height(50.dp),
            shape = CutCornerShape(5.dp)) {
            Text(text = "Login")
        }

        Text(text = "No account? Signup",
            modifier = Modifier.clickable {
                navController.navigate(ROUT_SIGNUP)
            },
            fontSize = 15.sp)

    }
}


@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
  LoginScreen(rememberNavController)
}
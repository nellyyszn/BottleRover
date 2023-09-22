package com.example.firebasestorage.screens.about

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.firebasestorage.navigation.ROUT_HOME

@Composable
fun AboutScreen(navController: NavHostController){
    val mContext= LocalContext.current
    Column (modifier = Modifier.fillMaxSize()){
        
        Button(onClick = {
            navController.navigate(ROUT_HOME)
            Toast.makeText(mContext,"Welcome Home",Toast.LENGTH_LONG).show()
        }) {
            Text(text = "Home")
            
        }
    }

}
@Preview(showBackground = true)
@Composable
fun AboutScreenPreview(){
    AboutScreen(rememberNavController())

}

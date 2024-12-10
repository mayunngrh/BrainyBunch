package com.example.brainybunch.presentation.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.brainybunch.R
import com.example.brainybunch.component.HintConfPasswordField
import com.example.brainybunch.component.HintPasswordField
import com.example.brainybunch.component.HintTextField
import com.example.brainybunch.component.NameTextField

@Composable
fun RegisterScreen(
    navController: NavController
) {
    var name by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }

    var pass by remember {
        mutableStateOf("")
    }
    var confPass by remember {
        mutableStateOf("")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF50E94D))
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.height(64.dp))

            Text(
                modifier = Modifier.padding(start = 24.dp),
                text = "Create Your", style = MaterialTheme.typography.bodyMedium,
                fontSize = 38.sp,
                color = Color(0xFF323142),
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier.padding(start = 24.dp),
                text = "Account", style = MaterialTheme.typography.bodyMedium,
                fontSize = 38.sp,
                color = Color(0xFF323142),
                fontWeight = FontWeight.Bold
            )

            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 36.dp)
                        .clip(RoundedCornerShape(topStart = 86.dp))
                        .background(Color(0xFF3D3D3D))
                ) {
                    Column(modifier = Modifier.padding(top = 72.dp, start = 24.dp, end = 24.dp)) {
                        //NAME FIELD
                        NameTextField(hint = "Name", onValueChange = { name = it }, value = name )

                        Spacer(modifier = Modifier.height(12.dp))

                        //EMAIL FIELD
                        HintTextField(hint = "Email", onValueChange = { email = it }, value = email)

                        Spacer(modifier = Modifier.height(12.dp))

                        //PASSWORD FIELD
                        HintPasswordField(
                            hint = "Password",
                            onValueChange = { pass = it },
                            value = pass
                        )

                        Spacer(modifier = Modifier.height(12.dp))
                        HintConfPasswordField(hint = "Confirm Password", onValueChange ={confPass = it} , value = confPass)


                        Spacer(modifier = Modifier.height(24.dp))

                        //LOGIN BUTTON
                        Button(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(64.dp),
                            shape = RoundedCornerShape(24.dp),
                            onClick = { /*TODO*/ },
                            colors = ButtonDefaults.buttonColors(Color(0xFF3DC53A))
                        ) {
                            Text(
                                text = "Register", style = MaterialTheme.typography.bodyMedium,
                                fontSize = 16.sp,
                                color = Color.White,
                                fontWeight = FontWeight.SemiBold
                            )
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                            Text(
                                text = "Already Have Account?", style = MaterialTheme.typography.bodyMedium,
                                fontSize = 16.sp,
                                textAlign = TextAlign.Center,
                                color = Color.White,
                                fontWeight = FontWeight.Medium
                            )
                            Spacer(modifier = Modifier.width(2.dp))

                            Text(

                                text = "LOGIN", style = MaterialTheme.typography.bodyMedium,
                                fontSize = 16.sp,
                                textAlign = TextAlign.Center,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                        }


                    }
                }
                AsyncImage(
                    modifier = Modifier
                        .height(74.dp)
                        .align(Alignment.TopEnd),
                    model = R.drawable.shape_circle,
                    contentDescription = "",
                )

            }
        }
    }
}
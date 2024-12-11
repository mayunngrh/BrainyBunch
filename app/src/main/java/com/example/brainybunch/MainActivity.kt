package com.example.brainybunch

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.brainybunch.presentation.article.ArticleScreen
import com.example.brainybunch.presentation.community.CommunityScreen
import com.example.brainybunch.presentation.home.HomeScreen
import com.example.brainybunch.presentation.login.LoginScreen
import com.example.brainybunch.presentation.register.RegisterScreen
import com.example.brainybunch.presentation.scan.ScanScreen
import com.example.brainybunch.presentation.track_bin.TrackBinScreen
import com.example.brainybunch.ui.theme.BrainyBunchTheme
import dagger.hilt.android.AndroidEntryPoint

lateinit var navController: NavHostController
lateinit var mainViewModel: MainViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(
                android.graphics.Color.TRANSPARENT,
                android.graphics.Color.TRANSPARENT
            )
        )
        super.onCreate(savedInstanceState)
        val _mainViewModel by viewModels<MainViewModel>()
        mainViewModel = _mainViewModel
        setContent {

            navController = rememberNavController()

            //BOTTOM NAVBAR CHECKER
            navController.addOnDestinationChangedListener { _, destination, _ ->
                destination.route?.let {
                    mainViewModel.currentRoute.value = it

                    when (it) {
                        "home", "scan", "track", "article", "community", "track_bin" -> mainViewModel.showBottomBar.value =
                            true

                        else -> mainViewModel.showBottomBar.value = false
                    }
                }
            }

            BrainyBunchTheme(darkTheme = false) {
                Scaffold(
                    bottomBar = {
                        if (mainViewModel.showBottomBar.value){
                            BottomAppBar(
                                modifier = Modifier.height(150.dp),
                                containerColor = Color.Transparent
                            ) {
                                Row {
                                    //ITEM 1
                                    Box(modifier = Modifier
                                        .fillMaxWidth()
                                        .weight(1f)
                                        .height(180.dp)
                                        ) {
                                        Column {
                                            Spacer(modifier = Modifier.height(36.dp))

                                            Column(
                                                modifier = Modifier
                                                    .fillMaxSize()
                                                    .background(
                                                        if (mainViewModel.currentRoute.value == "home") Color(
                                                            0xFF3F4E3E
                                                        ) else Color.White
                                                    )
                                                    .clickable {
                                                        navController.navigate("home")
                                                    }
                                                ,
                                                horizontalAlignment = Alignment.CenterHorizontally,
                                                verticalArrangement = Arrangement.Center
                                            )
                                            {
                                                Icon(
                                                    modifier = Modifier.size(24.dp),
                                                    painter = painterResource(id = R.drawable.icon_home),
                                                    contentDescription = "Icon Beranda Bottom Bar",
                                                    tint = if (mainViewModel.currentRoute.value == "home") Color.White else Color(0xFF3F4E3E)
                                                )
                                                Text(
                                                    text = "Home",
                                                    style = MaterialTheme.typography.bodySmall,
                                                    color = if (mainViewModel.currentRoute.value == "home") Color.White else Color(0xFF3F4E3E)
                                                )
                                            }
                                        }
                                    }

                                    //ITEM 2
                                    Box(modifier = Modifier
                                        .fillMaxWidth()
                                        .weight(1f)
                                        .height(180.dp)
                                    ) {
                                        Column {
                                            Spacer(modifier = Modifier.height(36.dp))

                                            Column(
                                                modifier = Modifier
                                                    .fillMaxSize()
                                                    .background(
                                                        if (mainViewModel.currentRoute.value == "scan") Color(
                                                            0xFF3F4E3E
                                                        ) else Color.White
                                                    )
                                                    .clickable {
                                                        navController.navigate("scan")
                                                    }
                                                ,
                                                horizontalAlignment = Alignment.CenterHorizontally,
                                                verticalArrangement = Arrangement.Center
                                            )
                                            {
                                                Icon(
                                                    modifier = Modifier.size(24.dp),
                                                    painter = painterResource(id = R.drawable.icon_scan),
                                                    contentDescription = "Icon Beranda Bottom Bar",
                                                    tint = if (mainViewModel.currentRoute.value == "scan") Color.White else Color(0xFF3F4E3E)
                                                )
                                                Text(
                                                    text = "Scan",
                                                    style = MaterialTheme.typography.bodySmall,
                                                    color = if (mainViewModel.currentRoute.value == "scan") Color.White else Color(0xFF3F4E3E)
                                                )
                                            }
                                        }
                                    }

                                    //ITEM 3
                                    Box(modifier = Modifier
                                        .fillMaxWidth()
                                        .weight(1f)
                                        .height(180.dp)
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .height(60.dp)
                                                .align(Alignment.BottomCenter)
                                                .background(
                                                    if (mainViewModel.currentRoute.value == "track_bin") Color(
                                                        0xFF3F4E3E
                                                    ) else Color.White
                                                )
                                        )
                                        Column {
                                            Column(
                                                modifier = Modifier
                                                    .fillMaxSize()
                                                    .clickable {
                                                        navController.navigate("track_bin")
                                                    }
                                                ,
                                                horizontalAlignment = Alignment.CenterHorizontally
                                            )
                                            {
                                                AsyncImage(
                                                    modifier = Modifier.size(75.dp),
                                                    model = R.drawable.icon_track_bin,
                                                    contentDescription = "Icon Beranda Bottom Bar",
                                                )
                                                Spacer(modifier = Modifier.height(4.dp))
                                                Text(
                                                    text = "Track Bin",
                                                    style = MaterialTheme.typography.bodySmall,
                                                    color = if (mainViewModel.currentRoute.value == "track_bin") Color.White else Color(0xFF3F4E3E)
                                                )
                                            }
                                        }
                                    }

                                    //ITEM 4
                                    Box(modifier = Modifier
                                        .fillMaxWidth()
                                        .weight(1f)
                                        .height(180.dp)
                                    ) {
                                        Column {
                                            Spacer(modifier = Modifier.height(36.dp))

                                            Column(
                                                modifier = Modifier
                                                    .fillMaxSize()
                                                    .background(
                                                        if (mainViewModel.currentRoute.value == "article") Color(
                                                            0xFF3F4E3E
                                                        ) else Color.White
                                                    )
                                                    .clickable {
                                                        navController.navigate("article")
                                                    }
                                                ,
                                                horizontalAlignment = Alignment.CenterHorizontally,
                                                verticalArrangement = Arrangement.Center
                                            )
                                            {
                                                Icon(
                                                    modifier = Modifier.size(24.dp),
                                                    painter = painterResource(id = R.drawable.icon_article),
                                                    contentDescription = "Icon Beranda Bottom Bar",
                                                    tint = if (mainViewModel.currentRoute.value == "article") Color.White else Color(0xFF3F4E3E)
                                                )
                                                Text(
                                                    text = "Article",
                                                    style = MaterialTheme.typography.bodySmall,
                                                    color = if (mainViewModel.currentRoute.value == "article") Color.White else Color(0xFF3F4E3E)
                                                )
                                            }
                                        }
                                    }
                                    //ITEM 5
                                    Box(modifier = Modifier
                                        .fillMaxWidth()
                                        .weight(1f)
                                        .height(180.dp)
                                    ) {
                                        Column {
                                            Spacer(modifier = Modifier.height(36.dp))

                                            Column(
                                                modifier = Modifier
                                                    .fillMaxSize()
                                                    .background(
                                                        if (mainViewModel.currentRoute.value == "community") Color(
                                                            0xFF3F4E3E
                                                        ) else Color.White
                                                    )
                                                    .clickable {
                                                        navController.navigate("community")
                                                    }
                                                ,
                                                horizontalAlignment = Alignment.CenterHorizontally,
                                                verticalArrangement = Arrangement.Center
                                            )
                                            {
                                                Icon(
                                                    modifier = Modifier.size(24.dp),
                                                    painter = painterResource(id = R.drawable.icon_community),
                                                    contentDescription = "Icon Beranda Bottom Bar",
                                                    tint = if (mainViewModel.currentRoute.value == "community") Color.White else Color(0xFF3F4E3E)
                                                )
                                                Text(
                                                    text = "Community",
                                                    style = MaterialTheme.typography.bodySmall,
                                                    color = if (mainViewModel.currentRoute.value == "community") Color.White else Color(0xFF3F4E3E)
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                ) {
                    NavHost(
                        modifier = Modifier.padding(it),
                        navController = navController,
                        startDestination = "home"
                    ) {
                        composable("home") {
                            HomeScreen(navController = navController)
                        }
                        composable("login") {
                            LoginScreen(navController = navController)
                        }

                        composable("register") {
                            RegisterScreen(navController = navController)
                        }
                        composable("scan") {
                            ScanScreen(navController = navController)
                        }
                        composable("article") {
                            ArticleScreen(navController = navController)
                        }
                        composable("community") {
                            CommunityScreen(navController = navController)
                        }

                        composable("track_bin") {
                            TrackBinScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}

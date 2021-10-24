package com.kikopoggi.profilecardlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kikopoggi.profilecardlayout.ui.theme.ProfileCardLayoutTheme
import com.kikopoggi.profilecardlayout.ui.theme.lightGreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfileCardLayoutTheme() {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen(userProfiles: List<UserProfile> = userProfileList) {
    Scaffold(topBar = {AppBar()}) {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            LazyColumn {
                items(userProfiles) { userProfile ->
                    ProfileCard(userProfile = userProfile)
                }
            }
        }
    }
}

@Composable
fun AppBar() {
    TopAppBar(
        title = {
            Text("AppBar")
        },
        navigationIcon = {
            Icon(Icons.Default.Home,
                contentDescription = "home",
                modifier = Modifier.padding(start = 8.dp)
            )
        }
    )
}

@Composable
fun ProfileCard(userProfile: UserProfile) {
    Card(
        modifier = Modifier
            .padding(8.dp, 4.dp, 8.dp, 4.dp)
            .fillMaxWidth()
            .wrapContentHeight(align = Alignment.Top),
        elevation = 12.dp,
        backgroundColor = Color.White
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            ProfilePicture(userProfile.drawableId, userProfile.status)
            ProfileContent(userProfile.name, userProfile.status)
        }
    }
}

@Composable
fun ProfilePicture(drawableID: Int, onlineStatus: Boolean) {
    Card(
        shape = CircleShape,
        border = BorderStroke(
            width = 3.dp,
            color = if (onlineStatus) {
                MaterialTheme.colors.lightGreen
            } else {
                Color.Magenta
            }
        ),
        modifier = Modifier.padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = drawableID),
            contentDescription = "Content Description",
            modifier = Modifier.size(72.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun ProfileContent(userName: String, onlineStatus: Boolean) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = userName,
            style = MaterialTheme.typography.h5
        )
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
            Text(
                text = if (onlineStatus)"Ativo" else "Offline",
                style = MaterialTheme.typography.body2
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ProfileCardLayoutTheme() {
        MainScreen()
    }
}
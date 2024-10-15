package com.example.art

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.art.ui.theme.ARTTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ARTTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Art(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Art(modifier: Modifier = Modifier) {
    var artNumber by remember {
        mutableIntStateOf(1)
    }

    when (artNumber) {
        1 -> ArtTextAndImage(
            R.drawable.buildings_with_lights_at_nighttime,
            R.string.description_1,
            R.string.art_1_description,
            R.string.autor_1,
            R.string.year_1,
            { artNumber = 1 },
            { artNumber++ }
        )

        2 -> ArtTextAndImage(
            R.drawable.arc_de_triomphe__paris,
            R.string.description_1,
            R.string.art_2_description,
            R.string.autor_2,
            R.string.year_2,
            { if (artNumber != 1) artNumber-- },
            { artNumber++ }
        )

        3 -> ArtTextAndImage(
            R.drawable.statue_of_liberty,
            R.string.description_3,
            R.string.art_3_description,
            R.string.autor_3,
            R.string.year_3,
            { if (artNumber != 1) artNumber-- },
            { artNumber++ }
        )

        4 -> ArtTextAndImage(
            R.drawable.low_angle_photo_of_eiffel_tower,
            R.string.description_4,
            R.string.art_4_description,
            R.string.autor_4,
            R.string.year_4,
            { if (artNumber != 1) artNumber-- },
            { artNumber++ }
        )

        5 -> ArtTextAndImage(
            R.drawable.great_wall_of_china,
            R.string.description_5,
            R.string.art_5_description,
            R.string.autor_5,
            R.string.year_5,
            { if (artNumber != 1) artNumber-- },
            { artNumber=1 }
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ArtPreview() {
    var artNumber by remember {
        mutableIntStateOf(1)
    }

    when (artNumber) {
        1 -> ArtTextAndImage(
            R.drawable.buildings_with_lights_at_nighttime,
            R.string.description_1,
            R.string.art_1_description,
            R.string.autor_1,
            R.string.year_1,
            { artNumber = 1 },
            { artNumber++ }
        )

        2 -> ArtTextAndImage(
            R.drawable.arc_de_triomphe__paris,
            R.string.description_1,
            R.string.art_2_description,
            R.string.autor_2,
            R.string.year_2,
            { if (artNumber != 1) artNumber-- },
            { artNumber++ }
        )

        3 -> ArtTextAndImage(
            R.drawable.statue_of_liberty,
            R.string.description_3,
            R.string.art_3_description,
            R.string.autor_3,
            R.string.year_3,
            { if (artNumber != 1) artNumber-- },
            { artNumber++ }
        )

        4 -> ArtTextAndImage(
            R.drawable.low_angle_photo_of_eiffel_tower,
            R.string.description_4,
            R.string.art_4_description,
            R.string.autor_4,
            R.string.year_4,
            { if (artNumber != 1) artNumber-- },
            { artNumber++ }
        )

        5 -> ArtTextAndImage(
            R.drawable.great_wall_of_china,
            R.string.description_5,
            R.string.art_5_description,
            R.string.autor_5,
            R.string.year_5,
            { if (artNumber != 1) artNumber-- },
            { artNumber=1 }
        )
    }
}

@Composable
fun ArtTextAndImage(
    imageId: Int,
    imageStringDescription: Int,
    artTitleId: Int,
    autorId: Int,
    yearId: Int,
    previous: () -> Unit,
    next: () -> Unit,
    modifier: Modifier = Modifier
) {
    val image = painterResource(id = imageId)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .padding(20.dp)
            .fillMaxSize()
            .statusBarsPadding()
            .verticalScroll(rememberScrollState())
            .safeDrawingPadding(),
    ) {
        Column(
            modifier = modifier
                .shadow(
                    elevation = 16.dp,
                    ambientColor = Color.Gray,
                    spotColor = Color.Black
                )
                .border(
                    border = BorderStroke(
                        40.dp,
                        Color.White,
                    ),
                )
        ) {
            Image(
                painter = image,
                contentDescription = stringResource(imageStringDescription)
            )
        }
        Spacer(modifier = Modifier.height(50.dp))
        Column(
            modifier = Modifier
                .background(Color(0xFFECEBF0))
                .padding(20.dp)
        ) {
            Column {
                Text(
                    text = stringResource(artTitleId),
                    fontWeight = FontWeight.Light,
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.height(5.dp))
                Row {
                    Text(
                        text = stringResource(autorId),
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = stringResource(yearId),
                        fontWeight = FontWeight.Light
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(50.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Button(
                onClick = previous,
                modifier = Modifier
                    .width(150.dp)
            ) {
                Text(text = "Previous")
            }
            Button(
                onClick = next,
                modifier = Modifier
                    .width(150.dp)
            ) {
                Text(text = "Next")
            }
        }
    }
}
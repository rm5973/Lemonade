package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
Surface(){

    LemoNadePreview()
}

            }
        }
    }
}

@Composable
fun LemonNadeProcess(modifier: Modifier = Modifier) {
    var step by remember { mutableStateOf(1) }
    var clicks by remember {
        mutableStateOf(0)
    }
    val imageresource=when(step){
        1->R.drawable.lemon_tree
        2->R.drawable.lemon_squeeze
        3->R.drawable.lemon_drink
        else->R.drawable.lemon_restart
    }
 Column(horizontalAlignment =Alignment.CenterHorizontally,modifier=modifier){
    Button(onClick = {
clicks++
if(step==2){
    var ran=(1..3).random()
if(ran==clicks-1)
{
    step++
}

}
else{
            step++
        }


    }, shape = RoundedCornerShape(25.dp)) {
        Image(painter = painterResource(imageresource), contentDescription =step.toString(), )
    }
     Spacer(modifier = Modifier.height(15.dp))
    Text(
        text = "Tap the lemon tree to select a lemon",

    )
}}

@Preview( showSystemUi = true)
@Composable
fun LemoNadePreview() {
    LemonadeTheme {
        LemonNadeProcess(modifier= Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center))
    }
}
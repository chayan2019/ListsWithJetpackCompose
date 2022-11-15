package com.withjetpack.listswithjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.withjetpack.listswithjetpackcompose.ui.theme.ListsWithJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListsWithJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
               // ColumnList()
               // LazyColumnList()
                LazyColumnStringList()
            }
        }
    }

    @Composable
    private fun LazyColumnStringList() {
        LazyColumn(){
            itemsIndexed(listOf("mango","apple","banana","guava","lemon")){
                index, item ->
                Text(
                    text = "$item",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                )
            }
        }
    }

    @Composable
    private fun LazyColumnList() {

        LazyColumn{

            items(5){
                Text(
                    text = "Lazy List Index $it",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                )
            }
        }
    }

    @Composable
    private fun ColumnList() {
        val scrollstate = rememberScrollState()
        Column(modifier = Modifier.verticalScroll(scrollstate)) {
            for (i in 1..5) {
                Text(
                    text = "Column List Index $i",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                )
            }
        }    }
}

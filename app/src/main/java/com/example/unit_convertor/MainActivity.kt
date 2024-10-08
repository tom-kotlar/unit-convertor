package com.example.unit_convertor

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.unit_convertor.ui.theme.UnitconvertorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UnitconvertorTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    UnitConvertor( modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun UnitConvertor(modifier: Modifier = Modifier) {
    Column {
        Text( "Unit Convertor", modifier = modifier)
        OutlinedTextField(value = "", onValueChange = {})

        Row {
            val localContext = LocalContext.current
            Button(onClick = {
                Toast.makeText(localContext,"I am Toast", Toast.LENGTH_LONG).show()
            }) {
                Text("MY BUTTON")
            }
        }

    }
}


@Preview(showBackground = true)
@Composable
fun UnitConvertorPreview() {
    UnitConvertor()
}
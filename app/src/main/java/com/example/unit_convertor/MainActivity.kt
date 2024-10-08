package com.example.unit_convertor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement =  Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text( "Unit Convertor", modifier = modifier)
        OutlinedTextField(value = "", onValueChange = {})
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Box {
                Button({}) {
                    Text("Select")
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow Drop Down")
                }
            }
            DropdownMenu(expanded = true, onDismissRequest = {}) {
                DropdownMenuItem(
                    text = {Text("Centimeters")},
                    onClick = {}
                )
                DropdownMenuItem(
                    text = {Text("Meters")},
                    onClick = {}
                )
                DropdownMenuItem(
                    text = {Text("Feet")},
                    onClick = {}
                )
                DropdownMenuItem(
                    text = {Text("Millimeters")},
                    onClick = {}
                )
            }


            Spacer(modifier = Modifier.width(16.dp))
            Box {
                Button({}) {
                    Text("Select")
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow Drop Down")
                }
            }
            DropdownMenu(expanded = true, onDismissRequest = {}) {
                DropdownMenuItem(
                    text = {Text("Centimeters")},
                    onClick = {}
                )
                DropdownMenuItem(
                    text = {Text("Meters")},
                    onClick = {}
                )
                DropdownMenuItem(
                    text = {Text("Feet")},
                    onClick = {}
                )
                DropdownMenuItem(
                    text = {Text("Millimeters")},
                    onClick = {}
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text( "Result:", )
    }
}


@Preview(showBackground = true)
@Composable
fun UnitConvertorPreview() {
    UnitConvertor()
}
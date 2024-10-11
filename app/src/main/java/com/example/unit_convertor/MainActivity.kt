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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.setValue
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
    var inputValue by remember { mutableStateOf("") }
    var outputValue by remember { mutableStateOf("") }
    var inputUnit by remember { mutableStateOf("Centimeters") }
    var outputUnit by remember { mutableStateOf("Meters") }
    var isExpandedInput by remember { mutableStateOf(false) }
    var isExpandedOutput by remember { mutableStateOf(false) }
    var conversionFactor = remember { mutableDoubleStateOf(1.00) }
    var oConversionFactor = remember { mutableDoubleStateOf(1.00) }

    fun convertUnits() {
        val inputValueDouble = inputValue.toDoubleOrNull() ?: 0.0
        val result = (inputValueDouble * conversionFactor.doubleValue / oConversionFactor.doubleValue).toString()
        outputValue = result
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Unit Converter", modifier = modifier)

        OutlinedTextField(
            value = inputValue,
            onValueChange = {
                inputValue = it
                convertUnits()
            },
            label = { Text("Enter Value") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row {
            // Input Unit Dropdown
            Box {
                Button(onClick = { isExpandedInput = true }) {
                    Text(text = inputUnit)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow Drop Down")
                }
                // Input Dropdown Menu
                DropdownMenu(
                    expanded = isExpandedInput,
                    onDismissRequest = { isExpandedInput = false }
                ) {
                    DropdownMenuItem(
                        text = { Text("Centimeters") },
                        onClick = {
                            isExpandedInput = false
                            inputUnit = "Centimeters"
                            conversionFactor.doubleValue = 0.01
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Meters") },
                        onClick = {
                            isExpandedInput = false
                            inputUnit = "Meters"
                            conversionFactor.doubleValue = 1.0
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Feet") },
                        onClick = {
                            isExpandedInput = false
                            inputUnit = "Feet"
                            conversionFactor.doubleValue = 0.348
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Millimeters") },
                        onClick = {
                            isExpandedInput = false
                            inputUnit = "Millimeters"
                            conversionFactor.doubleValue = 0.001
                            convertUnits()
                        }
                    )
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

            // Output Unit Dropdown
            Box {
                Button(onClick = { isExpandedOutput = true }) {
                    Text(text = outputUnit)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow Drop Down")
                }
                // Output Dropdown Menu
                DropdownMenu(
                    expanded = isExpandedOutput,
                    onDismissRequest = { isExpandedOutput = false }
                ) {
                    DropdownMenuItem(
                        text = { Text("Centimeters") },
                        onClick = {
                            isExpandedOutput = false
                            outputUnit = "Centimeters"
                            oConversionFactor.doubleValue = 0.01
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Meters") },
                        onClick = {
                            isExpandedOutput = false
                            outputUnit = "Meters"
                            oConversionFactor.doubleValue = 1.00
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Feet") },
                        onClick = {
                            isExpandedOutput = false
                            outputUnit = "Feet"
                            oConversionFactor.doubleValue = 0.348
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Millimeters") },
                        onClick = {
                            isExpandedOutput = false
                            outputUnit = "Millimeters"
                            oConversionFactor.doubleValue = 0.001
                            convertUnits()
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text("Result: $outputValue $outputUnit")
    }
}

@Preview(showBackground = true)
@Composable
fun UnitConvertorPreview() {
    UnitConvertor()
}

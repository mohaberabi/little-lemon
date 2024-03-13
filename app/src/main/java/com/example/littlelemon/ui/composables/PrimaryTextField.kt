package com.example.littlelemon.ui.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.littlelemon.ui.theme.AppColors
import com.example.littlelemon.ui.theme.Typography
import okhttp3.internal.wait


@Composable
fun SecondaryTextField(
    value: String = "",
    onChanged: (String) -> Unit = {},
    keyboardType: KeyboardType = KeyboardType.Text,
    isEnabled: Boolean = true,
    leading: @Composable () -> Unit = {},
    filledColor: Color = Color.White,
    label: @Composable () -> Unit,
) {
    TextField(
        value = value, prefix = leading,
        enabled = isEnabled,
        label = label,
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = keyboardType),
        onValueChange = onChanged,
        modifier = Modifier.padding(16.dp),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = filledColor,
            unfocusedContainerColor = filledColor,
            focusedIndicatorColor = AppColors.primaryColor,
        ),
    )
}


@Composable
fun PrimaryTextField(
    value: String = "",
    label: String = "",
    onChanged: (String) -> Unit = {},
    leading: @Composable () -> Unit = {},
    keyboardType: KeyboardType = KeyboardType.Text,
    isReadOnly: Boolean = false,
) {
    OutlinedTextField(
        prefix = leading,
        readOnly = isReadOnly,
        value = value,
        onValueChange = onChanged,
        textStyle = Typography.bodyLarge,
        colors = primaryTextFieldColors(),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = keyboardType),
        label = {
            Text(
                text = label,
                style = Typography.bodyMedium
            )
        }

    )
}


@Composable
fun primaryTextFieldColors(bgColor: Color? = null): TextFieldColors {
    return OutlinedTextFieldDefaults.colors(
        focusedBorderColor = AppColors.primaryColor,
        focusedLabelColor = AppColors.primaryColor,
        unfocusedBorderColor = AppColors.lightGrey,

        )
}


@Composable
@Preview(showBackground = true)
private fun PrimaryTextFieldPreview() {
//    SecondaryTextField()
    PrimaryTextField(value = "First Name ")
}
package com.example.littlelemon.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.littlelemon.ui.theme.AppColors
import org.w3c.dom.Text

@Composable
fun PrimaryButton(
    label: String = "",
    onPress: () -> Unit,
    enabled: Boolean = true,
    color: Color = AppColors.primaryColor,
    disabledColor: Color = AppColors.lightGrey,
    contentColor: Color = AppColors.primaryDark,
    borderRadius: Dp = 8.dp
) {
    val colors = ButtonDefaults.buttonColors(
        containerColor = color,
        disabledContainerColor = disabledColor,
        contentColor = contentColor
    )
    Button(
        enabled = enabled,
        shape = RoundedCornerShape(borderRadius),
        colors = colors,
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        onClick = onPress,
    ) {
        Text(text = label,)
    }


}


@Preview(showBackground = true)
@Composable
private fun PrimaryButtonPreview() {
    PrimaryButton(onPress = {}, label = "Get Started", enabled = true)
}

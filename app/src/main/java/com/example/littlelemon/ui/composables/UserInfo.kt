package com.example.littlelemon.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.littlelemon.R
import com.example.littlelemon.ui.theme.AppColors
import com.example.littlelemon.ui.theme.Typography


@Composable

fun UserInfoCompose(
    onNameChanged: (String) -> Unit = {},
    onLastNameChanged: (String) -> Unit = {},
    onEmailChanged: (String) -> Unit = {},
    onButtonPressed: () -> Unit = {},
    enabled: Boolean = true,
    name: String = "",
    lastName: String = "",
    email: String = "",
    buttonLabel: String = "",
    isReaOnly: Boolean = false,
) {
    Column(
        horizontalAlignment = Alignment.Start
    ) {

        AppLogo()

        if (isReaOnly) Text(
            modifier = Modifier.padding(
                16.dp,
            ),
            text = "Personal Information",
            style = Typography.headlineMedium
        ) else Surface(
            color = AppColors.primaryDark,
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
        ) {
            Text(
                text = "Let's Get To Know You",
                style = Typography.headlineMedium.copy(color = Color.White),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(vertical = 20.dp)

            )


        }

        PrimaryTextField(
            label = stringResource(id = R.string.firstName),
            onChanged = onNameChanged,
            value = name,
            isReadOnly = isReaOnly,

            )

        PrimaryTextField(
            label = stringResource(id = R.string.lastName),
            onChanged = onLastNameChanged,
            value = lastName,
            isReadOnly = isReaOnly,
        )
        PrimaryTextField(
            label = stringResource(id = R.string.email),
            keyboardType = KeyboardType.Email,
            onChanged = onEmailChanged,
            value = email,
            isReadOnly = isReaOnly,
        )

        PrimaryButton(
            enabled = enabled,
            onPress = onButtonPressed,
            label = buttonLabel
        )
    }
}

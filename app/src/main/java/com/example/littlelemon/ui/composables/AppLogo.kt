package com.example.littlelemon.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.littlelemon.R

@Composable

fun AppLogo(
    width: Dp = 200.dp,
    height: Dp = 50.dp
) {
    Image(
        painter = painterResource(id = R.drawable.logo),
        alignment = Alignment.Center,
        modifier = Modifier
            .width(width)
            .height(height)
            .padding(8.dp),
        contentDescription = stringResource(id = R.string.app_logo)
    )
}

@Composable

fun AppLogo(
    modifier: Modifier = Modifier,
) {
    Image(
        painter = painterResource(id = R.drawable.logo),
        alignment = Alignment.Center,
        modifier = modifier.padding(8.dp),
        contentDescription = stringResource(id = R.string.app_logo)
    )
}


@Preview(showBackground = true)
@Composable

private fun AppLogoPreview() {

    AppLogo()
}

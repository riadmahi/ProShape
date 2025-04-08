package com.riadmahi.proshape

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

fun Modifier.proShape(cornerRadius: Dp = 20.dp): Modifier {
    return this.clip(ProShape.rounded(cornerRadius))
}
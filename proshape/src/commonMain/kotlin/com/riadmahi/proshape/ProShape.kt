package com.riadmahi.proshape

import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

object ProShape {

    fun rounded(cornerRadius: Dp = 20.dp): Shape =
        ProSquircleShape(
            topStart = cornerRadius,
            topEnd = cornerRadius,
            bottomStart = cornerRadius,
            bottomEnd = cornerRadius
        )

    fun topRounded(cornerRadius: Dp = 20.dp): Shape =
        ProSquircleShape(
            topStart = cornerRadius,
            topEnd = cornerRadius
        )

    fun bottomRounded(cornerRadius: Dp = 20.dp): Shape =
        ProSquircleShape(
            bottomStart = cornerRadius,
            bottomEnd = cornerRadius
        )

    fun startRounded(cornerRadius: Dp = 20.dp): Shape =
        ProSquircleShape(
            topStart = cornerRadius,
            bottomStart = cornerRadius
        )

    fun endRounded(cornerRadius: Dp = 20.dp): Shape =
        ProSquircleShape(
            topEnd = cornerRadius,
            bottomEnd = cornerRadius
        )

    fun leftRounded(cornerRadius: Dp = 20.dp): Shape =
        startRounded(cornerRadius)

    fun rightRounded(cornerRadius: Dp = 20.dp): Shape =
        endRounded(cornerRadius)

    fun topStartRounded(cornerRadius: Dp = 20.dp): Shape =
        ProSquircleShape(topStart = cornerRadius)

    fun topEndRounded(cornerRadius: Dp = 20.dp): Shape =
        ProSquircleShape(topEnd = cornerRadius)

    fun bottomStartRounded(cornerRadius: Dp = 20.dp): Shape =
        ProSquircleShape(bottomStart = cornerRadius)

    fun bottomEndRounded(cornerRadius: Dp = 20.dp): Shape =
        ProSquircleShape(bottomEnd = cornerRadius)

}
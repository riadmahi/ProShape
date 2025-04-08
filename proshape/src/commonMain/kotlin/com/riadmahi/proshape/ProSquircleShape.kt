package com.riadmahi.proshape

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import kotlin.math.min

class ProSquircleShape(
    private val topStart: Dp = Dp.Unspecified,
    private val topEnd: Dp = Dp.Unspecified,
    private val bottomEnd: Dp = Dp.Unspecified,
    private val bottomStart: Dp = Dp.Unspecified
) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {

        val radiusTopStart =
            if (topStart != Dp.Unspecified) with(density) { topStart.toPx() } else 0f
        val radiusTopEnd = if (topEnd != Dp.Unspecified) with(density) { topEnd.toPx() } else 0f
        val radiusBottomEnd =
            if (bottomEnd != Dp.Unspecified) with(density) { bottomEnd.toPx() } else 0f
        val radiusBottomStart =
            if (bottomStart != Dp.Unspecified) with(density) { bottomStart.toPx() } else 0f

        val path = Path()

        val maxRadius = min(size.width, size.height) / 2f
        val rTopStart = min(radiusTopStart, maxRadius)
        val rTopEnd = min(radiusTopEnd, maxRadius)
        val rBottomEnd = min(radiusBottomEnd, maxRadius)
        val rBottomStart = min(radiusBottomStart, maxRadius)

        path.reset()
        path.moveTo(rTopStart, 0f)
        path.lineTo(size.width - rTopEnd, 0f)
        path.quadraticTo(size.width, 0f, size.width, rTopEnd)
        path.lineTo(size.width, size.height - rBottomEnd)
        path.quadraticTo(size.width, size.height, size.width - rBottomEnd, size.height)
        path.lineTo(rBottomStart, size.height)
        path.quadraticTo(0f, size.height, 0f, size.height - rBottomStart)
        path.lineTo(0f, rTopStart)
        path.quadraticTo(0f, 0f, rTopStart, 0f)
        path.close()

        return Outline.Generic(path)
    }
}
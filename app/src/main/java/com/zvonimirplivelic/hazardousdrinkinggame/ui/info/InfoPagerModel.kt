package com.zvonimirplivelic.hazardousdrinkinggame.ui.info

import com.zvonimirplivelic.hazardousdrinkinggame.R

enum class InfoPagerModel private constructor(
    val titleResId: Int,
    val layoutResId: Int
) {
    WARNING(R.string.warning, R.layout.layout_warning),
    SAFETY(R.string.safety, R.layout.layout_safety),
    READY(R.string.ready, R.layout.layout_ready)
}
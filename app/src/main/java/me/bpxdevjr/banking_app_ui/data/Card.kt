package me.bpxdevjr.banking_app_ui.data

import androidx.compose.ui.graphics.Brush
import me.bpxdevjr.banking_app_ui.data.types.CardType


data class Card(
    val type: CardType,
    val number: String,
    val customerName: String,
    val expiryDate: String,
    val color: Brush
)

package me.bpxdevjr.banking_app_ui.sections

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.bpxdevjr.banking_app_ui.R
import me.bpxdevjr.banking_app_ui.data.Card
import me.bpxdevjr.banking_app_ui.data.types.CardType
import me.bpxdevjr.banking_app_ui.ui.theme.BlueEnd
import me.bpxdevjr.banking_app_ui.ui.theme.BlueStart
import me.bpxdevjr.banking_app_ui.ui.theme.GreenEnd
import me.bpxdevjr.banking_app_ui.ui.theme.GreenStart
import me.bpxdevjr.banking_app_ui.ui.theme.PurpleEnd
import me.bpxdevjr.banking_app_ui.ui.theme.PurpleStart


val cards: MutableList<Card> = mutableListOf(
    Card(
        type = CardType.VISA,
        number = "3664 9876 2344 5476",
        customerName = "Mr. ABDELLAH DAKIR ALLAH",
        expiryDate = "10 / 29",
        color = getGradient(PurpleStart, PurpleEnd)
    ),
    Card(
        type = CardType.MASTER_CARD,
        number = "7865 0982 5477 9655",
        customerName = "Mr. BLACK PURPLE JUNIOR",
        expiryDate = "04 / 31",
        color = getGradient(BlueStart, BlueEnd)
    ),
    Card(
        type = CardType.VISA,
        number = "1246 9865 5324 0776",
        customerName = "Mr. ABDELLAH DAKIR ALLAH",
        expiryDate = "01 / 30",
        color = getGradient(GreenStart, GreenEnd)
    )
)

fun getGradient(startColor: Color, endColor: Color): Brush {
    return Brush.horizontalGradient(colors = listOf(startColor, endColor))
}


@Preview
@Composable
fun CardSection() {
    LazyRow {
        items(cards.size) { index ->
            CardItem(index, card = cards[index])
        }
    }
}

@Composable
fun CardItem(index: Int, card: Card) {
    val card = cards[index]
    var lastItemPaddingEnd = 0.dp
    if (index == cards.size - 1) lastItemPaddingEnd = 16.dp

    var image: Painter = painterResource(R.drawable.ic_visa)
    if (card.type == CardType.MASTER_CARD) image = painterResource(R.drawable.ic_mastercard)

    Box(modifier = Modifier.padding(start = 16.dp, end = lastItemPaddingEnd)) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(card.color)
                .width(250.dp)
                .height(160.dp)
                .clickable {}
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = image,
                contentDescription = card.customerName,
                modifier = Modifier.width(55.dp)
            )

            Spacer(modifier = Modifier.height(28.dp))

            Text(
                text = card.number,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text (
                text = card.expiryDate,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.align(Alignment.End).offset(x = (0).dp, y = (-10).dp)

            )

            Text(
                text = card.customerName,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
            )
        }
    }
}
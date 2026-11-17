package me.bpxdevjr.banking_app_ui.sections

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MonetizationOn
import androidx.compose.material.icons.rounded.StarHalf
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.bpxdevjr.banking_app_ui.data.Finance
import me.bpxdevjr.banking_app_ui.ui.theme.BlueStart
import me.bpxdevjr.banking_app_ui.ui.theme.GreenStart
import me.bpxdevjr.banking_app_ui.ui.theme.OrangeStart
import me.bpxdevjr.banking_app_ui.ui.theme.PurpleStart

val financeList: List<Finance> = listOf(
    Finance(
        icon = Icons.Rounded.StarHalf,
        name = "My\nBusiness",
        color = OrangeStart
    ),
    Finance(
        icon = Icons.Rounded.Wallet,
        name = "My\nWallet",
        color = BlueStart
    ),
    Finance(
        icon = Icons.Rounded.StarHalf,
        name = "Finance\nAnalytics",
        color = PurpleStart
    ),
    Finance(
        icon = Icons.Rounded.MonetizationOn,
        name = "My\nTransactions",
        color = GreenStart
    )
)


@Preview
@Composable
fun FinanceSection() {
    Column {
        Text(
            text = "Finance",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(16.dp)
        )
        LazyRow {
            items(financeList.size) {
                FinanceItem(it)
            }
        }
    }
}


@Composable
fun FinanceItem(index: Int) {
    val finance = financeList[index]
    var lastPaddingEnd = 0.dp
    if (index == financeList.size - 1) lastPaddingEnd = 16.dp

    Box(modifier = Modifier.padding(start = 16.dp, end = lastPaddingEnd)) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .background(MaterialTheme.colorScheme.secondaryContainer)
                .size(120.dp)
                .clickable {}
                .padding(12.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(finance.color)
                    .padding(10.dp)
            ) {
                Icon(
                    imageVector = finance.icon,
                    contentDescription = finance.name,
                    tint = Color.White
                )
            }
            Text(
                text = finance.name,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                fontWeight = FontWeight.SemiBold,
                fontSize = 15.sp
            )
        }
    }

}






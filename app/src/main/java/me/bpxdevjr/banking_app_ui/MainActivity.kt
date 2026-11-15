package me.bpxdevjr.banking_app_ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import me.bpxdevjr.banking_app_ui.sections.BottomNavigationBar
import me.bpxdevjr.banking_app_ui.sections.BalanceSection
import me.bpxdevjr.banking_app_ui.sections.CardSection
import me.bpxdevjr.banking_app_ui.ui.theme.BankingAppUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BankingAppUITheme {
                setBarColor(color = MaterialTheme.colorScheme.background)
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) { HomeScreen() }
            }
        }
    }

    @Composable
    private fun setBarColor(color: Color) {
        val systemUiController = rememberSystemUiController()
        SideEffect { systemUiController.setSystemBarsColor(color = color) }
    }

}

@Preview
@Composable
fun HomeScreen(){
    Scaffold(bottomBar = { BottomNavigationBar() }) { padding ->
        Column (modifier = Modifier.fillMaxSize().padding(padding)) {
            BalanceSection()
            CardSection()
            Spacer(modifier = Modifier.height(16.dp))

        }
    }
}












package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    private lateinit var minhaViewModelQueEuCrieiAgoraPouco : MinhaViewModelBemSimples
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        minhaViewModelQueEuCrieiAgoraPouco = ViewModelProvider(this).get(MinhaViewModelBemSimples::class.java)

        setContent  {
            MainScreen(minhaViewModelQueEuCrieiAgoraPouco)
        }
    }
}



@Composable
fun MainScreen(umaViewModel: MinhaViewModelBemSimples){
    var ContadorNaView by remember {
        mutableStateOf(0)
    }
    val ContadorProvenienteDaMinhaModelView by umaViewModel.contadprDaViewPublico.collectAsState()
    Column() {

        Row() {                                                 //CREMENTANDO
            Button(onClick = { ContadorNaView = ContadorNaView + 1 //coisa de estudante
                umaViewModel.incrementoContador() //coisa aqui e prof
            })
            {
                Text(text = "INCREMENTA CONTADOR")
                //Text(text = "INCREMENTA CONTATDOR PELA VIEWMODEL = $ContadorProvenienteDaMinhaModelView")
            }

        }
        //INCREMENTANDO
        Button(onClick = { ContadorNaView = ContadorNaView - 1 //coisa de estudante
            umaViewModel.desincrementoContador() //coisa aqui e prof
        })
        {
            //Text(text = "INCREMENTA CONTATDOR PELA VIEW = $ContadorNaView")
            Text(text = "DESINCREMENTA CONTATDOR")
        }


        Text(text = "INCREMENTA CONTATDOR PELA VIEW = $ContadorNaView")
        Text(text = "INCREMENTA CONTATDOR PELA VIEWMODEL = $ContadorProvenienteDaMinhaModelView")
    }
}



@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}
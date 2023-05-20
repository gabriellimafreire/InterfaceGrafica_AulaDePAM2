package com.example.interfacegrafica

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.interfacegrafica.ui.theme.InterfaceGraficaTheme
import kotlin.reflect.KProperty
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

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
/*@Composable
fun MainScreen(){
    InterfaceGraficaTheme {
        Column (modifier = Modifier.fillMaxSize().background(Color.Gray).border( border = BorderStroke( width = 2.dp, brush = Brush.horizontalGradient( colors = listOf(Color.Green, Color.Red) ) ), shape = MaterialTheme.shapes.medium )){
            Greeting(name = "Word")
            MinhaSaudacao("Gabriel",
                modificando = Modifier
               // .border( border = BorderStroke( width = 2.dp, brush = Brush.horizontalGradient( colors = listOf(Color.Green, Color.Red) ) ), shape = MaterialTheme.shapes.medium )
        )
        }
    }
}*/ //meuprojetobutton

@Composable
fun MainScreen(umaViewModel: MinhaViewModelBemSimples){
    var ContadorNaView by remember {
        mutableStateOf(0)
    }
    val ContadorProvenienteDaMinhaModelView by umaViewModel.contadprDaViewPublico.collectAsState()
    Column() {
.
        
  Row() {                                                 //CREMENTANDO
      Button(onClick = { ContadorNaView = ContadorNaView + 1 //coisa de estudante
          umaViewModel.incrementoContador() //coisa aqui e prof
      })
      {
          Text(text = "INCREMENTA CONTATDOR PELA VIEW = $ContadorNaView")
          Text(text = "INCREMENTA CONTATDOR PELA VIEWMODEL = $ContadorProvenienteDaMinhaModelView")
      }

  }
                                                                                                //INCREMENTANDO
        Button(onClick = { ContadorNaView = ContadorNaView - 1 //coisa de estudante
            umaViewModel.incrementoContador() //coisa aqui e prof
        })
        {
            Text(text = "INCREMENTA CONTATDOR PELA VIEW = $ContadorNaView")
            Text(text = "INCREMENTA CONTATDOR PELA VIEWMODEL = $ContadorProvenienteDaMinhaModelView")
        }

    }

}


@Composable
fun MinhaSaudacao(nome: String, modificando: Modifier){
    Text(text = "Eu $nome estou de manhã na ETEC \n",  color = Color.Green, modifier = modificando)
    Comoestou()
}

@Composable
fun Comoestou(){
    Text(text = "Estou gostando muito da aula de PAMII, estou aprenden" +
            "do bastante com o professor Wagner", color = Color.Green)

}

@Composable
fun Greeting(name: String, modificando: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modificando,
        color = Color.Green
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
   // MainScreen()

}
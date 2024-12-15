package com.nearby.offers.ui.components

// import android.widget.Button
import android.graphics.drawable.shapes.Shape
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.util.Function
import com.nearby.offers.R
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

val defaultAction: () -> Unit = { println("Ação padrão executada") }


@Composable
fun NearbyButton (
    modifierBtn: Modifier = Modifier,
    textBtn : String? = null,
    @DrawableRes iconRes: Int? = null,  // somente recebe elementos Drawable da pasta 'Res' do Android
    onClickBtn : (() -> Unit)?
) {
    // custom Composable button
    Button(
        onClick= onClickBtn ?: defaultAction,
        modifier = modifierBtn.heightIn( min= 56.dp, ) ,
        shape = RoundedCornerShape(  16.dp ),
        contentPadding = if( textBtn == null && iconRes!=null ) PaddingValues( horizontal = 40.dp) else ButtonDefaults.ContentPadding,
        colors = ButtonDefaults.buttonColors( containerColor = com.nearby.offers.ui.theme.GreenBase ) ,
        content = {
            Row (
                verticalAlignment = Alignment.CenterVertically ,
                horizontalArrangement = Arrangement.spacedBy( space = 10.dp),  // Arrangement.SpaceBetween,
                content ={  //type: () -> Unit

                    //  Text( text= textBtn ?: "Vazio")
                    iconRes?.let {
                        Icon(
                            painter = painterResource( id = iconRes),
                            contentDescription = "Ícone do botão"
                        )
                    }
                    textBtn?.let {
                        Text(
                            text = textBtn.uppercase(),
                            style = com.nearby.offers.ui.theme.Typography.labelLarge
                        )
                    }

                }
            )

        }
    )
}


@Preview // annotation responsavel por fazer o preview de uma funcao @composable
@Composable
private fun NearbyButtonPreview () {
    NearbyButton(
        modifierBtn = Modifier.fillMaxWidth(),
        iconRes = R.drawable.ic_scan ,
        textBtn = "Teste",
        onClickBtn = null
    )
}

@Preview // annotation responsavel por fazer o preview de uma funcao @composable
@Composable
private fun NearbyButtonOnlyText () {
    NearbyButton(
        modifierBtn = Modifier,
        textBtn = "Confirmar",
        onClickBtn = null
    )
}

@Preview
@Composable
private fun NearbyButtonOnlyIcon () {
    NearbyButton(
        modifierBtn = Modifier,
        iconRes = R.drawable.ic_arrow_left ,
        onClickBtn = null
    )
}


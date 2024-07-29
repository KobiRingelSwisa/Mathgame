package com.krs.mathgame

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * TextForQuestion displays the current question in the game.
 *
 * @param text The question text to be displayed.
 */
@Composable
fun TextForQuestion(text: String) {

    Text(
        text = text,
        fontSize = 24.sp,
        color = Color.White,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .background(color = colorResource(id = R.color.blue))
            .size(300.dp, 75.dp)
            .wrapContentHeight()
    )

}

/**
 * TextFieldForAnswer provides an input field for the user to enter their answer.
 *
 * @param text The MutableState holding the user's input.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldForAnswer(text: MutableState<String>) {

    TextField(
        value = text.value,
        onValueChange = { text.value = it },
        label = { Text(text = "Enter your answer...") },
        colors = TextFieldDefaults.textFieldColors(
            focusedLabelColor = Color.White,
            unfocusedLabelColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            containerColor = colorResource(id = R.color.blue),
            focusedTextColor = Color.White,
            cursorColor = Color.White
        ),
        modifier = Modifier.size(300.dp, 75.dp),
        textStyle = TextStyle(fontSize = 24.sp, textAlign = TextAlign.Center),
        shape = RoundedCornerShape(0),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

    )

}

/**
 * ButtonOkNext displays a button that can be used to submit an answer or navigate to the next question.
 *
 * @param buttonText The text to be displayed on the button.
 * @param myOnClicked The function to be executed when the button is clicked.
 * @param isEnabled A boolean indicating whether the button is enabled.
 */
@Composable
fun ButtonOkNext(buttonText : String, myOnClicked:() -> Unit, isEnabled : Boolean) {
    
    Button(
        onClick = myOnClicked,
        enabled = isEnabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(5.dp),
        border = BorderStroke(2.dp, color = colorResource(id = R.color.blue)),
        modifier = Modifier.width(150.dp)
    ) {
        
        Text(text = buttonText, fontSize = 24.sp, color = colorResource(id = R.color.blue))
    }
}
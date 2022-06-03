package com.project.myapplication.TextActivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.myapplication.ui.theme.MyApplicationTheme

class TextActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme() {

            }
        }
    }

}

@Preview(showBackground = true, widthDp = 500, heightDp = 500, backgroundColor = 0xFFF0EAE2)
@Composable
fun TextComposablePreview() {
    TextCompose()
}

@Composable
fun TextCompose() {
    val scrollState = rememberScrollState()
    Column(modifier = Modifier.verticalScroll(scrollState)) {
        CustomStyledTextPreview()
        Divider(color = Color.Black)
        ModifiedTextIntent()
        Divider(color = Color.Black)
        JustifyTextAlign()
        Divider(color = Color.Black)
        CenterTextAlign()
        Divider(color = Color.Black)
        TextWithBackground()
        Divider(color = Color.Black)
        TextWithShadow()
        Divider(color = Color.Black)
        TextWith1MaxLine()
        Divider(color = Color.Black)
        TextWithUnderline()
        Divider(color = Color.Black)
        TextWithStrikeThrough()
    }

}

@Composable
fun CustomStyledText(displayedText: String, style: TextStyle? = null, maxlines: Int? = null) {
    Text(text = displayedText,
        modifier = Modifier.padding(16.dp),
        style = style ?: TextStyle.Default,
        overflow = TextOverflow.Ellipsis,
        maxLines = maxlines ?: Int.MAX_VALUE
    )
    Divider(color = Color.Black)

}

@Composable
fun CustomStyledTextPreview() {
    CustomStyledText(
        "This is preview text which is showing for the compose",
        style = TextStyle(
            color = Color.Red,
            fontWeight = FontWeight.W900,
            fontStyle = FontStyle.Italic,
            fontFamily = FontFamily.Serif,
            fontSize = 20.sp,
            textAlign = TextAlign.Start
        ),
        maxlines = 2
    )
}
@Composable
private fun TextWithUnderline() {
    CustomStyledText(
        "This text has an underline",
        style = TextStyle(
            textDecoration = TextDecoration.Underline
        )
    )
}

@Composable
private fun TextWithStrikeThrough() {
    CustomStyledText(
        "This text has a strikethrough line",
        style = TextStyle(
            textDecoration = TextDecoration.LineThrough
        )
    )
}
@Composable
private fun TextWith1MaxLine() {
    CustomStyledText(
        "This text will add an ellipsis to the end " +
                "of the text if the text is longer that 1 line long.",
        maxlines = 1
    )
}

@Composable
private fun ModifiedTextIntent() {
    CustomStyledText(
        "This text will demonstrate how to add " +
                "indentation to your text. In this example, indentation was only " +
                "added to the first line. You also have the option to add " +
                "indentation to the rest of the lines if you'd like",
        style = TextStyle(
            textAlign = TextAlign.Justify,
            textIndent = TextIndent(firstLine = 30.sp)
        )
    )
}

@Composable
private fun TextWithBackground() {
    Surface(color = Color.Transparent) {
        Text(
            text = "This text has a background color",
            modifier = Modifier.padding(16.dp),
            style = TextStyle(
                color = Color.Blue,
                fontSize = 20.sp,
                fontFamily = FontFamily.SansSerif,
                fontStyle = FontStyle.Normal,
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.ExtraLight
            )
        )
    }

}
@Composable
private fun TextWithShadow() {
    CustomStyledText(
        "This text has a shadow",
        style = TextStyle(
            shadow = Shadow(
                color = Color.Black, blurRadius = 10f,
                offset = Offset(2f, 2f)
            )
        )
    )
}


@Composable
private fun JustifyTextAlign() {
    CustomStyledText(
        "This text will demonstrate how to justify " +
                "your paragraph to ensure that the text that ends with a soft " +
                "line break spreads and takes the entire width of the container",
        style = TextStyle(
            textAlign = TextAlign.Justify
        )
    )
}

@Composable
private fun CenterTextAlign() {
    Row(modifier = Modifier.fillMaxWidth()) {
        // Text is a predefined composable that does exactly what you'd expect it to -
        // display text on the screen. It allows you to customize its appearance using
        // the style property.
        Text(
            text = "This text is center aligned",
            style = TextStyle(
                textAlign = TextAlign.Center
            ),
            modifier = Modifier.padding(16.dp)
        )
    }
}
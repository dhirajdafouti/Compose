package com.project.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Spa
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.codelab.basiclayouts.ui.theme.MySootheTheme
import java.util.*


class LayoutBasic : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MySootheTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                }
            }
        }
    }
}

// Step: Search bar - Modifiers
@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
) {
    TextField(value = "", onValueChange = {
    },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.surface
        ),
        leadingIcon = {
            Icon(Icons.Default.Search, contentDescription = null)
        }, placeholder = {
            Text(stringResource(id = R.string.placeholder_search))
        }, modifier = modifier
            .heightIn(26.dp)
            .fillMaxWidth())

}

// Step: Align your body - Alignment
@Composable
fun AlignYourBodyElement(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = Modifier.padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(painter = painterResource(id = drawable),
            contentDescription = null,
            Modifier
                .size(88.dp)
                .clip(
                    CircleShape), contentScale = ContentScale.Crop)

        Text(text = stringResource(id = text), style = MaterialTheme.typography.h2,
            modifier = Modifier
                .paddingFromBaseline(24.dp, 8.dp))
    }
}

// Step: Favorite collection card - Material Surface
@Composable
fun FavoriteCollectionCard(
    modifier: Modifier = Modifier,
    @DrawableRes drawable: Int,
    @StringRes text: Int,
) {
    Surface(modifier, shape = MaterialTheme.shapes.small) {
        Row(Modifier.width(192.dp), verticalAlignment = Alignment.CenterVertically) {
            Image(painterResource(id = drawable),
                contentDescription = null, modifier = Modifier.size(56.dp),
                contentScale = ContentScale.Crop)
            Text(text = stringResource(id = text),
                Modifier.padding(horizontal = 16.dp),
                style = MaterialTheme.typography.h3)
        }
    }
}

// Step: Align your body row - Arrangements
@Composable
fun AlignYourBodyRow(
    modifier: Modifier = Modifier,
) {
    LazyRow(modifier, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(alignYourBodyData) { item ->
            AlignYourBodyElement(drawable = item.drawable, text = item.text)
        }
    }
}

// Step: Favorite collections grid - LazyGrid
@ExperimentalFoundationApi
@Composable
fun FavoriteCollectionsGrid(
    modifier: Modifier = Modifier,

    ) {
    LazyHorizontalGrid(rows = androidx.compose.foundation.lazy.grid.GridCells.Fixed(2),
        modifier = Modifier.height(120.dp), verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp), contentPadding = PaddingValues(16.dp)) {
        items(favoriteCollectionsData) { item ->
            FavoriteCollectionCard(modifier, item.drawable, item.text)
        }
    }
}

// Step: Home section - Slot APIs
@Composable
fun HomeSection(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Column(modifier) {
        Text(text = stringResource(id = title).uppercase(Locale.getDefault()),
            style = MaterialTheme.typography.h5,
            modifier = modifier
                .paddingFromBaseline(top = 40.dp, bottom = 8.dp)
                .padding(horizontal = 16.dp))
        content()
    }
}

// Step: Home screen - Scrolling
@ExperimentalFoundationApi
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(modifier.padding(vertical = 16.dp)) {
        Spacer(modifier = Modifier.height(6.dp))
        SearchBar(Modifier.padding(horizontal = 16.dp))
        HomeSection(title = R.string.align_your_body) {
            AlignYourBodyRow()
        }
        HomeSection(title = R.string.favorite_collections) {
            FavoriteCollectionsGrid(modifier)
        }
        Spacer(modifier = Modifier.height(6.dp))

    }
}

// Step: Bottom navigation - Material
@Composable
private fun SootheBottomNavigation(modifier: Modifier = Modifier) {
    BottomNavigation(backgroundColor = MaterialTheme.colors.background, modifier = modifier) {

        BottomNavigationItem(selected = true,
            onClick = { /*TODO*/ },
            icon = {
                Icon(Icons.Default.Spa, contentDescription = null)
            },
            label = {
                Text(stringResource(id = R.string.bottom_navigation_home))
            })

        BottomNavigationItem(selected = false,
            onClick = { /*TODO*/ },
            icon = {
                Icon(Icons.Default.AccountCircle, contentDescription = null)
            },
            label = {
                Text(stringResource(id = R.string.bottom_navigation_profile))
            })


    }


}
@Composable
fun VisitingCardName(){

}

@Composable
fun VisitingCardDetails(){

}


@Composable
fun VisitingCard(modifier: Modifier = Modifier) {

}

// Step: MySoothe App - Scaffold
@ExperimentalFoundationApi
@Composable
fun MySootheApp() {
    MySootheTheme() {
        Scaffold(
            bottomBar = {
                SootheBottomNavigation()
            }
        ) {
            HomeScreen()
        }
    }

}

private val alignYourBodyData = listOf(
    R.drawable.ab1_inversions to R.string.ab1_inversions,
    R.drawable.ab2_quick_yoga to R.string.ab2_quick_yoga,
    R.drawable.ab3_stretching to R.string.ab3_stretching,
    R.drawable.ab4_tabata to R.string.ab4_tabata,
    R.drawable.ab5_hiit to R.string.ab5_hiit,
    R.drawable.ab6_pre_natal_yoga to R.string.ab6_pre_natal_yoga
).map { DrawableStringPair(it.first, it.second) }

private val favoriteCollectionsData = listOf(
    R.drawable.fc1_short_mantras to R.string.fc1_short_mantras,
    R.drawable.fc2_nature_meditations to R.string.fc2_nature_meditations,
    R.drawable.fc3_stress_and_anxiety to R.string.fc3_stress_and_anxiety,
    R.drawable.fc4_self_massage to R.string.fc4_self_massage,
    R.drawable.fc5_overwhelmed to R.string.fc5_overwhelmed,
    R.drawable.fc6_nightly_wind_down to R.string.fc6_nightly_wind_down
).map { DrawableStringPair(it.first, it.second) }

private data class DrawableStringPair(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int,
)

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun VisitingCardPreview() {
    MySootheTheme {
        VisitingCard(Modifier.padding(8.dp))
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun VisitingCardNamePreview(){

}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun VisitingCardDetailsPreview(){

}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun SearchBarPreview() {
    MySootheTheme { SearchBar(Modifier.padding(8.dp)) }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun AlignYourBodyElementPreview() {
    MySootheTheme {
        AlignYourBodyElement(
            R.drawable.ab1_inversions,
            R.string.ab1_inversions,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun FavoriteCollectionCardPreview() {
    MySootheTheme {
        FavoriteCollectionCard(
            modifier = Modifier.padding(8.dp),
            R.drawable.fc2_nature_meditations,
            R.string.fc2_nature_meditations
        )
    }
}

@ExperimentalFoundationApi
@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun FavoriteCollectionsGridPreview() {
    MySootheTheme { FavoriteCollectionsGrid() }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun AlignYourBodyRowPreview() {
    MySootheTheme { AlignYourBodyRow() }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun HomeSectionPreview() {
    MySootheTheme {
        HomeSection(R.string.align_your_body, modifier = Modifier) {
            AlignYourBodyRow()
        }
    }
}

@ExperimentalFoundationApi
@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun ScreenContentPreview() {
    MySootheTheme { HomeScreen() }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun BottomNavigationPreview() {
    MySootheTheme { SootheBottomNavigation(Modifier.padding(top = 24.dp)) }
}

@ExperimentalFoundationApi
@Preview(showBackground = true, widthDp = 500, heightDp = 500, backgroundColor = 0xFFF0EAE2)
@Composable
fun MySoothePreview() {
    MySootheApp()
}
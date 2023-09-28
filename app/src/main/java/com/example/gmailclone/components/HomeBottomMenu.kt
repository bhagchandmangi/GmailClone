package com.example.gmailclone.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.gmailclone.model.BottomMenuData

@Composable
fun HomeBottomMenu() {
    val items = listOf(
        BottomMenuData.Mail,
        BottomMenuData.Meet
    )
    BottomNavigation(
        contentColor = Color.Black,
        backgroundColor = Color.White
    ) {
        items.forEach{
            BottomNavigationItem(
                label = { Text(text = it.title) },
                selected = false,
                alwaysShowLabel = true,
                onClick = { /*TODO*/ },
                icon = { Icon(imageVector = it.icon, contentDescription = it.title) })
        }
    }
}
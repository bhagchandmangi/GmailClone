package com.example.gmailclone.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gmailclone.DrawerMenuData

@Composable
fun GmailDrawerMenu() {
    val menuList = listOf(
//        DrawerMenuData.Divider,
        DrawerMenuData.AllInbox,
//        DrawerMenuData.Divider,
        DrawerMenuData.Primary,
        DrawerMenuData.Social,
        DrawerMenuData.Promotions,
        DrawerMenuData.Starred,
        DrawerMenuData.Snoozed,
        DrawerMenuData.Important,
        DrawerMenuData.Sent,
        DrawerMenuData.Schedule,
        DrawerMenuData.Outbox,
        DrawerMenuData.Drafts,
        DrawerMenuData.AllMail,
        DrawerMenuData.Calendar,
        DrawerMenuData.Contacts,
//        DrawerMenuData.Divider,
        DrawerMenuData.Setting,
        DrawerMenuData.Help,

        )
    Column {
        Text(
            text = "Gmail",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 10.dp, top = 10.dp, bottom = 10.dp),
            color = Color.Red
        )
        menuList.forEach{
            item->
            MailDrawerItem(item = item)
        }
    }
}

@Composable
fun MailDrawerItem(item: DrawerMenuData) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(top = 16.dp),
    ) {
        Image(
            imageVector = item.icon!!, contentDescription = item.title!!,
            modifier = Modifier.weight(0.5f)
        )
        Text(
            text = item.title!!,
            modifier = Modifier.weight(2.0f)
        )
    }
}
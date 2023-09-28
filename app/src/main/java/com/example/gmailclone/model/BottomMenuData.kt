package com.example.gmailclone.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.VideoCall
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomMenuData(
    val title: String,
    val icon: ImageVector,
){
    object Mail: BottomMenuData(icon = Icons.Default.Mail, title = "Mail")
    object Meet: BottomMenuData(icon = Icons.Default.VideoCall, title = "Meet")
}

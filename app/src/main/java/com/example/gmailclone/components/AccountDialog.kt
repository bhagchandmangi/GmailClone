package com.example.gmailclone.components

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.PersonAddAlt
import androidx.compose.material.icons.outlined.ManageAccounts
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.gmailclone.R
import com.example.gmailclone.accountList
import com.example.gmailclone.model.Account

@Composable
fun AccountDialog(OpenDialog: MutableState<Boolean>) {
    Dialog(
        onDismissRequest = { OpenDialog.value = false },
        properties = DialogProperties(dismissOnClickOutside = false)
    ) {
        AccountDialogUI(openDialog = OpenDialog)
    }
}

@Composable
fun AccountDialogUI(modifier: Modifier = Modifier, openDialog: MutableState<Boolean>) {
    Card {
        Column(
            modifier = modifier
                .background(Color.White)
                .padding(bottom = 16.dp)
        ) {
            Row(
                modifier = modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { openDialog.value = false }) {
                    Icon(imageVector = Icons.Default.Close, contentDescription = "close")
                }
                Image(
                    painter = painterResource(id = R.drawable.google),
                    contentDescription = "person",
                    modifier = modifier
                        .size(30.dp)
                        .weight(2.0f)
                )
            }
            AccountItem(account = accountList[0])
            Row(
                modifier = modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Card(
                    modifier.requiredWidth(150.dp),
                    shape = RoundedCornerShape(50.dp),
                    border = BorderStroke(1.dp, color = Color.Gray)
                ) {
                    Text(
                        text = "Google Account",
                        modifier.padding(8.dp),
                        textAlign = TextAlign.Center
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
            }
            Divider(modifier.padding(top = 16.dp))
            Column {
                AccountItem(account = accountList[0])
                AccountItem(account = accountList[1])
            }
            AddAccount(icon = Icons.Outlined.ManageAccounts, title = "Add Another Account")
            AddAccount(icon = Icons.Default.PersonAddAlt, title = "Manage Account on this device")
            Divider(modifier = Modifier.padding(top = 16.dp, bottom = 16.dp))
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Privacy Policy")
                Card(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .size(5.dp),
                    shape = CircleShape,
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Black
                    )
                ) {

                }
                Text(text = "Terms of Services")
            }
        }
    }
}
@Composable
fun AccountItem(account: Account) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if(account != null) {
            account.icon?.let { painterResource(id = it) }?.let {
                Image(
                    painter = it,
                    contentDescription = "profile image",
                    alignment = Alignment.Center,
                    modifier = Modifier
                        .size(30.dp)
                        .clip(CircleShape)
                        .background(color = Color.Gray)
                )
            }
        }else {
            Card(
                modifier = Modifier
                    .padding(end = 8.dp)
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(Color.Gray)
            ) {
                Text(
                    text = account.userName[0].toString(),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }

        Column(
            modifier = Modifier
                .weight(2.0f)
                .padding(start = 16.dp, bottom = 16.dp)
        ) {
            Text(text = account.userName, fontWeight = FontWeight.SemiBold)
            Text(text = account.email)
        }
        Text(text = "${account.unReadMails}+", modifier = Modifier.padding(end = 16.dp))
    }
}
@Composable
fun AddAccount(icon: ImageVector, title: String){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = icon, contentDescription = "",
                modifier = Modifier.padding(bottom = 8.dp))
        }
        Text(text = title, fontWeight = FontWeight.SemiBold, modifier = Modifier.padding(end = 16.dp))
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview(showBackground = true)
@Composable
fun PreviewAccountDialogUI() {
    AccountDialogUI(openDialog = mutableStateOf(false))
}
package com.example.gmailclone.components

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
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.gmailclone.R

@Composable
fun AccountDialog(OpenDialog: MutableState<Boolean>) {
    Dialog(onDismissRequest = { OpenDialog.value = false }) {
        AccountDialogUI()
    }
}

@Composable
fun AccountDialogUI(modifier: Modifier = Modifier) {
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
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Close, contentDescription = "close")
                }
                Image(
                    painter = painterResource(id = R.drawable.person_4),
                    contentDescription = "person",
                    modifier = modifier
                        .size(30.dp)
                        .weight(2.0f)
                )
            }
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.person_4),
                    contentDescription = "profile image",
                    modifier = Modifier
                        .size(30.dp)
                        .clip(CircleShape)
                        .background(color = Color.Gray)
                )
                Column(
                    modifier
                        .weight(2.0f)
                        .padding(start = 16.dp, bottom = 16.dp)
                ) {
                    Text(text = "Tutorials", fontWeight = FontWeight.SemiBold)
                    Text(text = "Tutorail@gmail.com")
                }
                Text(text = "99+", modifier = Modifier.padding(end = 16.dp))
            }
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
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAccountDialogUI() {
    AccountDialogUI()
}
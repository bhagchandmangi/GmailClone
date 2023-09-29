package com.example.gmailclone.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.window.Dialog

@Composable
fun AccountDialog(OpenDialog: MutableState<Boolean>) {
    Dialog(onDismissRequest = { OpenDialog.value = false }) {

    }
}
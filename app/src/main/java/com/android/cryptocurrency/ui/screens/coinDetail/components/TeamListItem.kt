package com.android.cryptocurrency.ui.screens.coinDetail.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.android.cryptocurrency.domain.model.TeamMember

@Composable
fun TeamListItem(
    teamMember: TeamMember,
) {
    Column (
        modifier = Modifier.fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalArrangement = Arrangement.Center,
    ){
        Text(
            text = teamMember.name,
            style = MaterialTheme.typography.h6,
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = teamMember.position,
            style = MaterialTheme.typography.body2,
            fontStyle = FontStyle.Italic,
        )
    }
}
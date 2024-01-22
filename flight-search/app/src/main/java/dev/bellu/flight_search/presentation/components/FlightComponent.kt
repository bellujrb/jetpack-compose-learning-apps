package dev.bellu.flight_search.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import dev.bellu.flight_search.presentation.entity.FlightEntity
import dev.bellu.flight_search.R
import dev.bellu.flight_search.presentation.utils.Colors
import dev.bellu.flight_search.presentation.utils.TextManager

@Composable
fun FlightComponent(
    flights: FlightEntity
) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(0.9f)
            .height(190.dp)
            .background(color = Colors.onPrimary, shape = RoundedCornerShape(16.dp))
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(modifier = Modifier.padding(16.dp) .fillMaxWidth(0.7f)) {
                Text(stringResource(id = R.string.depart), style = TextManager.smallWhite)
                Text(flights.departCode, style = TextManager.smallWhite)
                Text(flights.departName, style = TextManager.smallWhite)

                Spacer(modifier = Modifier.height(12.5.dp))

                Text(stringResource(id = R.string.arrive), style = TextManager.smallWhite)
                Text(flights.arriveCode, style = TextManager.smallWhite)
                Text(flights.arriveName, style = TextManager.smallWhite)
            }
            Box(
                modifier = Modifier
                    .background(color = Colors.onSecondary)
                    .width(40.dp)
                    .height(40.dp),
            )
        }
    }
}
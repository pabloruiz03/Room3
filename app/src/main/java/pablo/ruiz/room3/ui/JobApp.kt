package pablo.ruiz.room3.ui
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import pablo.ruiz.room3.data.models.Job

import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import pablo.ruiz.room3.viewmodels.JobViewModel

@Composable
fun JobApp(jobViewModel: JobViewModel) {
    var customerName by remember { mutableStateOf("") }
    var dateFrom by remember { mutableStateOf("") }
    var dateTo by remember { mutableStateOf("") }
    var painting by remember { mutableStateOf(false) }
    var wallpapering by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Job Details")

        BasicTextField(
            value = customerName,
            onValueChange = { customerName = it },
            modifier = Modifier.padding(8.dp)
        )
        Text("Customer Name")

        BasicTextField(
            value = dateFrom,
            onValueChange = { dateFrom = it },
            modifier = Modifier.padding(8.dp)
        )
        Text("Date From")

        BasicTextField(
            value = dateTo,
            onValueChange = { dateTo = it },
            modifier = Modifier.padding(8.dp)
        )
        Text("Date To")

        Row(modifier = Modifier.padding(8.dp)) {
            Text("Painting")
            Checkbox(checked = painting, onCheckedChange = { painting = it })
        }

        Row(modifier = Modifier.padding(8.dp)) {
            Text("Wallpapering")
            Checkbox(checked = wallpapering, onCheckedChange = { wallpapering = it })
        }

        Button(
            onClick = {
                val job = Job(
                    customerName = customerName,
                    dateFrom = dateFrom,
                    dateTo = dateTo,
                    painting = painting,
                    wallpapering = wallpapering
                )
                jobViewModel.insert(job)
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Save Job")
        }
    }
}


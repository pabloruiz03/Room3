package pablo.ruiz.room3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import pablo.ruiz.room3.data.database.AppDatabase
import pablo.ruiz.room3.viewmodels.JobViewModel
import pablo.ruiz.room3.ui.ViewModel.JobViewModelFactory
import pablo.ruiz.room3.ui.JobApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val database = AppDatabase.getDatabase(this)
            val jobViewModel: JobViewModel = viewModel(factory = JobViewModelFactory(database))
            JobApp(jobViewModel = jobViewModel)
        }
    }
}

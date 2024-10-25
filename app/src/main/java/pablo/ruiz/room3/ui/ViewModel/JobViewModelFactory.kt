package pablo.ruiz.room3.ui.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import pablo.ruiz.room3.data.database.AppDatabase
import pablo.ruiz.room3.viewmodels.JobViewModel

class JobViewModelFactory(private val database: AppDatabase) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(JobViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return JobViewModel(database) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

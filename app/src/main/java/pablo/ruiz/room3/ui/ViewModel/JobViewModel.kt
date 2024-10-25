package pablo.ruiz.room3.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pablo.ruiz.room3.data.database.AppDatabase
import pablo.ruiz.room3.data.models.Job

class JobViewModel(private val database: AppDatabase) : ViewModel() {
    fun insert(job: Job) {
        viewModelScope.launch {
            database.jobDao().insert(job)
        }
    }
}

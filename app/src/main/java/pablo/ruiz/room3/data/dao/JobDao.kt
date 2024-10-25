package pablo.ruiz.room3.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import pablo.ruiz.room3.data.models.Job

@Dao
interface JobDao {
    @Insert
    suspend fun insert(job: Job): Long

    @Query("SELECT * FROM jobs")
    suspend fun getAllJobs(): List<Job>
}

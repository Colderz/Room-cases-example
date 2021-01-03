package pakiet.arkadiuszzimny.roomexample.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Student(
    @PrimaryKey(autoGenerate = true)
    val studentName: String,
    val semester: Int,
    val schoolName: String
)
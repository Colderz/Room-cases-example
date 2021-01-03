package pakiet.arkadiuszzimny.roomexample.entities

import androidx.room.PrimaryKey

data class Student(
    @PrimaryKey(autoGenerate = true)
    val studentName: String,
    val semester: Int,
    val schoolName: String
)
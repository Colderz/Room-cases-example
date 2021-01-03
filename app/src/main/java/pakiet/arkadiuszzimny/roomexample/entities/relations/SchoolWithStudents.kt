package pakiet.arkadiuszzimny.roomexample.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import pakiet.arkadiuszzimny.roomexample.entities.School
import pakiet.arkadiuszzimny.roomexample.entities.Student

data class SchoolWithStudents(
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val students: List<Student>
)
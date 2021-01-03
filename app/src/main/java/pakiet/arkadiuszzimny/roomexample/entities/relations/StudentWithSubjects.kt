package pakiet.arkadiuszzimny.roomexample.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import pakiet.arkadiuszzimny.roomexample.entities.Student
import pakiet.arkadiuszzimny.roomexample.entities.Subject

data class StudentWithSubjects(
    @Embedded val student: Student,
    @Relation(
        parentColumn = "studentName",
        entityColumn = "subjectName",
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val subject: List<Subject>
)
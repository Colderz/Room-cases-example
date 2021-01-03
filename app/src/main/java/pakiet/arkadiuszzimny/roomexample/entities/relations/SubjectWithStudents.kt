package pakiet.arkadiuszzimny.roomexample.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import pakiet.arkadiuszzimny.roomexample.entities.Student
import pakiet.arkadiuszzimny.roomexample.entities.Subject

data class SubjectWithStudents(
    @Embedded val subject: Subject,
    @Relation(
        parentColumn = "subjectName",
        entityColumn = "studentName",
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val student: List<Student>
)
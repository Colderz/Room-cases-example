package pakiet.arkadiuszzimny.roomexample.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import pakiet.arkadiuszzimny.roomexample.entities.Director
import pakiet.arkadiuszzimny.roomexample.entities.School

data class SchoolAndDirector(
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val director: Director
)
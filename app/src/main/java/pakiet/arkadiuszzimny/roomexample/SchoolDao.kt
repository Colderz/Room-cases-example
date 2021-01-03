package pakiet.arkadiuszzimny.roomexample

import androidx.room.*
import pakiet.arkadiuszzimny.roomexample.entities.Director
import pakiet.arkadiuszzimny.roomexample.entities.School
import pakiet.arkadiuszzimny.roomexample.entities.Student
import pakiet.arkadiuszzimny.roomexample.entities.relations.SchoolAndDirector
import pakiet.arkadiuszzimny.roomexample.entities.relations.SchoolWithStudents

@Dao
interface SchoolDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(school: School)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(director: Director)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: Student)

    @Transaction
    @Query("SELECT * FROM school WHERE schoolName = :schoolName")
    suspend fun getSchoolAndDriectorWithSchoolName(schoolName: String) : List<SchoolAndDirector>

    @Transaction
    @Query("SELECT * FROM school WHERE schoolName = :schoolName")
    suspend fun getSchoolWithStudents(schoolName: String) : List<SchoolWithStudents>

}
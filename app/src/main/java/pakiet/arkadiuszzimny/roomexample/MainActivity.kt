package pakiet.arkadiuszzimny.roomexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import pakiet.arkadiuszzimny.roomexample.entities.Director
import pakiet.arkadiuszzimny.roomexample.entities.School
import pakiet.arkadiuszzimny.roomexample.entities.Student
import pakiet.arkadiuszzimny.roomexample.entities.Subject
import pakiet.arkadiuszzimny.roomexample.entities.relations.StudentSubjectCrossRef

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dao = SchoolDatabase.getInstance(this).schoolDao

        val directors = listOf(
                Director("Marek Nowak", "Szkoła podstawowa nr 2"),
                Director("Juliusz Pasek", "Szkoła podstawowa nr 13"),
                Director("Oskar Długi", "Technikum nr 23")
        )

        val schools = listOf(
                School("Szkoła podstawowa nr 2"),
                School("Szkoła podstawowa nr 13"),
                School("Technikum nr 23")
        )

        val subjects = listOf(
                Subject("Chemia"),
                Subject("Fizyka"),
                Subject("Matematyka"),
                Subject("Geografia")
        )

        val students = listOf(
                Student("Bapoleon Nonaparte", 4, "Technikum nr 23"),
                Student("Dandrzej Nuda", 1, "Szkoła podstawowa nr 2"),
                Student("Lobert Rewandowski", 5, "Szkoła podstawowa nr 13"),
                Student("Kobert Rubica", 2, "Szkoła podstawowa nr 13")
        )

        val studentSubjectRelations = listOf(
                StudentSubjectCrossRef("Bapoleon Nonaprate", "Chemia"),
                StudentSubjectCrossRef("Bapoleon Nonaprate", "Geografia"),
                StudentSubjectCrossRef("Bapoleon Nonaprate", "Matematyka"),
                StudentSubjectCrossRef("Lobert Rewandowski", "Matematyka"),
                StudentSubjectCrossRef("Kobert Rubica", "Fizyka"),
                StudentSubjectCrossRef("Kobert Rubica", "Chemia"),
                StudentSubjectCrossRef("Dandrzej Nuda", "Matematyka")
        )

        lifecycleScope.launch{
            directors.forEach {dao.insertDirector(it)}
            schools.forEach {dao.insertSchool(it)}
            subjects.forEach {dao.insertSubject(it)}
            students.forEach {dao.insertStudent(it)}
            studentSubjectRelations.forEach {dao.insertStudentSubjectCrossRef(it)}
        }
    }
}
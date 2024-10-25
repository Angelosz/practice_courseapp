package com.example.practice_courseapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.practice_courseapp.data.Datasource
import com.example.practice_courseapp.model.Course
import com.example.practice_courseapp.ui.theme.Practice_courseappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Practice_courseappTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    
                }
            }
        }
    }
}


@Composable
fun CourseCard(course: Course, modifier: Modifier = Modifier){
    Card(modifier = modifier){
        Row {
            Image(
                painter = painterResource(course.image),
                contentDescription = stringResource(course.name)
            )
            Column(){
                Text(
                    text = stringResource(course.name)
                )
                Row(){
                    Icon(
                        painter = painterResource(R.drawable.ic_grain),
                        contentDescription = null
                    )
                    Text(
                        text = course.numberOfAssociatedCourses.toString()
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun CourseCardPreview(){
    Practice_courseappTheme {
        Surface{
            CourseCard(Datasource().loadCourses()[0])
        }
    }
}


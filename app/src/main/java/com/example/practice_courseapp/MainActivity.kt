package com.example.practice_courseapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                    CourseGrid(Datasource().loadCourses())
                }
            }
        }
    }
}


@Composable
fun CourseCard(course: Course, modifier: Modifier = Modifier){
    Card(modifier = modifier){
        Row(
            verticalAlignment = Alignment.Bottom
        ) {
            Image(
                painter = painterResource(course.image),
                contentDescription = stringResource(course.name),
                modifier = Modifier.size(68.dp)
            )
            Column{
                Text(
                    text = stringResource(course.name),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 8.dp)
                )
                Row(
                    modifier = Modifier.padding(start = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(
                        painter = painterResource(R.drawable.ic_grain),
                        contentDescription = null
                    )
                    Text(
                        text = course.numberOfAssociatedCourses.toString(),
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            }
        }
    }
}

@Composable
fun CourseGrid(courses: List<Course>, modifier: Modifier = Modifier){
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier.fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(courses) { CourseCard(it) }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CourseCardPreview(){
    Practice_courseappTheme {
        Surface{
            CourseCard(Datasource().loadCourses()[0])
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CourseGridPreview(){
    Practice_courseappTheme {
        Surface{
            CourseGrid(Datasource().loadCourses())
        }
    }
}
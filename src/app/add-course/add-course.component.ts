import { Component, OnInit } from '@angular/core';
import {MatIconModule} from '@angular/material/icon';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatSelectModule} from '@angular/material/select';
import { NgForm } from '@angular/forms';
import { FormsModule }   from '@angular/forms'
import { CourseService } from '../_services/course.service';
import { HttpErrorResponse } from '@angular/common/http';
import { Course } from '../_model/course.model';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
 
  selector: 'app-add-course',
  standalone: true,
  imports: [MatFormFieldModule, MatInputModule, MatIconModule,FormsModule,MatSelectModule],
  templateUrl: './add-course.component.html',
  styleUrl: './add-course.component.css'
  
})

export class AddCourseComponent implements OnInit{
  course: Course={
    coursename:"",
    courseprice:0,
   

  }
  constructor(private courseService:CourseService,
    private sanitizer:DomSanitizer){}
  ngOnInit(): void {
    
  }
addCourse(courseForm:NgForm){

  const courseFormData=this.prepareFormData(this.course)
  this.courseService.addCourse(courseFormData).subscribe(
    (response:Course )=>{
      courseForm.reset();
    },
    (error:HttpErrorResponse)=>{
      console.log(error);
    }
  );
}
prepareFormData(course:Course):FormData{
  const formData=new FormData();
  formData.append(
    'course',
    new Blob([JSON.stringify(course)],{type:'application/json'})
  );
 
  return formData;
}
  onFileSelected(event) {
    if (event.target.files) {
      const file = event.target.files[0];
      

    }
  }
}

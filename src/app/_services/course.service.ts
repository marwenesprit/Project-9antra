import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Course } from '../_model/course.model';

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  constructor(private httpClient:HttpClient) { 
   }
  public addCourse(course:FormData){
    return this.httpClient.post<Course>("http://localhost:9090/addnewcourse",course);   
   }
}
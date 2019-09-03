import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { HttpClient } from '@angular/common/http';
import { FeedbackDTO } from 'src/dto/feedbackdto';
import { Observable } from 'rxjs';
import { UserDTO } from 'src/dto/userdto';

@Injectable({
  providedIn: 'root'
})
export class FeedbackService extends AbstractService<FeedbackDTO> {

  constructor(http: HttpClient) { 
    super(http);
    this.type = 'feedback';
  }

  getMine(user: UserDTO): Observable<FeedbackDTO[]>{
    console.log("tipo: "+this.type);
        return this.http.post<FeedbackDTO[]>('http://localhost:' + this.port + '/' + this.type + '/getmine', user);
  }
}

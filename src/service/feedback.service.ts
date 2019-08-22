import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { HttpClient } from '@angular/common/http';
import { FeedbackDTO } from 'src/dto/feedbackdto';

@Injectable({
  providedIn: 'root'
})
export class FeedbackService extends AbstractService<FeedbackDTO> {

  constructor(http: HttpClient) { 
    super(http);
    this.type = 'feedback';
  }
}

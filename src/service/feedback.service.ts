import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { FeedbackDTO } from 'src/dto/feedbackdto';
import { HttpClient } from '@angular/common/http';
import { TouchSequence } from 'selenium-webdriver';

@Injectable({
  providedIn: 'root'
})
export class FeedbackService extends AbstractService<FeedbackDTO>{

  constructor(http: HttpClient) { 
    super(http);
    this.type = 'feedback';
  }

}

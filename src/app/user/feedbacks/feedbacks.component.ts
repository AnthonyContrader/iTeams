import { Component, OnInit } from '@angular/core';
import { FeedbackService } from 'src/service/feedback.service';
import { FeedbackDTO } from 'src/dto/feedbackdto';
import { UserDTO } from 'src/dto/userdto';
import { CompileStylesheetMetadata } from '@angular/compiler';
import { stringify } from 'querystring';

@Component({
  selector: 'app-feedbacks',
  templateUrl: './feedbacks.component.html',
  styleUrls: ['./feedbacks.component.css']
})
export class FeedbacksComponent implements OnInit {

  user: UserDTO;
  feedbacks: FeedbackDTO[];
  feedbacktoinsert: FeedbackDTO = new FeedbackDTO();
  nome : string;

  constructor(private service: FeedbackService) { }

  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem('currentUser'));
    this.nome=this.user.username;
    this.getFeedbacks();
  }

  getFeedbacks() {
    this.service.getAll().subscribe(feedbacks => this.feedbacks = feedbacks);
  }

  delete(feedback: FeedbackDTO) {
    this.service.delete(feedback.id).subscribe(() => this.getFeedbacks());
  }

  update(feedback: FeedbackDTO) {
    this.service.update(feedback).subscribe(() => this.getFeedbacks());
  }

  insert(feedback: FeedbackDTO) {
    feedback.creatorName=this.nome;
    this.service.insert(feedback).subscribe(() => this.getFeedbacks());
  }

  clear(){
    this.feedbacktoinsert = new FeedbackDTO();
  }
}

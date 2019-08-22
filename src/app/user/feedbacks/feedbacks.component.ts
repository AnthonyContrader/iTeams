import { Component, OnInit } from '@angular/core';
import { FeedbackService } from 'src/service/feedback.service';
import { FeedbackDTO } from 'src/dto/feedbackdto';

@Component({
  selector: 'app-feedbacks',
  templateUrl: './feedbacks.component.html',
  styleUrls: ['./feedbacks.component.css']
})
export class FeedbacksComponent implements OnInit {

  feedbacks: FeedbackDTO[];
  feedbacktoinsert: FeedbackDTO = new FeedbackDTO();

  constructor(private service: FeedbackService) { }

  ngOnInit() {
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
    this.service.insert(feedback).subscribe(() => this.getFeedbacks());
  }

  clear(){
    this.feedbacktoinsert = new FeedbackDTO();
  }
}

import { Component, OnInit } from '@angular/core';
import { FeedbackService } from 'src/service/feedback.service';
import { FeedbackDTO } from 'src/dto/feedbackdto';
import { UserService } from 'src/service/user.service';
import { UserDTO } from 'src/dto/userdto';
import { CompileStylesheetMetadata } from '@angular/compiler';
import { stringify } from 'querystring';

@Component({
  selector: 'app-feedbacks',
  templateUrl: './feedbacks.component.html',
  styleUrls: ['./feedbacks.component.css']
})
export class FeedbacksReceivedComponent implements OnInit {

  user: UserDTO;
  users: UserDTO[];
  feedbacks: FeedbackDTO[];
  feedbacktoinsert: FeedbackDTO = new FeedbackDTO();
  nome : string;

  constructor(private service: FeedbackService, private uService: UserService) { }

  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem('currentUser'));
    this.nome=this.user.username;
    this.getUsers();
    this.getMine();
    console.log("in init");
  }

  getMine() {
    console.log("in get mine");
    //this.service.getMine(use).subscribe(feedbacks => this.feedbacks = feedbacks);
    this.feedbacks=this.user.received;
    /*for(let feed of this.feedbacks) {
      console.log("feed: "+feed.user.username);
    }*/
  }

  getFeedbacks() {
    console.log("in get feed");
    this.service.getAll().subscribe(feedbacks => this.feedbacks = feedbacks);
    /*for(let feed of this.feedbacks) {
      console.log("feed: "+feed.user.username);
    }*/
  }

  getUsers(){
    this.uService.getAll().subscribe(users => this.users = users);
  }

  delete(feedback: FeedbackDTO) {
    this.service.delete(feedback.id).subscribe(() => this.getFeedbacks());
  }

  update(feedback: FeedbackDTO) {
    this.service.update(feedback).subscribe(() => this.getFeedbacks());
  }

  insert(feedback: FeedbackDTO) {
    feedback.creatorName=this.nome;
    //feedback.user=user;
    //console.log("feedback user: "+feedback.user.username);
    this.service.insert(feedback).subscribe(() => this.getFeedbacks());
  }

  clear(){
    this.feedbacktoinsert = new FeedbackDTO();
  }
}

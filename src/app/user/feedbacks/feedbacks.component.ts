import { Component, OnInit } from '@angular/core';
import { FeedbackService } from 'src/service/feedback.service';
import { FeedbackDTO } from 'src/dto/feedbackdto';
import { UserService } from 'src/service/user.service';
import { UserDTO } from 'src/dto/userdto';
import { CompileStylesheetMetadata } from '@angular/compiler';
import { stringify } from 'querystring';
import { SportDTO } from 'src/dto/sportdto';
import { SportService } from 'src/service/sport.service';


@Component({
  selector: 'app-feedbacks',
  templateUrl: './feedbacks.component.html',
  styleUrls: ['./feedbacks.component.css']
})
export class FeedbacksComponent implements OnInit {

  user: UserDTO;
  users: UserDTO[];
  feedbacks: FeedbackDTO[];
  feedbacktoinsert: FeedbackDTO = new FeedbackDTO();
  nome : string;
  sports: SportDTO[];

  constructor(private service: FeedbackService, private uService: UserService, private sService: SportService) { }

  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem('currentUser'));
    this.nome=this.user.username;
    this.getUsers();
    this.getFeedbacks();
    this.getSports();
    console.log("in init");
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

  getSports(){
    this.sService.getAll().subscribe(sports => this.sports = sports);
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

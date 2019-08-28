import { Component, OnInit } from '@angular/core';
import { MessageService } from 'src/service/message.service';
import { MessageDTO } from 'src/dto/messagedto';
import { UserService } from 'src/service/user.service';
import { UserDTO } from 'src/dto/userdto';
import { CompileStylesheetMetadata } from '@angular/compiler';
import { stringify } from 'querystring';



@Component({
  selector: 'app-messages-sent',
  templateUrl: './messages-sent.component.html',
  styleUrls: ['./messages-sent.component.css']
})
export class MessagesSentComponent implements OnInit {

  user: UserDTO;
  users: UserDTO[];
  messages: MessageDTO[];
  messagetoinsert: MessageDTO = new MessageDTO();
  nome : string;
 

  constructor(private service: MessageService, private uService: UserService) { }

  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem('currentUser'));
    this.nome=this.user.username;
    //this.getUsers();
    this.getMessages();
    //this.getMine();
    
    console.log("in init");
  }
  

  /*getMine() {
    console.log("in get mine");
    //this.service.getMine(use).subscribe(feedbacks => this.feedbacks = feedbacks);
    this.feedbacks=this.user.received;
    /*for(let feed of this.feedbacks) {
      console.log("feed: "+feed.user.username);
    }*/
  

  getMessages() {
    console.log("in get messages");
    this.uService.sentmsg(this.user).subscribe(messages => this.messages = messages);
    /*for(let feed of this.feedbacks) {
      console.log("feed: "+feed.user.username);
    }*/
  }

  getUsers() {
    this.uService.getAll().subscribe(users => this.users = users);
  }

  
  delete(message: MessageDTO) {
    this.service.delete(message.id).subscribe(() => this.getMessages());
  }
}

  /*update(feedback: FeedbackDTO) {
    this.service.update(feedback).subscribe(() => this.getFeedbacks());
  }*/

 /* insert(feedback: FeedbackDTO) {
    feedback.creatorName=this.nome;
    //feedback.user=user;
    //console.log("feedback user: "+feedback.user.username);
    this.service.insert(feedback).subscribe(() => this.getMine());
  }*/

  /*clear(){
    this.feedbacktoinsert = new FeedbackDTO();
  }*/


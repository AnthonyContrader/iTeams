import { Component, OnInit } from '@angular/core';
import { MessageService } from 'src/service/message.service';
import { MessageDTO } from 'src/dto/messagedto';
import { UserService } from 'src/service/user.service';
import { UserDTO } from 'src/dto/userdto';
import { CompileStylesheetMetadata } from '@angular/compiler';
import { stringify } from 'querystring';



@Component({
  selector: 'app-messages-send',
  templateUrl: './messages-send.component.html',
  styleUrls: ['./messages-send.component.css']
})
export class MessagesSendComponent implements OnInit {

  user: UserDTO;
  users: UserDTO[];
  messages: MessageDTO[];
  messagetoinsert: MessageDTO = new MessageDTO();
  nome : string;
 

  constructor(private service: MessageService, private uService: UserService) { }

  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem('currentUser'));
    this.nome=this.user.username;
    this.getUsers();
    //this.getMessages();
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
  

  /*getMessages() {
    console.log("in get messages");
    this.service.getAll().subscribe(messages => this.messages = messages);
    /*for(let feed of this.feedbacks) {
      console.log("feed: "+feed.user.username);
    }
}*/

  sendMessage(){

  }

  getUsers() {
    this.uService.getAll().subscribe(users => this.users = users);
  }

  
  /*delete(message: MessageDTO) {
    this.service.delete(message.id).subscribe(() => this.getMessages());
  }*/


  /*update(feedback: FeedbackDTO) {
    this.service.update(feedback).subscribe(() => this.getFeedbacks());
  }*/

  insert(message : MessageDTO) {
    message.sender=this.user;
    //feedback.user=user;
    //console.log("feedback user: "+feedback.user.username);
    this.service.insert(message).subscribe();
  }

  clear(){
    this.messagetoinsert = new MessageDTO();
  }
}

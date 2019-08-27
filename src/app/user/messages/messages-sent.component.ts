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
  text: string;
  nome : string;
  
  constructor(private service: MessageService, private uService: UserService) { }

  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem('currentUser'));
    this.nome=this.user.username;
    this.getUsers();
    this.getMessages();
    
    console.log("in init");
  }

  getMessages() {
    console.log("in get messages");
    this.service.getAll().subscribe(messages => this.messages = messages);
    /*for(let feed of this.feedbacks) {
      console.log("feed: "+feed.user.username);
    }*/
  }

  getUsers(){
    this.uService.getAll().subscribe(users => this.users = users);
  }

  delete(message: MessageDTO) {
    this.service.delete(message.id).subscribe(() => this.getMessages());
  }

  update(message: MessageDTO) {
    this.service.update(message).subscribe(() => this.getMessages());
  }

  insert(message: MessageDTO) {
    message.text=this.nome;
    //feedback.user=user;
    //console.log("feedback user: "+feedback.user.username);
    this.service.insert(message).subscribe(() => this.getMessages());
  }

  clear(){
    this.messagetoinsert = new MessageDTO();
  }
}

import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/service/user.service';
import { UserDTO } from 'src/dto/userdto';

@Component({
  selector: 'app-accounts',
  templateUrl: './accounts.component.html',
  styleUrls: ['./accounts.component.css']
})
export class AccountsComponent implements OnInit {
  user: UserDTO;
  //users: UserDTO[];
  //usertoinsert: UserDTO = new UserDTO();

  constructor(private service: UserService) { }

  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem('currentUser'));
    //this.getUsers();
  }

 /* getUsers() {
    this.service.getAll().subscribe(users => this.users = users);
  }*/

 /* delete(user: UserDTO) {
    this.service.delete(user.id).subscribe(() => this.getUsers());
  }*/

  update(user: UserDTO) {
    console.log("nome utente:"+user.username);
    this.service.insert(user).subscribe(() => this.user);
  }
/*
  insert(user: UserDTO) {
    this.service.insert(user).subscribe(() => this.getUsers());
  }
*/
/*
  read() {
    this.service.read();
  }
*/
/*
  clear(){
    this.usertoinsert = new UserDTO();
  }
  */
}

import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { HttpClient } from '@angular/common/http';
import { SportDTO } from 'src/dto/sportdto';
import { Observable } from 'rxjs';
import { UserDTO } from 'src/dto/userdto';


@Injectable({
  providedIn: 'root'
})
export class SportService extends AbstractService<SportDTO>{
  user: UserDTO;
  constructor(http: HttpClient) { 
    super(http);
    this.type = 'sport';
  }

  /*auth() {
    this.user = JSON.parse(localStorage.getItem('currentUser'));
    if(this.user) {
        return 'Bearer ' + this.user.authorities;
    } else {
        return '';
    }
  }*/


  /*getSports(): Observable<SportDTO[]>{
    return this.http.get<SportDTO[]>('http://localhost:8080/micro1/api/sports', {
      headers: {
          Authorization: this.auth()
      }
    });
  }*/
}

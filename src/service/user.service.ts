import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { UserDTO } from 'src/dto/userdto';
import { HttpClient } from '@angular/common/http';
import { LoginDTO } from 'src/dto/logindto';
import { Observable } from 'rxjs';
import { EventDTO } from 'src/dto/eventdto';
import { SportDTO } from 'src/dto/sportdto';
import { MessageDTO } from 'src/dto/messagedto';

/**
 * I service sono decorati da @Injectable. 
 * Qui trovate, oltre ai metodi ereditati dall'Abstract,
 *  il metodo per il login (in mirror con il backend).
 * 
 * @author Vittorio Valent
 * 
 * @see AbstractService
 */
@Injectable({
  providedIn: 'root'
})
export class UserService extends AbstractService<UserDTO>{

  constructor(http: HttpClient) {
    super(http);
    this.type = 'user';
  }

  login(loginDTO: LoginDTO): Observable<UserDTO> {
    return this.http.post<any>('http://localhost:8080/' + this.type + '/login', loginDTO)
  }

  mine(userDTO: UserDTO): Observable<EventDTO[]> {
    return this.http.post<any>('http://localhost:8080/' + this.type + '/geteventcreated', userDTO)
  }
  
  liked(userDTO: UserDTO): Observable<SportDTO[]> {
    return this.http.post<any>('http://localhost:8080/' + this.type + '/getliked', userDTO)
  }

  receivedmsg(userDTO: UserDTO): Observable<MessageDTO[]> {
    return this.http.post<any>('http://localhost:8080/' + this.type + '/getreceivedmsg', userDTO)
  }

  sentmsg(userDTO: UserDTO): Observable<MessageDTO[]> {
    return this.http.post<any>('http://localhost:8080/' + this.type + '/getsentmsg', userDTO)
  }


}

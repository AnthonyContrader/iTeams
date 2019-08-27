import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UserDTO } from 'src/dto/userdto';
import { MessageDTO } from 'src/dto/messagedto';

@Injectable({
  providedIn: 'root'
})
export class MessageService extends AbstractService<MessageDTO> {

  constructor(http: HttpClient) { 
    super(http);
    this.type = 'message';
  }

 
}

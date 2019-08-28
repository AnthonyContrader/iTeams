import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { HttpClient } from '@angular/common/http';
import { EventDTO } from 'src/dto/eventdto';
import { UserDTO } from 'src/dto/userdto';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EventService extends AbstractService<EventDTO>{

  constructor(http: HttpClient) { 
    super(http);
    this.type = 'event';
  }
}

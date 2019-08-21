import { Injectable } from '@angular/core';
import { EventDTO } from 'src/dto/eventdto';
import { AbstractService } from './abstractservice';
import { HttpClient } from '@angular/common/http';



@Injectable({
  providedIn: 'root'
})
export class EventService extends AbstractService<EventDTO> {

    constructor(http: HttpClient) {
      super(http);
      this.type = 'event';
    }
  
    
  }

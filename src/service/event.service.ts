import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { HttpClient } from '@angular/common/http';
import { EventDTO } from 'src/dto/eventdto';
import { UserDTO } from 'src/dto/userdto';
import { Observable } from 'rxjs';
import { SportDTO } from 'src/dto/sportdto';

@Injectable({
  providedIn: 'root'
})
export class EventService extends AbstractService<EventDTO>{

  constructor(http: HttpClient) { 
    super(http);
    this.type = 'event';
  }

  notify(eventDTO: EventDTO){
    //super.insert(eventDTO).subscribe(()=>eventDTO);
    console.log("in norify evento service");
    return this.http.post<any>('http://localhost:8080/' + this.type + '/notify', eventDTO)
  }

}

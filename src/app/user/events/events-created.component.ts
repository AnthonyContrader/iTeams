import { Component, OnInit } from '@angular/core';
import { EventService } from 'src/service/event.service';
import { EventDTO } from 'src/dto/eventdto';
import { UserDTO } from 'src/dto/userdto';
import { SportDTO } from 'src/dto/sportdto';
import { SportService } from 'src/service/sport.service';

@Component({
  selector: 'app-events-created',
  templateUrl: './events-created.component.html',
  styleUrls: ['./events-created.component.css']
})
export class EventsCreatedComponent implements OnInit {

  events: EventDTO[];
  eventtoinsert: EventDTO = new EventDTO();
  creator: UserDTO;
  sports: SportDTO[];

  constructor(private service: EventService, private sService: SportService) { }

  ngOnInit() {
    this.creator = JSON.parse(localStorage.getItem('currentUser'));
    this.getEvents();
    //this.getSports();
  }

  getEvents() {
    //this.service.getAll().subscribe(events => this.events = events);
    //this.events = this.creator.created;
  }

  getSports(){
    this.sService.getAll().subscribe(sports => this.sports = sports);
  }

  delete(event: EventDTO) {
    //this.creator.created.splice(this.creator.created.indexOf(event), 1);
    this.service.delete(event.id).subscribe(() => this.getEvents()); 
  }
 
  update(event: EventDTO) {
    this.service.update(event).subscribe(() => this.getEvents());
  }

  insert(event: EventDTO) {
    console.log("creator id: "+this.creator.username);
    event.creator=this.creator;
    this.service.insert(event).subscribe(() => this.getEvents());
  }

  clear(){
    this.eventtoinsert = new EventDTO();
  }
}

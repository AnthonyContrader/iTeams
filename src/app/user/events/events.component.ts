import { Component, OnInit } from '@angular/core';
import { EventService } from 'src/service/event.service';
import { EventDTO } from 'src/dto/eventdto';

@Component({
  selector: 'app-events',
  templateUrl: './events.component.html',
  styleUrls: ['./events.component.css']
})
export class EventsComponent implements OnInit {

  events: EventDTO[];
  eventtoinsert: EventDTO = new EventDTO();

  constructor(private service: EventService) { }

  ngOnInit() {
    this.getEvents();
  }

  getEvents() {
    this.service.getAll().subscribe(events => this.events = events);
  }

  delete(event: EventDTO) {
    this.service.delete(event.id).subscribe(() => this.getEvents());
  }

  update(event: EventDTO) {
    this.service.update(event).subscribe(() => this.getEvents());
  }

  insert(event: EventDTO) {
    this.service.insert(event).subscribe(() => this.getEvents());
  }

  clear(){
    this.eventtoinsert = new EventDTO();
  }
}

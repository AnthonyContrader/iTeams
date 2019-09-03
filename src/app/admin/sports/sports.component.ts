import { Component, OnInit } from '@angular/core';
import { SportService } from 'src/service/sport.service';
import { SportDTO } from 'src/dto/sportdto';

@Component({
  selector: 'app-sports',
  templateUrl: './sports.component.html',
  styleUrls: ['./sports.component.css']
})
export class SportsComponent implements OnInit {

  sports: SportDTO[];
  sporttoinsert: SportDTO = new SportDTO();

  constructor(private service: SportService) { }

  ngOnInit() {
    this.getSports();
  }

  getSports() {
    this.service.getAll().subscribe(sports => this.sports = sports);
  }

  delete(sport: SportDTO) {
    this.service.delete(sport.id).subscribe(() => this.getSports());
  }

  update(sport: SportDTO) {
    this.service.update(sport).subscribe(() => this.getSports());
  }

  insert(sport: SportDTO) {
    this.service.insert(sport).subscribe(() => this.getSports());
  }

  clear(){
    this.sporttoinsert = new SportDTO();
  }
}

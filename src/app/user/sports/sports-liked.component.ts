import { Component, OnInit } from '@angular/core';
import { SportService } from 'src/service/sport.service';
import { SportDTO } from 'src/dto/sportdto';
import { UserDTO } from 'src/dto/userdto';

@Component({
  selector: 'app-sports-liked',
  templateUrl: './sports-liked.component.html',
  styleUrls: ['./sports-liked.component.css']
})
export class SportsLikedComponent implements OnInit {

  user: UserDTO;
  sports: SportDTO[];
  sporttoinsert: SportDTO = new SportDTO();

  constructor(private service: SportService) { }

  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem('currentUser'));
    this.sports=this.user.like;
   // this.getSports();
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

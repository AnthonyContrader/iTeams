import { Component, OnInit } from '@angular/core';
import { SportService } from 'src/service/sport.service';
import { SportDTO } from 'src/dto/sportdto';
import { UserDTO } from 'src/dto/userdto';
import { UserService } from 'src/service/user.service';

@Component({
  selector: 'app-sports',
  templateUrl: './sports.component.html',
  styleUrls: ['./sports.component.css']
})
export class SportsComponent implements OnInit {
  users : UserDTO[];
  user: UserDTO;
  sporttoupdate: SportDTO;
  sports: SportDTO[];
  sporttoinsert: SportDTO = new SportDTO();
  sportL: SportDTO =new SportDTO();
  constructor(private service: SportService, private uService: UserService) { }

  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem('currentUser'));
    this.getSports();
  }

  getSports() {
    this.service.getAll().subscribe(sports => this.sports = sports);
  }

  liked(sport: SportDTO){
    console.log("indice:"+this.user.like.indexOf(sport));
    this.user.like.splice(this.user.like.indexOf(sport), 1);
    console.log("in ELSE");
    this.user.like.push(sport);
    this.uService.update(this.user).subscribe(()=>this.user);
    localStorage.setItem('currentUser', JSON.stringify(this.user));
    console.log("utente corrente: "+localStorage.getItem('currentUser'));
    this.service.update(sport).subscribe(() => this.getSports());
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

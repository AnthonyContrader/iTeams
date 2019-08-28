import { Component, OnInit } from '@angular/core';
import { SportService } from 'src/service/sport.service';
import { SportDTO } from 'src/dto/sportdto';
import { UserDTO } from 'src/dto/userdto';
import { UserService } from 'src/service/user.service';

@Component({
  selector: 'app-sports-liked',
  templateUrl: './sports-liked.component.html',
  styleUrls: ['./sports-liked.component.css']
})
export class SportsLikedComponent implements OnInit {

  user: UserDTO;
  sp: SportDTO;
  sports: SportDTO[];
  sporttoinsert: SportDTO = new SportDTO();

  constructor(private service: SportService, private uService: UserService) { }

  ngOnInit() {
    this.sp= new SportDTO();
    this.user = JSON.parse(localStorage.getItem('currentUser'));
    //this.sports=this.user.like;
    this.getSports();
  }

  getSports() {
    this.uService.liked(this.user).subscribe(sports => this.sports = sports);
    //this.sports=this.user.like;
  }

 /* delete(sport: SportDTO) {
    this.service.delete(sport.id).subscribe(() => this.getSports());
  }
*/
  update(sport: SportDTO) {
    this.service.update(sport).subscribe(() => this.getSports());
  }
/*
  insert(sport: SportDTO) {
    this.service.insert(sport).subscribe(() => this.getSports());
  }
*/
  clear(){
    this.sporttoinsert = new SportDTO();
  }

  unlike(sport: SportDTO){
    //this.service.read(sport.id).subscribe(()=>this.sp);
    console.log("nome di "+sport.name+": "+this.user.like.indexOf(sport));
    this.user.like.splice(this.user.like.indexOf(sport), 1);
    //console.log("index of sport unlike: "+this.user.like.indexOf(sport));
    this.uService.update(this.user).subscribe(u=>this.user=u);
    this.getSports();
    localStorage.setItem('currentUser', JSON.stringify(this.user));
    //console.log("utente corrente: "+localStorage.getItem('currentUser'));
    //this.service.update(sport).subscribe(() => this.getSports());
    //this.service.read(sport.id).subscribe(() =>this.sp);
    //this.sp.likes.splice(this.sp.likes.indexOf(this.user),1);
    //this.update(this.sp);
    
  }
}

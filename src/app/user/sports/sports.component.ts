import { Component, OnInit } from '@angular/core';
import { SportService } from 'src/service/sport.service';
import { SportDTO } from 'src/dto/sportdto';
import { UserDTO } from 'src/dto/userdto';
import { UserService } from 'src/service/user.service';
import { BOOL_TYPE } from '@angular/compiler/src/output/output_ast';

@Component({
  selector: 'app-sports',
  templateUrl: './sports.component.html',
  styleUrls: ['./sports.component.css']
})
export class SportsComponent implements OnInit {
  indice: number;
  users : UserDTO[];
  user: UserDTO;
  sporttoupdate: SportDTO;
  sports: SportDTO[];
  sporttoinsert: SportDTO = new SportDTO();
  sportL: SportDTO[];
  bb : Boolean=true;
  constructor(private service: SportService, private uService: UserService) { }

  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem('currentUser'));
    this.getSports();
  }

  getSports() {
    this.service.getAll().subscribe(sports => this.sports = sports);
  }

  liked(sport: SportDTO){
    console.log("nome sport: "+sport.name);
    console.log(this.user.like.indexOf(sport));
    console.log("lunghezza array"+this.user.like.length);
    this.sportL=this.user.like;
    console.log("toStrong: "+this.user.like.toString);
    sp : SportDTO;
    
    for(let sp of this.sportL){
      console.log("sportName:"+sport.name);
      console.log("sportName:"+sp.name);
      if(sp.name==sport.name){
        this.bb=false;
        console.log("nell'if del for");
      }
    }
    if(!this.bb){
      console.log("in IF");
    }
    else{
      console.log("in ELSE");
      this.user.like.push(sport);
      this.uService.update(this.user).subscribe(()=>this.user);
      localStorage.setItem('currentUser', JSON.stringify(this.user));
      console.log("utente corrente: "+localStorage.getItem('currentUser'));
      //this.service.update(sport).subscribe(() => this.getSports());
    }
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

  /*
  joined(sport: SportDTO) : boolean{
    this.uSports=this.user.like;

    if(this.uSports.includes(sport))
      return false;
    else
      return true;
  }
  */
  clear(){
    this.sporttoinsert = new SportDTO();
  }
}

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
  sportM:SportDTO;
  mysports: SportDTO[];
  bb : Boolean=true;
  constructor(private service: SportService, private uService: UserService) { }

  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem('currentUser'));
    this.getSports();
    this.mySports();
  }

  getSports() {
    this.service.getAll().subscribe(sports => this.sports = sports);
  }

  mySports() {
    this.uService.liked(this.user).subscribe(mysports => this.mysports = mysports);
  }


  join(spor: SportDTO){
    console.log("sport likato spor"+spor.name);
    //this.service.read(spor.id).subscribe(sc => this.sportM= sc);
    //console.log("sport likato"+this.sportM.name);
    this.user.like.push(spor); 
    this.uService.update(this.user).subscribe(u=>this.user=u);
    localStorage.setItem('currentUser', JSON.stringify(this.user));
  }
  liked(sport: SportDTO){
    ///this.sportL=this.user.like;
    sp : SportDTO;
    
    for(let sp of this.mysports){
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
      //localStorage.setItem('currentUser', JSON.stringify(this.user));
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

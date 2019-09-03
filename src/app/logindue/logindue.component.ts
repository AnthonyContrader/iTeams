import { Component, OnInit } from '@angular/core';
import { LoginDTO } from 'src/dto/logindto';
import { UserDTO } from 'src/dto/userdto';
import { NgForm } from '@angular/forms';
import { LogindueService } from 'src/service/logindue.service';
import { Router } from '@angular/router';
import { trigger, state, style, transition, animate } from '@angular/animations';

@Component({
  selector: 'app-logindue',
  templateUrl: './logindue.component.html',
  styleUrls: ['./logindue.component.css'],
  animations: [
    trigger('lunotrig', [
      state('default', style({ transform: 'rotate(45deg)' })),
      state('*', style({ transform: 'translateY(-7em)' })),
      transition('* <=> default', animate('500ms ease-out'))
    ]),
    trigger('lduetrig', [
      state('default', style({ transform: 'rotate(-45deg)' })),
      state('*', style({ transform: 'translateY(7em)'})),
      transition('default <=> *', animate('500ms ease-in'))
    ]),
    trigger('logtrig', [
      state('logstate', style({ opacity: 1 })),
      state('default', style({ opacity: 0 })),
      state('signstate', style({ opacity: 0 })),
      transition('* <=> logstate', animate('500ms ease-in'))
    ]),
    trigger('signtrig', [
      state('signstate', style({ opacity: 1 })),
      state('logstate', style({ opacity: 0 })),
      state('default', style({ opacity: 0 })),
      transition('* <=> signstate', animate('500ms ease-out'))
    ])]
})
export class LogindueComponent implements OnInit {

  loginDTO: LoginDTO;

  state = 'default';
  logstate = 'default';
  signstate = 'default';

  ext() {
    this.state = 'default';
  }

  logst(){
    this.state = 'logstate';
  }

  regst(){
    this.state = 'signstate';
  }



  constructor(private loginService: LogindueService, private router: Router) { }

  ngOnInit() {
  }

  login(f: NgForm): void {
    this.loginDTO = new LoginDTO(f.value.username, f.value.password);
    this.loginService.login(this.loginDTO).subscribe((response: any) => {
     // console.log('Risposta: ' + JSON.stringify(response));
     // console.log('authorities: '+ response.id_token);
      localStorage.setItem('currentUser', JSON.stringify({ authorities: response.id_token }));

      // tslint:disable-next-line: no-shadowed-variable
      this.loginService.getUserLogged(this.loginDTO.username).subscribe((response: UserDTO) => {
       // console.log('risposta in getUL: ' + JSON.stringify(response));
        //console.log('risposta in getUL auth: ' + response.authorities);
        localStorage.setItem('currentUserData', JSON.stringify(response));

        if (response.authorities.includes('ROLE_ADMIN')) {
          //console.log('sono amministratore');
          this.router.navigate(['/admin-dashboard']);
        } else {
          this.router.navigate(['/user-dashboard']);
        }
      });
    });
  }
}

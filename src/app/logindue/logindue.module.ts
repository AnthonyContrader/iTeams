import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LogindueComponent } from './logindue.component';
import { LogindueRoutingModule } from './logindue-routing.module';
import { FormsModule } from '@angular/forms';

/**
 * Questo modulo serve unicamente Login e Registrazione (non implementata)
 * Importa il suo modulo di routing
 * @author Vittorio Valent
 */
@NgModule({
  declarations: [LogindueComponent],

  imports: [
    CommonModule,
    LogindueRoutingModule,
    FormsModule
  ]
})
export class LogindueModule { }

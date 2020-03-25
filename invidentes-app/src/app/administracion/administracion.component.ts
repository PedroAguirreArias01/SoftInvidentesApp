import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-administracion',
  templateUrl: './administracion.component.html',
  styleUrls: ['./administracion.component.css']
})
export class AdministracionComponent implements OnInit {

  public isUsuarios: boolean = true;
  public isNormatividad: boolean = false;
  public isPqrs: boolean = false;
  public isQuienesSomos: boolean = false;
  public isNotificaciones: boolean = false;


  constructor() { }

  ngOnInit() {
  }


  controlarTabUsuarios(){
    this.isUsuarios = true;
    this.isNormatividad = false;
    this.isPqrs = false;
    this.isQuienesSomos = false;
    this.isNotificaciones = false;
  }

  controlarTabNormatividad(){
    this.isUsuarios = false;
    this.isNormatividad = true;
    this.isPqrs = false;
    this.isQuienesSomos = false;
    this.isNotificaciones = false;
  }

  controlarTabPqrs(){
    this.isUsuarios = false;
    this.isNormatividad = false;
    this.isPqrs = true;
    this.isQuienesSomos = false;
    this.isNotificaciones = false;
  }

  controlarTabQuienesSomos(){
    this.isUsuarios = false;
    this.isNormatividad = false;
    this.isPqrs = false;
    this.isQuienesSomos = true;
    this.isNotificaciones = false;
  }

  controlarTabNotificaciones(){
    this.isUsuarios = true;
    this.isNormatividad = false;
    this.isPqrs = false;
    this.isQuienesSomos = false;
    this.isNotificaciones = false;
  }

}

import { Component, OnInit } from '@angular/core';
import { PqrsService } from '../services/pqrs.service';
import { PqrsDTO } from '../dto/pqrs.dto';

@Component({
  selector: 'app-gestion-pqrs',
  templateUrl: './gestion-pqrs.component.html',
  styleUrls: ['./gestion-pqrs.component.css']
})
export class GestionPqrsComponent implements OnInit {

  private listaPqrs: PqrsDTO[] = [];

  constructor(private pqrsService: PqrsService) { }

  ngOnInit() {
    this.cargarInformacionPQRS();
  }

  cargarInformacionPQRS(){
    this.pqrsService.getPqrs().subscribe(respuesta => {
      this.listaPqrs = respuesta;
    })
  }

  eliminarPqrs(){

  }

  editarPqrs(pqrs){
    
  }

}

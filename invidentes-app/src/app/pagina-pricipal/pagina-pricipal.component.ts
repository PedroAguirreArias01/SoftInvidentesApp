import { Component, OnInit } from '@angular/core';
import { NormatividadDTO } from '../dto/normatividad.dto';
import { NormatividadService } from '../services/normatividad.service';

@Component({
  selector: 'app-pagina-pricipal',
  templateUrl: './pagina-pricipal.component.html',
  styleUrls: ['./pagina-pricipal.component.css']
})
export class PaginaPricipalComponent implements OnInit {

  /**
   * Lista de normas que se encuentran en la base de datos 
   */
  public normatividad: NormatividadDTO[] = [];

  constructor(private normatividadService: NormatividadService) { }

  ngOnInit() {
    this.getNormatividad();
  }

  public getNormatividad(): void {
    this.normatividadService.getNormatividad().subscribe(normatividad => {
      this.normatividad = normatividad;
    });
  }

}

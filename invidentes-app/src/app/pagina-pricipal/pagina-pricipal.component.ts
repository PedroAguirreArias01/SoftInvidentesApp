import { Component, OnInit } from '@angular/core';
import { NormatividadDTO } from '../dto/normatividad.dto';
import { NormatividadService } from '../services/normatividad.service';
import { TipoNormativaDTO } from '../dto/tipoNormativa.dto';

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

  /**
   * Lista de tipo de normativa la cual se encargara de las opciones en el menu
   */
  public listaTipoNormativa: TipoNormativaDTO[] = [];

  /**
   * Opcion seleccionada por el usuario
   */
  public opcionSeleccionada: string;

  constructor(private normatividadService: NormatividadService) { }

  ngOnInit() {
    this.getNormatividad();
    this.getTipoNormatividad();
  }

  /**
   * Metodo encargado de obtener toda la normatividad 
   */
  public getNormatividad(): void {
    this.normatividadService.getNormatividad().subscribe(normatividad => {
      if(normatividad != null){
        this.normatividad = normatividad;
      }
    });
  }

  /**
   * Metodo encargado de obtener el tipo de normatividad 
   */
  public getTipoNormatividad(): void {
    this.normatividadService.getTipoNormatividad().subscribe(tipoNormatividad => {
      if(tipoNormatividad != null){
        this.listaTipoNormativa = tipoNormatividad;
      }
    });
  }

  buscarNormatividadPorTIpo(tipoNormativa: TipoNormativaDTO){
    this.opcionSeleccionada = tipoNormativa.nombre;
    this.normatividadService.getNormatividadPorTipo(tipoNormativa).subscribe(normatividad => {
      if(normatividad != null){
        this.normatividad = normatividad;
      }
    });
  }



}

import { Injectable } from '@angular/core';
import { ColaboradorDTO } from '../dto/colaborador.dto';
import { Observable, of } from 'rxjs';
import { USUARIOS } from '../colaborador/colaborador.json.js';
/**
 * @description clase que se encarga de gestionar los  servicios de colaborador
 * @author Pedro Aguirre Arias
 */
@Injectable({
  providedIn: 'root'
})
export class ColaboradorService {
  /**
   * @description contructor de la clase
   */
  constructor() { }

  /**
   * @description metodo encargado de obtener todos los colaboradores que se encuentran en la base de datos
   * @author Pedro Aguirre Arias <pedro.aguirre@uptc.edu.co>
   */
  getColaboradores(): Observable<ColaboradorDTO[]> {
    return of(USUARIOS);
  }
}

import { Injectable, Injector } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { NormatividadDTO } from '../dto/normatividad.dto';
/**
 * @description clase que se encarga de gestionar los  servicios de normatividad
 * @author Pedro Aguirre Arias
 */
@Injectable({
  providedIn: 'root'
})
export class NormatividadService {
  /**
   * Url que define la localizacion de los recursos 
   */
  private urlEndPoint: string = 'http://localhost:8080/normatividad/';

  constructor(injector: Injector, private http : HttpClient) { }

  
  /**
   * @description metodo encargado de obtener toda la normatividad que se encuentra en la base de datos
   * @author Pedro Aguirre Arias <pedro.aguirre@uptc.edu.co>
   */
  getNormatividad(): Observable<any> {
    return this.http.get(this.urlEndPoint);
  }

  /**
   * @description Metodo encargado de crear la normatividad
   * @param normatividadDTO 
   */
  crear(normatividadDTO: NormatividadDTO): Observable<any> {
    return this.http.post(this.urlEndPoint, normatividadDTO);
  }

  /**
   * @description Metodo encargado de modificar la informacion repecto a la normatividad
   */
  editar(normatividadDTO: NormatividadDTO): Observable<any> {
    return this.http.put(this.urlEndPoint, normatividadDTO);
  }

  /**
   * @description Metodod encargado de elimanar una norma
   * @param id 
   */
  eliminar(id: number): Observable<any> {
    return this.http.delete(this.urlEndPoint+id);
  }

}

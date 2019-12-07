import { Injectable, Injector } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
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
   * @param colaboradorDTO 
   */
  crear(colaboradorDTO: ColaboradorDTO): Observable<any> {
    return this.http.post(this.urlEndPoint, colaboradorDTO);
  }

  /**
   * @description Metodo encargado de modificar la informacion del colaborador
   */
  editar(colaboradorDTO: ColaboradorDTO): Observable<any> {
    return this.http.put(this.urlEndPoint, colaboradorDTO);
  }

  /**
   * @description Metodod encargado de elimanar un colaborador
   * @param id 
   */
  eliminar(id: number): Observable<any> {
    return this.http.delete(this.urlEndPoint+id);
  }

}

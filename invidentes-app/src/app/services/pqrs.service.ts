import { Injectable, Injector } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { PqrsDTO } from '../dto/pqrs.dto';

@Injectable({
  providedIn: 'root'
})
export class PqrsService {

  /**
   * Url que define la localizacion de los recursos 
   */
  private urlEndPoint: string = 'http://localhost:8080/normatividad/';

  constructor(injector: Injector, private http : HttpClient) { }

  
  /**
   * @description metodo encargado de obtener toda informacion que se encuentra en la base de datos
   * @author Pedro Aguirre Arias <pedro.aguirre@uptc.edu.co>
   */
  getPqrs(): Observable<any> {
    return this.http.get(this.urlEndPoint);
  }

  /**
   * @description Metodo encargado de crear la normatividad
   * @param pqrsDTO 
   */
  crear(pqrsDTO: PqrsDTO): Observable<any> {
    return this.http.post(this.urlEndPoint, pqrsDTO);
  }

  /**
   * @description Metodo encargado de modificar la informacion repecto a la normatividad
   */
  editar(pqrsDTO: PqrsDTO): Observable<any> {
    return this.http.put(this.urlEndPoint, pqrsDTO);
  }

  /**
   * @description Metodod encargado de elimanar 
   * @param id 
   */
  eliminar(id: number): Observable<any> {
    return this.http.delete(this.urlEndPoint+id);
  }
}

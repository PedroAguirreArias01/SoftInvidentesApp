import { Injectable, Injector } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { NormatividadDTO } from '../dto/normatividad.dto';
import { URL_SERVIDOR } from 'src/assets/constantes/configServer';
import { catchError } from 'rxjs/operators';
import Swal from 'sweetalert2';
import { TipoNormativaDTO } from '../dto/tipoNormativa.dto';
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
  private urlEndPoint: string = URL_SERVIDOR+'normatividad/';

   httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    })
  };

  constructor(injector: Injector, private http : HttpClient) {
    

  }

  
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
    return this.http.put(`${this.urlEndPoint}${normatividadDTO.id}`, normatividadDTO, this.httpOptions).pipe(
      catchError(e => {
        Swal.fire('error',e.error.mensaje, 'error');
        return throwError(e);
      })
    );
  }

  /**
   * @description Metodod encargado de elimanar una norma
   * @param id 
   */
  eliminar(id: number): Observable<any> {
    return this.http.delete(this.urlEndPoint+id);
  }

  /**
   * @description metodo encargado de obtener todos los tipos de normatividad que se encuentran en la base de datos
   * @author Pedro Aguirre Arias <pedro.aguirre@uptc.edu.co>
   */
  getTipoNormatividad(): Observable<any> {
    return this.http.get(`${this.urlEndPoint}tipoNormatividad`, this.httpOptions).pipe(
      catchError(e => {
        Swal.fire('error',e.error.mensaje, 'error');
        return throwError(e);
      })
    );
  }

  /**
   * @description metodo encargado de guardar la informacion referente al tipo de normatividad
   * @author Pedro Aguirre Arias <pedro.aguirre@uptc.edu.co>
   */
  guardarTipoNormatividad(tipoNormatividad: TipoNormativaDTO): Observable<any> {
    return this.http.post(`${this.urlEndPoint}tipoNormatividad`, tipoNormatividad, this.httpOptions).pipe(
      catchError(e => {
        Swal.fire('error',e.error.mensaje, 'error');
        return throwError(e);
      })
    );
  }

/**
   * @description metodo encargado de actualizar la informacion referente al tipo de normatividad
   * @author Pedro Aguirre Arias <pedro.aguirre@uptc.edu.co>
   */
  actualizarTipoNormatividad(tipoNormatividad: TipoNormativaDTO): Observable<any> {
    return this.http.put(`${this.urlEndPoint}tipoNormatividad/${tipoNormatividad.id}`, tipoNormatividad, this.httpOptions).pipe(
      catchError(e => {
        Swal.fire('error',e.error.mensaje, 'error');
        return throwError(e);
      })
    );
  }

  /**
   * @description metodo encargado de eliminar la informacion referente al tipo de normatividad
   * @author Pedro Aguirre Arias <pedro.aguirre@uptc.edu.co>
   */
  eliminarTipoNormatividad(id:number): Observable<any> {
    return this.http.delete(`${this.urlEndPoint}tipoNormatividad/${id}`, this.httpOptions).pipe(
      catchError(e => {
        Swal.fire('error', e.error.mensaje, 'error');
        return throwError(e);
      })
    );
  }

}

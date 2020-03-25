import { Injectable, Injector } from '@angular/core';
import { URL_SERVIDOR } from 'src/assets/constantes/configServer';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { QuienesSomos } from '../dto/quienesSomos.dto';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import Swal from 'sweetalert2';

@Injectable({
  providedIn: 'root'
})
export class AdministracionService {

  /**
   * Url que define la localizacion de los recursos 
   */
  private urlEndPoint: string = URL_SERVIDOR+'quienSomos/';
  httpOptions = {
    'headers': new HttpHeaders({
    'Content-Type': 'application/json',
    })
    };
  
  constructor(injector: Injector, private http : HttpClient) { }

  /**
   * guarda la informacion de quienes somos
   * @param quienesSomos 
   */
  guardarQuienesSomos(quienesSomos:QuienesSomos):Observable<any>{
    return this.http.post(this.urlEndPoint,quienesSomos,this.httpOptions);
  }

  /**
   * Metodo que consulta la info de quienes somos
   */
  consultarTodos(): Observable<any>{
    return this.http.get(this.urlEndPoint).pipe(
      catchError(e => {
      Swal.fire('Error al cargar los usuarios', e.error.mensaje, 'error');
      return throwError(e);
      })
      );
  }

  /**
   *  metodo encargado de actualizar la informacion de quienes somos
   * @param quienesSomos 
   */
  editarQuienesSomos(quienesSomos: QuienesSomos, id: number): Observable<any>{
    console.log('info: '+quienesSomos+' id: '+id);
    
    return this.http.put(`${this.urlEndPoint}${id}`, quienesSomos);
  }

  /**
   * Metodo que elimina la info de quienes somos
   * @param id 
   */
  eliminarQuienesSomos(id: number): Observable<any>{
    return this.http.delete(`${this.urlEndPoint}${id}`).pipe(
      catchError(e => {
        Swal.fire('Error al eliminar la información', e.error.mensaje, 'error');
        return throwError(e);
      })
    );
  }
}

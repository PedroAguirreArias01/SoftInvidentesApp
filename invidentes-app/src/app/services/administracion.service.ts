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

  guardarQuienesSomos(quienesSomos:QuienesSomos):Observable<any>{
    return this.http.post(this.urlEndPoint,quienesSomos,this.httpOptions);
  }

  consultarTodos(): Observable<any>{
    return this.http.get(this.urlEndPoint).pipe(
      catchError(e => {
      Swal.fire('Error al cargar los usuarios', e.error.mensaje, 'error');
      return throwError(e);
      })
      );
  }

  editarQuienesSomos(quienesSomos: QuienesSomos): Observable<any>{
    return this.http.put(this.urlEndPoint, quienesSomos);
  }
}

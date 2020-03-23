import { Injectable, Injector } from '@angular/core';
import { URL_SERVIDOR } from 'src/assets/constantes/configServer';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { QuienesSomos } from '../dto/quienesSomos.dto';
import { Observable } from 'rxjs';

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

  
}

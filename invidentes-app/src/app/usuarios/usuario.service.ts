import { Injectable } from '@angular/core';
import {Usuario} from './usuario'
import { from, Observable, of } from 'rxjs';
import {USUARIOS } from './usuarios.json'

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  constructor() { }

  getUsuario(): Observable<Usuario[]> {
    return of (USUARIOS);
  }
}

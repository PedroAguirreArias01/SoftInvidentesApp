import { Component, OnInit } from '@angular/core';
import { RolDTO } from '../dto/rol.dto';
import { UsuarioService } from '../services/usuario.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import Swal from 'sweetalert2';
import { Route } from '@angular/compiler/src/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-gestionar-rol',
  templateUrl: './gestionar-rol.component.html',
  styleUrls: ['./gestionar-rol.component.css']
})
export class GestionarRolComponent implements OnInit {

  /**
   * Atributi que  representa el rol del usuario
   */
  public rol: RolDTO;
  /**
   * Atributo que representa la lista de roles
   */
  public roles: RolDTO[] = [];

  public gestionarRolForm: FormGroup;

  constructor(private usuarioService: UsuarioService, private fb: FormBuilder, private router: Router) { 
    this.gestionarRolForm = this.fb.group({
      nombre: [null, Validators.required]
    });
  }

  ngOnInit() {
  }
  

  crearRol(){
    this.rol = new RolDTO();
    this.rol.nombre = this.gestionarRolForm.controls.nombre.value;
    console.log(JSON.stringify(this.rol))
    this.usuarioService.crearRol(this.rol).subscribe(rol => {
      Swal.fire(
        'Rol creado con exito!',
        'success'
      );
      this.router.navigate(['colaboradores']);
    });
  }
}

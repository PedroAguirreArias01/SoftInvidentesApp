import { Component, OnInit } from '@angular/core';
import { RolDTO } from '../dto/rol.dto';
import { UsuarioService } from '../services/usuario.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import Swal from 'sweetalert2';
import { Route } from '@angular/compiler/src/core';
import { Router } from '@angular/router';

@Component({
  selector: 'gestionar-rol',
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
  public isEditar: boolean;
  public idRol: number;

  constructor(
    private usuarioService: UsuarioService,
    private fb: FormBuilder,
    private router: Router) {
    this.gestionarRolForm = this.fb.group({
      nombre: [null, Validators.required]
    });
  }

  ngOnInit() {
  }


  crearRol() {
    if (this.gestionarRolForm.valid) {
      this.rol = new RolDTO();
      this.rol.nombre = this.gestionarRolForm.controls.nombre.value;
      if (this.isEditar === false) {
        this.usuarioService.crearRol(this.rol).subscribe(rol => {
          Swal.fire(
            'Rol creado con exito!',
            'success'
          );
        });
      }else{
        this.rol.id = this.idRol;
        this.usuarioService.editarRol(this.rol).subscribe(respuesta =>{
          Swal.fire(
            respuesta.mensaje,
            'success'
          );
          this.isEditar = false;
          this.limpiarFormulario();
          this.getRoles;
        })
      }
    } else {
      return;
    }
  }

  getRoles() {
    this.usuarioService.getRoles().subscribe(roles => {
      this.roles = roles;
    })
  }

  editar(rol: RolDTO) {
    this.isEditar = true;
    this.idRol = rol.id;
    this.gestionarRolForm.controls.nombre.setValue(rol.nombre);
  }

  eliminar(id: number){
    this.usuarioService.eliminarRol(id).subscribe(respuesta => {
      Swal.fire(
        respuesta.mensaje,
        'success'
      );
      this.getRoles();
    });
  }

  limpiarFormulario(){
    this.gestionarRolForm.reset();
  }

}

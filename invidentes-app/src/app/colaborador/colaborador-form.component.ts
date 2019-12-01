import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ColaboradorService } from '../services/colaboradorService';
import { ColaboradorDTO } from '../dto/colaborador.dto';
import Swal from 'sweetalert2';
import { Router } from '@angular/router';

@Component({
  selector: 'app-colaborador-form',
  templateUrl: './colaborador-form.component.html',
  styleUrls: ['./colaborador-form.component.css']
})
export class ColaboradorFormComponent implements OnInit {
  /**
  * Atributo que contiene los controles del formulario
  */
  public gestionarColaboradorForm: FormGroup;
  /**
   * Atributo que contendra la informacion del colaborador
   */
  private colaborador: ColaboradorDTO;

  /**
   * Atributo que indica si se esta editando un comic
   */
  public editar: boolean;
  /**
   * Atributo para paginado de la tabla
   */
  public pageActual: number = 1;

  constructor(private fb: FormBuilder, private colaboradorservice: ColaboradorService,private router: Router ) {
    this.gestionarColaboradorForm = this.fb.group({
      nombre: [null, Validators.required],
      apellido: [null, Validators.required],
      email: [null, Validators.required],
      usuario: [null, Validators.required],
      password: [null, Validators.required],
    });
  }

  ngOnInit() {
  }

  /**
     * @description Metodo que permite validar el formulario y crear o actulizar un colaborador
     */
  public crearActualizar(): void {
    if (this.gestionarColaboradorForm.invalid) {
      return;
    }
    this.colaborador = new ColaboradorDTO();
    this.colaborador.nombre = this.gestionarColaboradorForm.controls.nombre.value;
    this.colaborador.apellido = this.gestionarColaboradorForm.controls.apellido.value;
    this.colaborador.email = this.gestionarColaboradorForm.controls.email.value;
    this.colaborador.usuario = this.gestionarColaboradorForm.controls.usuario.value;
    this.colaborador.password = this.gestionarColaboradorForm.controls.password.value;
    if (!this.editar) {
      this.colaboradorservice.crearColaborador(this.colaborador).subscribe(resultadoDTO => {
        if (resultadoDTO.exitoso) {
          Swal.fire(
            'Colaborador creado con exito!',
            'success'
          );
          this.limpiarFormulario();
          this.router.navigate(['colaboradores']);
        }
      }, error => {
        console.log(error);
      });

    } else {
      this.colaboradorservice.editar(this.colaborador).subscribe(resultadoDTO => {
        if (resultadoDTO.exitoso) {
          Swal.fire(
            'Comic modificado con exito!',
            'success'
          );
          this.limpiarFormulario();
          this.editar = false;
        }
      });
    }
  }

  /**
  * @description metodo encargado de limpiar el formualrio
  * @author Pedro Aguirre Arias
  */
  private limpiarFormulario(): void {
    this.gestionarColaboradorForm.controls.nombre.setValue(null);
    this.gestionarColaboradorForm.controls.apellido.setValue(null);
    this.gestionarColaboradorForm.controls.email.setValue(null);
    this.gestionarColaboradorForm.controls.usuario.setValue(null);
    this.gestionarColaboradorForm.controls.password.setValue(null);
  }

}

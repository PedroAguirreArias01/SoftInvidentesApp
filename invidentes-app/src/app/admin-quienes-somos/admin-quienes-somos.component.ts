import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { QuienesSomos } from '../dto/quienesSomos.dto';
import { AdministracionService } from '../services/administracion.service';
import Swal from 'sweetalert2';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-quienes-somos',
  templateUrl: './admin-quienes-somos.component.html',
  styleUrls: ['./admin-quienes-somos.component.css']
})
export class AdminQuienesSomosComponent implements OnInit {

  /**variables para manipular datos */
  public quienesSomos: QuienesSomos;
  public quienesSomosEditar: QuienesSomos;

  /**controles del formulario */
  public formControlQuienesSomos: FormGroup; // este atributo tiene los datos del fomulario 
  public listQuienesSomos: QuienesSomos[] = [];
  public isEditar: boolean = false;

  constructor(
    private formBuilder: FormBuilder, 
    private adminService: AdministracionService,
    private routerLink: Router) {
    this.formControlQuienesSomos = formBuilder.group({
      titulo: [null, Validators.required],
      descripcion: [null, Validators.required],
    });
  }

  ngOnInit() {
    this.obtenerTodosQuienesSomos();
  }

  /**
   * metodo encargado de guardar y editar la informacion
   */
  guardar(): void {
    if (this.isEditar == false) {
      this.quienesSomos = new QuienesSomos();
      this.quienesSomos.titulo = this.formControlQuienesSomos.controls.titulo.value;
      this.quienesSomos.descripcion = this.formControlQuienesSomos.controls.descripcion.value;
      this.adminService.guardarQuienesSomos(this.quienesSomos).subscribe(respuesta => {
        this.limpiarFormulario();
        this.obtenerTodosQuienesSomos();
      });
    } else {
      this.quienesSomos = new QuienesSomos();
      this.quienesSomos.titulo = this.formControlQuienesSomos.controls.titulo.value;
      this.quienesSomos.descripcion = this.formControlQuienesSomos.controls.descripcion.value;
      this.adminService.editarQuienesSomos(this.quienesSomos, this.quienesSomosEditar.id).subscribe(info => {
        this.limpiarFormulario();
        this.obtenerTodosQuienesSomos();
        this.isEditar = false;
      })
    }

  }

  /**
   * Metodo que limpia el formulario
   */
  limpiarFormulario() {
    this.formControlQuienesSomos.controls.titulo.setValue(null);
    this.formControlQuienesSomos.controls.descripcion.setValue(null);
  }

  /**
   * Metodo que obtiene todos los datos
   */
  obtenerTodosQuienesSomos(): void {
    this.adminService.consultarTodos().subscribe(quienesSomos => {
      this.listQuienesSomos = quienesSomos;
    })
  }

  /**
   * 
   * @param id Metodo encargado de elimonar datos
   */
  eliminar(id): void {
    this.adminService.eliminarQuienesSomos(id).subscribe(response => {
      Swal.fire('Información eliminada con exito', response, 'success');
      this.obtenerTodosQuienesSomos();
    })
  }

  /**
   * Metodo que se encarga de modificar los datos
   * @param quinesSomos 
   */
  editar(quinesSomos: QuienesSomos) {
    this.isEditar = true;
    this.quienesSomosEditar = quinesSomos;
    this.formControlQuienesSomos.controls.titulo.setValue(quinesSomos.titulo);
    this.formControlQuienesSomos.controls.descripcion.setValue(quinesSomos.descripcion);
  }

  /**
   * Metodo que cancela la modificaciond e los campos
   */
  cancelar(){
    this.formControlQuienesSomos.controls.titulo.setValue(null);
    this.formControlQuienesSomos.controls.descripcion.setValue(null);
    this.isEditar = false;
  }
}

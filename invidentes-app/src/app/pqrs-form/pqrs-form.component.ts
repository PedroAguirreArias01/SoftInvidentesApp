import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import Swal from 'sweetalert2';
import { PqrsDTO } from '../dto/pqrs.dto';
import { Router } from '@angular/router';
import { PqrsService } from '../services/pqrs.service';
/**
 * @description Clase que se encarga de la gestion de PQRS
 * @author Pedro Aguirre Arias <pedro.aguirre@uptc.edu.co>
 */
@Component({
  selector: 'app-pqrs-form',
  templateUrl: './pqrs-form.component.html',
  styleUrls: ['./pqrs-form.component.css']
})
export class PqrsFormComponent implements OnInit {

  /**
  * Atributo que contiene los controles del formulario
  */
 public gestionarPqrsdForm: FormGroup;
 /**
  * Atributo que contendra la informacion del pqrs
  */
 private pqrs: PqrsDTO;

 /**
  * Atributo que indica si se esta editando un comic
  */
 public editar: boolean;
 /**
  * Atributo para paginado de la tabla
  */
 public pageActual: number = 1;

 constructor(private fb: FormBuilder, private pqrsservice: PqrsService,private router: Router ) {
   this.gestionarPqrsdForm = this.fb.group({
     descripcion: [null, Validators.required],
   });
 }

 ngOnInit() {
 }

 /**
    * @descripcion Metodo que permite validar el formulario y crear o actulizar la pqrs
    */
 public crearActualizar(): void {
   if (this.gestionarPqrsdForm.invalid) {
     return;
   }
   this.pqrs = new PqrsDTO();
   this.pqrs.descripcion = this.gestionarPqrsdForm.controls.descripcion.value;
   if (!this.editar) {
     console.log(this.pqrs);
     this.pqrsservice.crear(this.pqrs).subscribe(resultadoDTO => {
       if (resultadoDTO.exitoso) {
         Swal.fire(
           'pqrs creada con exito!',
           'success'
         );
         this.limpiarFormulario();
         this.router.navigate(['paginaPrincipal']);
       }
     }, error => {
       console.log(error);
     });

   } else {
     this.pqrsservice.editar(this.pqrs).subscribe(resultadoDTO => {
       if (resultadoDTO.exitoso) {
         Swal.fire(
           'Información modificada con exito!',
           'success'
         );
         this.limpiarFormulario();
         this.editar = false;
       }
     });
   }
 }

 /**
 * @descripcion metodo encargado de limpiar el formualrio
 * @author Pedro Aguirre Arias
 */
 private limpiarFormulario(): void {
   this.gestionarPqrsdForm.controls.titulo.setValue(null);
   this.gestionarPqrsdForm.controls.descripcion.setValue(null);
   this.gestionarPqrsdForm.controls.contenido.setValue(null);
   this.gestionarPqrsdForm.controls.tipoNormativaEnum.setValue(null);
 }

}

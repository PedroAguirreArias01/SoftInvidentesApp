import { Component, OnInit } from '@angular/core';
import { NormatividadDTO } from '../dto/normatividad.dto';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { NormatividadService } from '../services/normatividad.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
/**
 * @descripcion clase que se encarga de la gestion normativa
 * @author Pedro Aguirre Arias <pedro.aguirre@uptc.edu.co>
 */
@Component({
  selector: 'app-normativa-form',
  templateUrl: './normativa-form.component.html',
  styleUrls: ['./normativa-form.component.css']
})
export class NormativaFormComponent implements OnInit {

   /**
  * Atributo que contiene los controles del formulario
  */
 public gestionarNormatividadForm: FormGroup;
 /**
  * Atributo que contendra la informacion del normatividad
  */
 private normatividad: NormatividadDTO;

 /**
  * Atributo que indica si se esta editando un comic
  */
 public editar: boolean;
 /**
  * Atributo para paginado de la tabla
  */
 public pageActual: number = 1;

 constructor(private fb: FormBuilder, private normatividadservice: NormatividadService,private router: Router ) {
   this.gestionarNormatividadForm = this.fb.group({
     titulo: [null, Validators.required],
     descripcion: [null, Validators.required],
     contenido: [null, Validators.required],
     tipoNormativaEnum: [null, Validators.required],
   });
 }

 ngOnInit() {
 }

 /**
    * @descripcion Metodo que permite validar el formulario y crear o actulizar la normatividad
    */
 public crearActualizar(): void {
   if (this.gestionarNormatividadForm.invalid) {
     return;
   }
   this.normatividad = new NormatividadDTO();
   this.normatividad.titulo = this.gestionarNormatividadForm.controls.titulo.value;
   this.normatividad.descripcion = this.gestionarNormatividadForm.controls.descripcion.value;
   this.normatividad.contenido = this.gestionarNormatividadForm.controls.contenido.value;
   this.normatividad.tipoNormativaEnum = this.gestionarNormatividadForm.controls.tipoNormativaEnum.value;
   if (!this.editar) {
     console.log(this.normatividad);
     this.normatividadservice.crear(this.normatividad).subscribe(resultadoDTO => {
       if (resultadoDTO.exitoso) {
         Swal.fire(
           'normatividad creada con exito!',
           'success'
         );
         this.limpiarFormulario();
         this.router.navigate(['paginaPrincipal']);
       }
     }, error => {
       console.log(error);
     });

   } else {
     this.normatividadservice.editar(this.normatividad).subscribe(resultadoDTO => {
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
   this.gestionarNormatividadForm.controls.titulo.setValue(null);
   this.gestionarNormatividadForm.controls.descripcion.setValue(null);
   this.gestionarNormatividadForm.controls.contenido.setValue(null);
   this.gestionarNormatividadForm.controls.tipoNormativaEnum.setValue(null);
 }

}

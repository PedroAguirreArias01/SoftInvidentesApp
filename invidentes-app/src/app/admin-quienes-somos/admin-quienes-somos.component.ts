import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { QuienesSomos } from '../dto/quienesSomos.dto';
import { AdministracionService } from '../services/administracion.service';

@Component({
  selector: 'app-admin-quienes-somos',
  templateUrl: './admin-quienes-somos.component.html',
  styleUrls: ['./admin-quienes-somos.component.css']
})
export class AdminQuienesSomosComponent implements OnInit {
  public quienesSomos:QuienesSomos;

  public formControlQuienesSomos: FormGroup; // este atributo tiene los datos del fomulario 
  public listQuienesSomos: Array<QuienesSomos>=[];

  constructor(private formBuilder: FormBuilder,private adminService:AdministracionService) {
    this.formControlQuienesSomos = formBuilder.group({
      titulo:[null,Validators.required],
      descripcion:[null,Validators.required],
    });
   }

  ngOnInit() {
    this.obtenerTodosQuienesSomos();
  }
  
  guardar():void{
    this.quienesSomos=new QuienesSomos();
    this.quienesSomos.titulo=this.formControlQuienesSomos.controls.titulo.value;
    this.quienesSomos.descripcion=this.formControlQuienesSomos.controls.descripcion.value;
    this.adminService.guardarQuienesSomos(this.quienesSomos).subscribe(respuesta => {
      console.log(respuesta);
      this.limpiarFormulario();
    });
  }

  limpiarFormulario(){
    this.formControlQuienesSomos.controls.titulo.setValue(null);
    this.formControlQuienesSomos.controls.descripcion.setValue(null);
  }

  obtenerTodosQuienesSomos():void{
    this.adminService.consultarTodos().subscribe(quienesSomos => {
      this.quienesSomos = quienesSomos;
    })
  }

}

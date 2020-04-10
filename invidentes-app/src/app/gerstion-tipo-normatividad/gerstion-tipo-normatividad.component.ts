import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { TipoNormativaDTO } from '../dto/tipoNormativa.dto';
import { NormatividadService } from '../services/normatividad.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'gerstion-tipo-normatividad',
  templateUrl: './gerstion-tipo-normatividad.component.html',
  styleUrls: ['./gerstion-tipo-normatividad.component.css']
})
export class GerstionTipoNormatividadComponent implements OnInit {

  public gestionarTipoNormatividadForm: FormGroup;

  public listaTipoNormatividad: TipoNormativaDTO[] = [];

  public editar: boolean = false;

  public tipoNormatividad: TipoNormativaDTO;

  public idTipoNormativa: number;

  constructor(private fb: FormBuilder, private normatividadService: NormatividadService) { 
    this.gestionarTipoNormatividadForm = this.fb.group({
      nombre: [null, Validators.required]
    });
  }

  ngOnInit() {
    this.obtenerTodoTipoNormativa();
  }

  obtenerTodoTipoNormativa(){
    this.normatividadService.getTipoNormatividad().subscribe(respuesta => {
      console.table(respuesta)
      this.listaTipoNormatividad = respuesta;
    })
  }

  guardarActualizarNormatividad(){
    this.tipoNormatividad = new TipoNormativaDTO();
    if(this.gestionarTipoNormatividadForm.valid){
      this.tipoNormatividad.nombre = this.gestionarTipoNormatividadForm.controls.nombre.value;
    }else{
      alert('completar los campos')
    }
    if(this.editar === false){
      this.normatividadService.guardarTipoNormatividad(this.tipoNormatividad).subscribe(respuesta =>{
        console.log(JSON.stringify(respuesta.body));
        this.listaTipoNormatividad.push(respuesta.body);
        alert(respuesta.mensaje)
        this.limpiarFormulario();
      });
    }else{
      this.tipoNormatividad.id = this.idTipoNormativa;
      console.log(JSON.stringify(this.tipoNormatividad));
      this.normatividadService.actualizarTipoNormatividad(this.tipoNormatividad).subscribe(respuesta =>{
        this.limpiarFormulario();
        this.editar = false;
        this.obtenerTodoTipoNormativa();
      })
    }
  }

  limpiarFormulario() {
    this.gestionarTipoNormatividadForm.reset();
  }

  cancelar(){
    this.gestionarTipoNormatividadForm.reset();
  }

  editarTipoNormatividad(tipoNorma: TipoNormativaDTO){
    this.editar = true;
    this.idTipoNormativa = tipoNorma.id;
    this.gestionarTipoNormatividadForm.controls.nombre.setValue(tipoNorma.nombre);
  }


  eliminarTipoNormatividad(id){
    this.normatividadService.eliminarTipoNormatividad(id).subscribe(respuesta => {
      console.log('esta es la respuesta: '+respuesta);
      this.obtenerTodoTipoNormativa();
    })
  }
}

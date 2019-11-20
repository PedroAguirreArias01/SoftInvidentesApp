import {Component} from '@angular/core';
/**
 * @description clase que representa el footer
 * @author Pedro Aguirre Arias <pedro.aguirre@uptc.edu.co>
 */
@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html'
})
export class FooterComponent {
  public autor: any = {nombre: 'Pedro', apellido: 'Aguirre Arias'};
}

import { Component, OnInit } from '@angular/core';
import { AuthService } from '../services/auth.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  constructor(
    public authService: AuthService,
    private router: Router) { }

  ngOnInit() {

  }

  salir(){
    this.authService.salir()
    Swal.fire('Salir', 'Has cerrado sesión con exito!','success');
    this.router.navigate(['/login']);
  }

}

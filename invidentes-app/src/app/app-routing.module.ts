import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PaginaPricipalComponent } from './pagina-pricipal/pagina-pricipal.component';
import { UsuarioComponent } from './usuario/usuario.component';
import { PqrsFormComponent } from './pqrs-form/pqrs-form.component';
import { NormativaFormComponent } from './normativa-form/normativa-form.component';
import { UsuarioFormComponent } from './usuario/usuario-form.component';
import { QuienesSomosComponent } from './quienes-somos/quienes-somos.component';
import { PoliticasComponent } from './politicas/politicas.component';
import { GestionarRolComponent } from './gestionar-rol/gestionar-rol.component';
import { LoginComponent } from './login/login.component';
import { AdministracionComponent } from './administracion/administracion.component';
import { AuthGuard } from './usuario/guards/auth.guard';


const routes: Routes = [
  {path: '', redirectTo: '/paginaPrincipal', pathMatch: 'full'},
  {path: 'paginaPrincipal', component: PaginaPricipalComponent},
  {path: 'colaboradores', component: UsuarioComponent, canActivate:[AuthGuard] },
  {path: 'pqrsForm', component: PqrsFormComponent},
  {path: 'normativaForm', component: NormativaFormComponent, canActivate:[AuthGuard]},
  {path: 'cearColaborador', component: UsuarioFormComponent, canActivate:[AuthGuard]},
  {path: 'quienesSomos', component: QuienesSomosComponent},
  {path: 'politicas', component: PoliticasComponent},
  {path: 'gestionarRol', component: GestionarRolComponent, canActivate:[AuthGuard]},
  {path: 'login', component: LoginComponent},
  {path: 'administracion', component: AdministracionComponent, canActivate:[AuthGuard]},
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

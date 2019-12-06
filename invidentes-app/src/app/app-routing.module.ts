import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PaginaPricipalComponent } from './pagina-pricipal/pagina-pricipal.component';
import { ColaboradorComponent } from './colaborador/colaborador.component';
import { PqrsFormComponent } from './pqrs-form/pqrs-form.component';
import { NormativaFormComponent } from './normativa-form/normativa-form.component';
import { ColaboradorFormComponent } from './colaborador/colaborador-form.component';
import { QuienesSomosComponent } from './quienes-somos/quienes-somos.component';


const routes: Routes = [
  {path: '', redirectTo: '/paginaPrincipal', pathMatch: 'full'},
  {path: 'paginaPrincipal', component: PaginaPricipalComponent},
  {path: 'colaboradores', component: ColaboradorComponent },
  {path: 'pqrsForm', component: PqrsFormComponent},
  {path: 'normativaForm', component: NormativaFormComponent},
  {path: 'cearColaborador', component: ColaboradorFormComponent},
  {path: 'quienesSomos', component: QuienesSomosComponent}

]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

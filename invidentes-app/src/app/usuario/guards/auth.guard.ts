import { Injectable } from '@angular/core';
import { CanActivate, CanActivateChild, CanLoad, Route, UrlSegment, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthService } from 'src/app/services/auth.service';

/**
 * Calse encargada de univel de seguridad a las rutas
 */
@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate, CanActivateChild, CanLoad {

  constructor(private authService: AuthService,
    private router: Router) {

  }

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    if (this.authService.isAuthenticated) {
      if (this.isTokenExpirado()) {
        this.authService.salir();
        this.router.navigate(['/login'])
        return false;
      }
      return true;
    }
    this.router.navigate(['/login'])
    return false;
  }

  canActivateChild(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
      if (this.authService.isAuthenticated) {
        if (this.isTokenExpirado()) {
          this.authService.salir();
          this.router.navigate(['/login'])
          return false;
        }
        return true;
      }
      this.router.navigate(['/login'])
      return false;
  }

  canLoad(
    route: Route,
    segments: UrlSegment[]): Observable<boolean> | Promise<boolean> | boolean {
      if (this.authService.isAuthenticated) {
        if (this.isTokenExpirado()) {
          this.authService.salir();
          this.router.navigate(['/login'])
          return false;
        }
        return true;
      }
      this.router.navigate(['/login'])
      return false;
  }

  /**
   * Se verifica si el token a expirado
   */
  isTokenExpirado() {
    const token = this.authService.token;
    const payLoad = this.authService.obtenerDatosToken(token);
    let now = new Date().getTime() / 1000;
      if (payLoad.exp < now) {
        return true;
      }
      return false;
  }
}

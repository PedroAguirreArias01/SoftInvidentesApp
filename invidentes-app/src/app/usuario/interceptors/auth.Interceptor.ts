import { HttpInterceptor, HttpEvent, HttpRequest, HttpHandler } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';
/**
 * Clase encaragada de intertceptar toda peticion http y asignar las cabeceras 
 * con el token de autorización
 * @author Pedro Aguirre Arias <pedro.aguirre@uptc.edu.co>
 */
@Injectable()
export class AuthInterceptor implements HttpInterceptor{

    constructor(private authService: AuthService){

    }
    
    /**
     * Interceptor de peticion http se valida que el token no sea nulo y se asignan los headers
     * @param req peticion http
     * @param next siguiente
     */
    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        const authToken = this.authService.token;
        if(authToken != null){
            const authaRequest = req.clone({
                headers: req.headers.set('Authorization','Bearer '+ authToken)
            });
            return next.handle(authaRequest);
        }
        return next.handle(req);
    }
}

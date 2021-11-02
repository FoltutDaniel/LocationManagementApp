import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LoginInfo } from '../common/login-info';
import { User } from '../common/user';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  
  loginUrl = "http://localhost:8080/user/login";
  constructor(private http: HttpClient) { }

  login(loginInfo: LoginInfo): Promise<User>{
    
    return this.http.post<User>(this.loginUrl, loginInfo).toPromise();
  }
}

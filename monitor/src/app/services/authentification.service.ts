import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LoginInfo } from '../common/login-info';
import { User } from '../common/user';

@Injectable({
  providedIn: 'root'
})
export class AuthentificationService {
  
  baseUrl = "http://localhost:8080/user";
  constructor(private http: HttpClient) { }

  login(loginInfo: LoginInfo): Promise<User>{
    
    return this.http.post<User>(this.baseUrl + "/login", loginInfo).toPromise();
  }

  register(userInfo: User): Promise<number>{

    return this.http.post<number>(this.baseUrl + "/register", userInfo).toPromise();
  }
}

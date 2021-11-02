import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginInfo } from 'src/app/common/login-info';
import { User } from 'src/app/common/user';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginInfo: LoginInfo = new LoginInfo;
  currentUser!: User;

  loginForm = new FormGroup({
    username: new FormControl(''),
    password: new FormControl('')
  });

  constructor(private loginService: LoginService, private _router: Router) { }

  ngOnInit(): void {
  }

  onSubmit(){
    this.loginInfo.username = this.loginForm.controls['username'].value;
    this.loginInfo.password = this.loginForm.controls['password'].value;

    this.loginService.login(this.loginInfo).then(
      data => {
        this.currentUser = data;
        console.log(this.currentUser);

        sessionStorage.setItem("username",this.currentUser.username);
        sessionStorage.setItem("id",this.currentUser.id +'');
        sessionStorage.setItem("role",this.currentUser.role);

        this._router.navigateByUrl("menu");

      }
    )
    
  }

}

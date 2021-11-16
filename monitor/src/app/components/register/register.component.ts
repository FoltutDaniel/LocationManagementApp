import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginInfo } from 'src/app/common/login-info';
import { User } from 'src/app/common/user';
import { AuthentificationService } from 'src/app/services/authentification.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  registerInfo: User = new User;
  currentUser!: User;

  registerForm = new FormGroup({
    username: new FormControl(''),
    password: new FormControl(''),
    role: new FormControl('')
  });
  
  constructor(private authService: AuthentificationService, private _router: Router) { }

  ngOnInit(): void {

  }

  onSubmit(){
    this.registerInfo.username = this.registerForm.controls['username'].value;
    this.registerInfo.password = this.registerForm.controls['password'].value;
    this.registerInfo.role = this.registerForm.controls['role'].value;

    this.authService.register(this.registerInfo).then(
      data => {
        console.log(data);
      }
    )
    this._router.navigateByUrl('login');
    
  }

}

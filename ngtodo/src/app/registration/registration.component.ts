import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { RegistrationService } from '../registration.service';
import { User } from '../user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css'],
})
export class RegistrationComponent implements OnInit {
  user = new User();
  msg = ' ';

  constructor(private _service: RegistrationService, private _router: Router) {}

  ngOnInit(): void {}

  registerUser(form: NgForm) {
    this._service.registerUserFromRemote(this.user).subscribe(
      (data) => {
        console.log('response received');
        this.msg = 'Registration successful';
        this._router.navigate(['/login']);
        form.reset();
      },
      (error) => {
        console.log('exception occured');
        this.msg = 'Registration fails';
        form.reset();
      }
    );
  }
}

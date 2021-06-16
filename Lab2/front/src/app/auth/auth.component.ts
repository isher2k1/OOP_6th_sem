import {Input, Component, Output, EventEmitter, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';
import {Resp} from './user';
import {environment} from '../../environments/environment';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css']
})
export class AuthComponent implements OnInit {
  form: FormGroup = new FormGroup({
    userid: new FormControl(''),
    password: new FormControl(''),
  });

  @Input() error: string | null;

  @Output() submitEM = new EventEmitter();

  constructor(private http: HttpClient, private router: Router) {
  }

  ngOnInit(): void {
    localStorage.clear();
  }

  submit(): void {
    if (this.form.valid) {
      this.submitEM.emit(this.form.value);
    }
    console.log(this.form.value.userid);
    const autJson = {
      userId: this.form.value.userid,
      password: this.form.value.password
    };

    this.http.post(environment.serverUrl + '/user/login', autJson, {responseType: 'json'}).subscribe(
      (data: Resp) => {
        localStorage.setItem('accessToken', data.accessToken);
        localStorage.setItem('userId', data.userId);
        this.error = null;
        this.router.navigate(['/table']);
        return data.accessToken;
      },
      error => {
        this.error = 'try again';
        // ToDo
      }
    );
    return null;
  }
}


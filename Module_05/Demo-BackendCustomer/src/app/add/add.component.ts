import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {CustomerServiceService} from '../customer-service.service';
import {ICustomer} from '../icustomer';
import {Router} from '@angular/router';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {
  newCustomerForm: FormGroup;

  constructor(
    private router: Router,
    private customerService: CustomerServiceService,
    private fb: FormBuilder) {
  }

  ngOnInit(): void {
    this.newCustomerForm = this.fb.group({
      username: [null],
      password: [null]
    });
  }

  createNewCustomer() {
    let newCustomer: ICustomer;
    newCustomer = this.newCustomerForm.value;
    this.customerService.create(newCustomer).subscribe(() => {
      alert('Them moi thanh cong!');
    }, error => {
      alert('Loi!');
    });
    this.router.navigate(['/']);
  }
}

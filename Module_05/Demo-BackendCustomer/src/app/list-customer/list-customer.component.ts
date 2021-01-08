import {Component, OnInit} from '@angular/core';
import {ICustomer} from '../icustomer';
import {CustomerServiceService} from '../customer-service.service';

@Component({
  selector: 'app-list-customer',
  templateUrl: './list-customer.component.html',
  styleUrls: ['./list-customer.component.css']
})
export class ListCustomerComponent implements OnInit {
  listCustomer: ICustomer[];

  constructor(private customerService: CustomerServiceService) {
  }

  ngOnInit(): void {
    this.getAllCustomers();
  }

  getAllCustomers(): ICustomer[] {
    this.customerService.getAllCustomers().subscribe((data: any) => {
      this.listCustomer = data;
    });
    return this.listCustomer;
  }

}

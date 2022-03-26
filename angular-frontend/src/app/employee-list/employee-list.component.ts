import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

  employees: Employee[] = [];

  constructor() { }

  ngOnInit(): void {
    this.employees = [
      {
        "id": 1,
        "firstName": "everson",
        "lastName": "mariano",
        "emailId": "everson@yahoo.com.br"
      },
      {
        "id": 2,
        "firstName": "beta",
        "lastName": "ouriques",
        "emailId": "beta@hotmail.com"
      },
      {
        "id": 3,
        "firstName": "maria",
        "lastName": "paula",
        "emailId": "maria@gmail.com"
      },
      {
        "id": 4,
        "firstName": "pedro",
        "lastName": "igor",
        "emailId": "pedro@gmail.com"
      }
    ]

  }

}

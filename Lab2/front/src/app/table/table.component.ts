import {Component, OnInit} from '@angular/core';
import {animate, state, style, transition, trigger} from '@angular/animations';
import {DatabaseConnectionService} from '../services/database-connection.service';
import {PageEvent} from '@angular/material/paginator';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css'],
  animations: [
    trigger('detailExpand', [
      state('collapsed', style({height: '0px', minHeight: '0'})),
      state('expanded', style({height: '*'})),
      transition('expanded <=> collapsed', animate('225ms cubic-bezier(0.4, 0.0, 0.2, 1)')),
    ]),
  ],
})

export class TableComponent implements OnInit {
  pageSize = 10;
  pageSizeOptions: number[] = [5, 10, 25, 100];
  databaseConnection;
  expandedElement: any = null;
  currentElement: any = null;
  pageIndex: number;

  constructor(databaseConnection: DatabaseConnectionService) {
    this.databaseConnection = databaseConnection;
    this.pageIndex = 0;
  }

  ngOnInit(): void {
    this.currentElement = [];
    console.log(this.currentElement);
  }

  countPage($event: PageEvent): void {
    this.pageSize = $event.pageSize;
    this.pageIndex = $event.pageIndex;
  }

  onSave(): void {
    this.databaseConnection.update(this.expandedElement, this.currentElement);
    console.log(this.expandedElement);
    console.log(this.currentElement);
  }

  cloneObject(object): any {
    return JSON.parse(JSON.stringify(object));
  }

  delete(): void {
    this.databaseConnection.delete(this.expandedElement);
    console.log('delete');
    console.log(this.expandedElement);
  }
}

import {Component, OnInit} from '@angular/core';
import {DatabaseConnectionService} from '../services/database-connection.service';

@Component({
  selector: 'app-tables-menu',
  templateUrl: './tables-menu.component.html',
  styleUrls: ['./tables-menu.component.css']
})
export class TablesMenuComponent implements OnInit {
  databaseConnection: DatabaseConnectionService;

  constructor(databaseConnection: DatabaseConnectionService) {
    this.databaseConnection = databaseConnection;
  }

  changeTable(table: string): void {
    this.databaseConnection.currentTable = table;
    this.databaseConnection.refreshTable();
  }

  ngOnInit(): void {
  }
}

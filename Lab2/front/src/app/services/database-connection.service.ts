import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Router} from '@angular/router';
import {environment} from '../../environments/environment';
import {Resp} from '../auth/user';

@Injectable({
  providedIn: 'root'
})
export class DatabaseConnectionService {
  currentTable: string;
  currentTableInfo = {
    name: 'table',
    columns: ['id'],
    lines: []
  };
  tableNames: string[];

  currentInsertTable: string;
  currentInsertTableInfo = {
    name: 'table',
    columns: ['id'],
    lines: []
  };
  tableInsertNames: string[];

  constructor(private http: HttpClient, private router: Router) {
    this.refreshAll();
  }

  refreshAll(): void {
    let header = new HttpHeaders();
    header = header.append('Authorization', 'Bearer ' + localStorage.getItem('accessToken'));

    this.http.get(environment.serverUrl + '/tables?id=' + localStorage.getItem('userId'), {
      responseType: 'json',
      headers: header
    }).subscribe(
      (data: string[]) => {
        this.tableNames = data;
        this.currentTable = this.tableNames === null ? null : this.tableNames[0];
        this.refreshTable();
        console.log(this.currentTable);
        console.log(this.currentTableInfo);
      },
      error => {
        localStorage.clear();
        this.router.navigate(['/login']);
      }
    );
  }

  insertTables(): void {
    let header = new HttpHeaders();
    header = header.append('Authorization', 'Bearer ' + localStorage.getItem('accessToken'));

    this.http.get(environment.serverUrl + '/insert?id=' + localStorage.getItem('userId'), {
      responseType: 'json',
      headers: header
    }).subscribe(
      (data: string[]) => {
        this.tableInsertNames = data;
        this.currentInsertTable = this.tableInsertNames === null ? null : this.tableInsertNames[0];
        this.refreshTable();
        console.log(this.currentInsertTable);
        console.log(this.currentInsertTableInfo);
      },
      error => {
        this.router.navigate(['/insert']);
      }
    );
  }

  refreshTable(): void {
    let header = new HttpHeaders();
    header = header.append('Authorization', 'Bearer ' + localStorage.getItem('accessToken'));
    this.http.get(environment.serverUrl + '/' + this.currentTable.toLocaleLowerCase(), {responseType: 'json', headers: header}).subscribe(
      (data: TableInfo) => {
        this.currentTableInfo = data;
      },
      (error) => {
        this.currentTableInfo = {
          name: 'table',
          columns: ['id'],
          lines: []
        };
        localStorage.clear();
        this.router.navigate(['/login']);
      }
    );
  }

  update(S, D): void {
    let header = new HttpHeaders();
    header = header.append('Authorization', 'Bearer ' + localStorage.getItem('accessToken'));
    this.http.post(environment.serverUrl + '/update/' + this.currentTable.toLocaleLowerCase(),
      {
        id: localStorage.getItem('userId'),
        source: S,
        destin: D
      }, {headers: header, responseType: 'json'}).subscribe(
      (data: Resp) => {
        // this.router.navigate(['/table']);
        this.refreshTable();
        return true;
      },
      error => {
        console.log(error);
        this.refreshTable();
        return false;
        // ToDo
      }
    );
  }

  delete(S): void {
    let header = new HttpHeaders();
    header = header.append('Authorization', 'Bearer ' + localStorage.getItem('accessToken'));
    this.http.post(environment.serverUrl + '/delete/' + this.currentTable.toLocaleLowerCase(),
      {
        id: localStorage.getItem('userId'),
        source: S
      }, {headers: header, responseType: 'json'}).subscribe(
      (data: Resp) => {
        this.refreshTable();
        return true;
      },
      error => {
        console.log(error);
        this.refreshTable();
        return false;
        // ToDo
      }
    );
  }

  insert(S): void {
    let header = new HttpHeaders();
    header = header.append('Authorization', 'Bearer ' + localStorage.getItem('accessToken'));
    this.http.post(environment.serverUrl + '/insert/' + this.currentTable.toLocaleLowerCase(),
      {
        id: localStorage.getItem('userId'),
        source: S
      }, {headers: header, responseType: 'json'}).subscribe(
      (data: Resp) => {
        this.refreshTable();
        return true;
      },
      error => {
        console.log(error);
        this.refreshTable();
        return false;
        // ToDo
      }
    );
  }

}

export interface TableInfo {
  name: string;
  columns: string[];
  lines: any;
}

// export interface TableLine {
//   categoryNumber: number;
//   categoryName: string;
// }


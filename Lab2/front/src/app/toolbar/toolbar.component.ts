import {Component, OnInit, ɵgetLContext} from '@angular/core';
import {DatabaseConnectionService} from '../services/database-connection.service';
import jspdf from 'jspdf';
import 'jspdf-autotable';

@Component({
  selector: 'app-toolbar',
  templateUrl: './toolbar.component.html',
  styleUrls: ['./toolbar.component.css']
})
export class ToolbarComponent implements OnInit {

  constructor(private databaseConnection: DatabaseConnectionService) {
    this.databaseConnection = databaseConnection;
  }

  ngOnInit(): void {
  }

  print(): void {
    let doc: any;
    doc = new jspdf();

    doc.setFontSize(18);
    doc.text(this.databaseConnection.currentTableInfo.name, 11, 8);
    doc.setFontSize(11);
    doc.setTextColor(100);
    const head = [[]];
    const body = [];
    console.log(this.databaseConnection.currentTableInfo.lines);
    for (const el of this.databaseConnection.currentTableInfo.columns) {
      head[0].push(el);
    }
    let i = 0;
    for (const el of this.databaseConnection.currentTableInfo.lines) {
      for (const col of this.databaseConnection.currentTableInfo.columns) {
        body.push([]);
        body[i].push(el[col]);
      }
      i++;
    }
    (doc as any).autoTable({
      head: head,
      body: body,
      theme: 'plain',
      didDrawCell: data => {
        console.log(data.column.index);
      }
    });
    doc.output('dataurlnewwindow');
    doc.save('myteamdetail.pdf');
  }
}

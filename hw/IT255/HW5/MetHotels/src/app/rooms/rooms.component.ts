import {Component, Input, OnInit} from '@angular/core';
import {MatDialog, MatDialogConfig} from "@angular/material/dialog";
import {AddRoomDialogComponent, Room} from "./add-room-dialog/add-room-dialog.component";

@Component({
  selector: 'rooms',
  templateUrl: './rooms.component.html',
  styleUrls: ['./rooms.component.css']
})
export class RoomsComponent implements OnInit {
  search: number = 0;

  public roomsList = [
    {
      sprat: 1,
      soba: 1,
      cena: 1600,
      opis: "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
    },
    {
      sprat: 1,
      soba: 2,
      cena: 1000,
      opis: "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
    },
    {
      sprat: 1,
      soba: 3,
      cena: 1800,
      opis: "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
    },
    {
      sprat: 1,
      soba: 4,
      cena: 1200,
      opis: "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
    },
    {
      sprat: 2,
      soba: 1,
      cena: 2600,
      opis: "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
    },
    {
      sprat: 2,
      soba: 2,
      cena: 2000,
      opis: "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
    },
    {
      sprat: 2,
      soba: 3,
      cena: 2400,
      opis: "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
    },
    {
      sprat: 2,
      soba: 4,
      cena: 2200,
      opis: "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
    },
  ]

  constructor(private dialog: MatDialog) {
  }

  ngOnInit(): void {
  }

  openAddRoomDialog() {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.autoFocus = true;
    const dialogRef = this.dialog.open(AddRoomDialogComponent, dialogConfig);
    dialogRef.afterClosed().subscribe(room => {
      console.log(room.data);
      this.roomsList.push(room);
      console.log(this.roomsList);
    })
  }

  shuffle() {
    const rooms = this.roomsList;
    for (let i = rooms.length - 1; i > 0; i--){
      let j = Math.floor(Math.random() * (i + 1));
      let temp = rooms[i];
      rooms[i] = rooms[j];
      rooms[j] = temp;
    }

  }

}

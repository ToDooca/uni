import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'rent-a-car',
  templateUrl: './rent-a-car.component.html',
  styleUrls: ['./rent-a-car.component.css']
})
export class RentACarComponent implements OnInit {

  public carsList = [
    {
      brend: "Toyota",
      model: "Prius",
      cena: 3400,
      opis: "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
    },
    {
      brend: "Mazda",
      model: "3",
      cena: 3000,
      opis: "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
    },
    {
      brend: "Volkswagen",
      model: "Polo",
      cena: 2600,
      opis: "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
    },
    {
      brend: "Audi",
      model: "X5",
      cena: 6200,
      opis: "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
    },
  ]

  constructor() {
  }

  ngOnInit(): void {
  }


}

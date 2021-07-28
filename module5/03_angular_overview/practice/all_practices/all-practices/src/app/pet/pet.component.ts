import { Component, OnInit } from '@angular/core';
import {Pet} from '../pet';

@Component({
  selector: 'app-pet',
  templateUrl: './pet.component.html',
  styleUrls: ['./pet.component.css']
})
export class PetComponent implements OnInit {
  pet: Pet = {
    name: 'puppie',
    image: 'https://th.bing.com/th/id/R.70deda079f5c04d2e266112ed9bb9040?rik=3lP0KjgxrkIzPA&pid=ImgRaw'
  };
  constructor() { }

  ngOnInit() {
  }

}

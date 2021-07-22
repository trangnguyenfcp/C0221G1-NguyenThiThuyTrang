import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-color',
  templateUrl: './color.component.html',
  styleUrls: ['./color.component.css']
})
export class ColorComponent implements OnInit {
  color: any;
  constructor() { }

  ngOnInit(): void {
  }
  changeColor(value: any) {
    this.color = value;

  }
}

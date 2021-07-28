import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {
  result: any;
  constructor() { }

  ngOnInit(): void {
  }
  public calculate(firstNumber:string, secondNumber:string, operator:string):number{
    let firstNum:number = parseInt(firstNumber);
    let secondNum:number = parseInt(secondNumber);
    switch (operator) {
      case '+':
        return this.result = firstNum + secondNum;
      case '-':
        return this.result = firstNum - secondNum;
      case '*':
        return this.result = firstNum * secondNum;
      case '/':
        return this.result = firstNum / secondNum;
    }
  }

}
